package controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.BookLocation;
import model.Customer;


/**
 * Servlet implementation class CustomerNavigationServlet
 */
@WebServlet("/CustomerNavigationServlet")
public class CustomerNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibraryWebDatabase");
		EntityManager em = emf.createEntityManager();
		String act = request.getParameter("doThisToList");
		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewCustomersServlet").forward(request, response);
		} else if (act.equals("delete")) {
			try {
				int tempCustomerLocationId = Integer.parseInt(request.getParameter("id"));
				CustomerHelper help = new CustomerHelper(em);
				Customer customer = help.searchForCustomerById(tempCustomerLocationId);
				help.deleteCustomer(customer);
				
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
			} finally {
				getServletContext().getRequestDispatcher("/success.html").forward(request, response);
			}
		
		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/viewBookListServlet").forward(request, response);

		}
		else if (act.contentEquals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				CustomerHelper help = new CustomerHelper(em);
				Customer itemToEdit = help.searchForCustomerById(tempId);
				request.setAttribute("itemToEdit", itemToEdit);
				BookLocationHelper blh = new BookLocationHelper();
				List<BookLocation> abc = blh.getLists();
				
				request.setAttribute("allLists", abc);
				if (abc.isEmpty()) {
					request.setAttribute("allLists", " ");
				}
				}catch (NumberFormatException e) {
					System.out.println("Forgot to select an item");
				}
			finally {
				getServletContext().getRequestDispatcher("/editCustomer.jsp").forward(request, response);
			}
		}
	}

}
