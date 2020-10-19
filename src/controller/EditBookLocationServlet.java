package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BookLocation;

/**
 * Servlet implementation class EditBookLocationServlet
 */
@WebServlet("/editBookLocationServlet")
public class EditBookLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBookLocationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		BookLocationHelper blh = new BookLocationHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		BookLocation itemToUpdate = blh.searchForItemById(tempId);
		String mySection = request.getParameter("section");
		String myShelf = request.getParameter("shelf");
		itemToUpdate.setSectionName(mySection);
		itemToUpdate.setShelfName(myShelf);
		blh.updateItem(itemToUpdate);
		getServletContext().getRequestDispatcher("/success.html").forward(request,response);
		
	}

}
