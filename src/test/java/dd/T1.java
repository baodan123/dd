package dd;

import java.util.List;

import org.junit.Test;

import sly.dao.AdminDao;
import sly.dao.BookDao;
import sly.dao.OrderDao;
import sly.dao.TypeDao;
import sly.dao.UserDao;
import sly.entity.Admin;
import sly.entity.Book;
import sly.entity.Order;
import sly.entity.Type;
import sly.entity.User;
import utils.MybatisUtil;

public class T1 {

	@Test
	public void test() {
		UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
		List<User> users = userDao.findAll();
		for (User user : users) {
			System.out.println(user);
			
		}
	}
	@Test
	public void caxunAdmin(){
		AdminDao admindao = MybatisUtil.getSqlSession().getMapper(AdminDao.class);
		List<Admin> admins = admindao.findAll();
		for (Admin admin : admins) {
			System.out.println(admin);
		}
	}
	@Test
	public void caxunOrder(){
		OrderDao orderDAO = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
		List<Order> osders = orderDAO.findAll();
		for (Order order : osders) {
			System.out.println(order);
		}
	}
	@Test
	public void boos(){
		BookDao bookdao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
		List<Book> books = bookdao.findAll();
		for (Book book : books) {
			System.out.println(book);
		}
	}
	@Test
	public void Typefind(){
		TypeDao typeDao = MybatisUtil.getSqlSession().getMapper(TypeDao.class);
		List<Type> types = typeDao.findAll();
		for (Type type : types) {
			System.out.println(type);
		}
	}
	@Test
	public void w(){
		BookDao bookdao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
		List<Book> findByName = bookdao.findByName("小说", null);
		for (Book book : findByName) {
			System.out.println(book);
		}
	}
}
