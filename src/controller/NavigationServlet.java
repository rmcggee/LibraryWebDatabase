package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.BookLocation;


/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NavigationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookHelper bh = new BookHelper();
		BookLocationHelper blh = new BookLocationHelper();
		String act = request.getParameter("doThisToList");
		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewBookListServlet").forward(request, response);
		} else if (act.equals("delete")) {
			try {
				// book location id is saved by selection ofo the radio button
				int tempBookLocationId = Integer.parseInt(request.getParameter("id"));
				// find the book location object/row based on the id
				BookLocation deleteBookLocation = blh.searchForItemById(tempBookLocationId);
				// find the book instance from the POJO
				Book delBook = deleteBookLocation.getMyBook();
				// delete book location first because it contains the foreign key
				blh.deleteItem(deleteBookLocation);
				// delete the book second
				bh.deleteItem(delBook);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
			} finally {
				getServletContext().getRequestDispatcher("/success.html").forward(request, response);
			}
		} else if (act.equals("edit")) {
			try {
				// not done
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}
		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);

		}
		else if (act.contentEquals("checkout")) {
			try {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibraryWebDatabase");
		EntityManager em = emf.createEntityManager();
		LocalDate date = LocalDate.now();
		String name = request.getParameter("name");
		int tempBookLocationId = Integer.parseInt(request.getParameter("id"));
		BookLocation bookLocation = blh.searchForItemById(tempBookLocationId);
		Book book = bookLocation.getMyBook();
		CustomerHelper help = new CustomerHelper(em);
		help.createCustomer(name,date,book);
			}catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}
			finally {
			getServletContext().getRequestDispatcher("/success.html").forward(request, response);
		}
		}
	}
}
