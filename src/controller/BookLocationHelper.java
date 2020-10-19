package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.BookLocation;

public class BookLocationHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("LibraryWebDatabase");

	public void insertBookLocation(BookLocation myBookLocation) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(myBookLocation);
		em.getTransaction().commit();
		em.close();
	}

	public List<BookLocation> getLists() {
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<BookLocation> allBookLocationess = em.createQuery("SELECT d FROM BookLocation d").getResultList();
		return allBookLocationess;
	}

	public BookLocation searchForItemById(int idToEdit)	{
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		BookLocation found	=	em.find(BookLocation.class,idToEdit);
		em.close();
		return	found;
	}
	
	public	void	deleteItem(BookLocation	toDelete)	{
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		System.out.println("Delete:"+toDelete.toString());
		TypedQuery<BookLocation> typedQuery	= em.createQuery("select li	from BookLocation li where li.locationId = :selectedBookLocationId",	BookLocation.class);
		//Substitute	parameter	with	actual	data	from	the	toDelete	item
		typedQuery.setParameter("selectedBookLocationId",	toDelete.getLocationId());
		//we	only	want	one	result
		typedQuery.setMaxResults(1);
		//get	the	result	and	save	it	into	a	new	list	item
		BookLocation	result	=	typedQuery.getSingleResult();
		//remove	it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}
	
	

}
