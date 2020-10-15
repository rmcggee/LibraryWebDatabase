import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import controller.CustomerHelper;

public class testHelper {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibraryWebDatabase");
		EntityManager em = emf.createEntityManager();
		CustomerHelper help = new CustomerHelper(em);
		System.out.println(help.viewAllCustomers());
	}
}
