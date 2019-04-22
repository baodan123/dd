package sly.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;

import utils.MybatisUtil;
import sly.dao.BookDao;
import sly.entity.Book;

public class BookServiceImpl implements BookService{

	@Override
	public void add(Book book) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BookDao bookdao = sqlSession.getMapper(BookDao.class);
		try {
			String uuid = UUID.randomUUID().toString();
			book.setId(uuid);
			bookdao.add(book);
			System.out.println("SS:"+book);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException("添加bookService出错");
		}finally{
			MybatisUtil.close();
		}
		
	}

	@Override
	public void delete(String id) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BookDao bookdao = sqlSession.getMapper(BookDao.class);
		try {
			bookdao.delete(id);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException("删除bookService出错");
		}finally{
			MybatisUtil.close();
		}
		
	}

	@Override
	public void update(Book book) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BookDao bookdao = sqlSession.getMapper(BookDao.class);
		try {
			System.out.println("SS:"+book);
			bookdao.update(book);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException("修改bookService出错");
		}finally{
			MybatisUtil.close();
		}
		
	}

	@Override
	public List<Book> findAll() {
		BookDao bookdao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
		List<Book> books = bookdao.findAll();
		return books;
	}

	@Override
	public List<Book> findBy(String key,String content) {
		BookDao bookdao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
		List<Book>books=bookdao.findBy( key,content);
		return books;
	}

	@Override
	public Book findById(String id) {
		BookDao bookdao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
		Book book = bookdao.findById(id);
		return book;
	}
	//随机推荐
	@Override
	public List<Book> findRecommend() {
		BookDao bookdao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
		List<Book> books = bookdao.findAll();
		MybatisUtil.close();
		Integer a=new Random().nextInt(books.size());
		Integer b=new Random().nextInt(books.size());
		List<Book> list=new ArrayList<Book>();
		list.add(books.get(a));
		list.add(books.get(b));
		return list;
	}
	//热销8
	@Override
	public List<Book> findBySale() {
		BookDao bookdao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
		List<Book> books = bookdao.findBySale();
		return books;
	}
	//新上架8
	@Override
	public List<Book> findByCreateDate() {
		BookDao bookdao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
		List<Book> books = bookdao.findByCreateDate();
		return books;
	}
	//新书热销10
	@Override
	public List<Book> findByNewAndCreateDate() {
		BookDao bookdao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
		List<Book> books = bookdao.findByNewAndCreateDate();
		return books;
	}
	//根据分类名查询
	@Override
	public List<Book> findByName(String fname, String sname) {
		BookDao bookdao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
		List<Book> books = bookdao.findByName(fname, sname);
		return books;
	}
	
}
