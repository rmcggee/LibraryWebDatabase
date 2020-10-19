package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.Customer;


/**
 * Servlet implementation class EditCustomerServlet
 */
@WebServlet("/EditCustomerServlet")
public class EditCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCustomerServlet() {
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
		// TODO Auto-generated method stub
		 DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibraryWebDatabase");
		EntityManager em = emf.createEntityManager();
		CustomerHelper help = new CustomerHelper(em);
		BookHelper bhelp = new BookHelper();
		
		
		String name = request.getParameter("name");
		String date = request.getParameter("date");
		LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Customer itemToUpdate = help.searchForCustomerById(tempId);
		Book bookItemToUpdate = bhelp.searchForItemById(bookId);
		itemToUpdate.setName(name);
		itemToUpdate.setCheckoutDate(localDate);
		itemToUpdate.setBook(bookItemToUpdate);
		
				
		help.updateItem(itemToUpdate);

		getServletContext().getRequestDispatcher("/success.html").forward(request,response);
	}

}
