import java.time.LocalDate;
import java.util.List;

import controller.BookHelper;
import controller.BookLocationHelper;

import model.Book;
import model.BookLocation;

public class FirstTestAddBookAndLocation {

	public static void main(String[] args) {

		Book myBook = new Book("The Hate You Give", "Angie Thompson", "Th7890");
		BookHelper bh = new BookHelper();
		bh.insertBook(myBook);

		BookLocationHelper blh = new BookLocationHelper();
		BookLocation myBookLocation = new BookLocation("YA", "76CC", myBook);
		blh.insertBookLocation(myBookLocation);

		List<BookLocation> allLists = blh.getLists();
		for (BookLocation a : allLists) {
			System.out.println(a.toString());
		}
	}

}
