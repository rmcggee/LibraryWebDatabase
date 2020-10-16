package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.BookLocation;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/addBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// insertBook from screen information
		String myTitle = request.getParameter("title");
		String myAuthor = request.getParameter("author");
		String myCallNbrText = request.getParameter("callNbrText");
		Book myBook = new Book(myTitle, myAuthor, myCallNbrText);
		BookHelper bh = new BookHelper();
		bh.insertBook(myBook);
		
		// insertBookLocation from screenInformation
		String mySection = request.getParameter("sectionName");
		String myShelf = request.getParameter("shelfName");
		BookLocationHelper blh = new BookLocationHelper();
		BookLocation myBookLocation = new BookLocation(mySection, myShelf, myBook);
		blh.insertBookLocation(myBookLocation);
		
		getServletContext().getRequestDispatcher("/success.html").forward(request, response);
	}

}
