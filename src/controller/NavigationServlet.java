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
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		BookHelper bh = new BookHelper();
		BookLocationHelper blh = new BookLocationHelper();
		String act = request.getParameter("doThisToList");
		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewBookListServlet").forward(request, response);
		} else if (act.equals("delete")) {
			try {
				int tempBookLocationId = Integer.parseInt(request.getParameter("id"));
				BookLocation deleteBookLocation = blh.searchForItemById(tempBookLocationId);
				Book delBook = deleteBookLocation.getMyBook();
				blh.deleteItem(deleteBookLocation);
				bh.deleteItem(delBook);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
			} finally {
				getServletContext().getRequestDispatcher("/viewBookListServlet").forward(request, response);
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
	}
}