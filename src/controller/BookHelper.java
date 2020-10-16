package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Book;

public class BookHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("LibraryWebDatabase");

	public void insertBook(Book myBook) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(myBook);
		em.getTransaction().commit();
		em.close();
	}

	public List<Book> showAllBooks() {
		EntityManager em = emfactory.createEntityManager();
		List<Book> allBookList = em.createQuery("SELECT s FROM Book s").getResultList();
		return allBookList;
		}
	

	public List<Book> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<Book> allDetails = em.createQuery("SELECT d FROM Book d").getResultList();
		return allDetails;
	}

	public void deleteItem(Book toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		//System.out.println("Delete:"+toDelete.toString());
		TypedQuery<Book> typedQuery = em
				.createQuery("select d from Book d where d.bookId = :selectedId", Book.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", toDelete.getBookId());
		// we only want one result
		typedQuery.setMaxResults(1);
		// get the result and save it into a new list item
		Book result = typedQuery.getSingleResult();
		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public Book searchForItemById(int idToEdit)	{
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		Book found	=	em.find(Book.class,idToEdit);
		em.close();
		return	found;
	}

	public void updateList(Book toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
