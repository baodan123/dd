package sly.service;

import java.util.List;

import sly.entity.Book;

public interface BookService {
	public void add(Book book);
	public void delete(String id);
	public void update(Book book);
	public List<Book> findAll();
	public List<Book> findBy(String key,String content);
	public Book findById(String id);
	//推荐
	public List<Book> findRecommend();
	//销量前八
	public List<Book> findBySale();
	//新上架前八
	public List<Book> findByCreateDate();
	//新书热卖10
	public List<Book> findByNewAndCreateDate();
	//二级页面根据分类查询图书
	public List<Book> findByName(String fname,String sname);
	//
}
