package dd;

import java.util.List;

import org.junit.Test;

import sly.entity.Book;
import sly.service.BookService;
import sly.service.BookServiceImpl;

public class TestService {

	@Test
	public void test() {
		BookService bs=new  BookServiceImpl();
		List<Book> books = bs.findAll();
		for (Book book : books) {
			System.out.println(book);
		}
	}
	@Test
	public void testBookupdate(){
		BookService bs=new BookServiceImpl();
		List<Book> books = bs.findAll();
		for (Book book : books) {
			System.out.println(book);
			book.setAuthor("zhangshan");
			bs.update(book);
		}
	}
}
