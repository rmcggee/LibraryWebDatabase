package controller;



import java.time.LocalDate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Book;
import model.Customer;



public class CustomerHelper {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibraryWebDatabase");
	EntityManager em = emf.createEntityManager();
	public CustomerHelper(EntityManager em) {
		this.em = em;
	}
	public Customer createCustomer(String name,LocalDate checkoutDate, Book book) {
		Customer customer = new Customer(name,checkoutDate,book);
		em.getTransaction().begin();
		em.persist(customer);
		em.getTransaction().commit();
		em.persist(customer);
		 return customer;
	}
		
	

	public void deleteCustomer(Customer toDelete) {
		
		em.getTransaction().begin();
		System.out.println("Delete:"+toDelete.toString());
		TypedQuery<Customer> typedQuery = em.createQuery("select d from Customer d where d.id = :selectedId", Customer.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", toDelete.getId());
		// we only want one result
		typedQuery.setMaxResults(1);
		// get the result and save it into a new list item
		Customer result = typedQuery.getSingleResult();
		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	public Customer findCustomer(int id) {
		return em.find(Customer.class, id);
	}

	
public List<Customer> viewAllCustomers() {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Customer> allCustomer = em.createQuery("SELECT i FROM Customer i").getResultList();
	return	allCustomer;
	}
	public Customer searchForCustomerById(int idToEdit) {
		// TODO Auto-generated method stub
		Customer found = em.find(Customer.class,idToEdit);
		return	found;
	}
}
