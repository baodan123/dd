package sly.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import sly.entity.Book;

public interface BookDao extends BaseDao<Book> {
	public List<Book> findBy(@Param("key") String key,
			@Param("content") String content);

	public Book findById(String id);

	// 推荐
	public List<Book> findRecommend();

	// 销量前八
	public List<Book> findBySale();

	// 新上架前八
	public List<Book> findByCreateDate();

	// 新书热卖10
	public List<Book> findByNewAndCreateDate();
	
	//根据分类名查询
	public List<Book> findByName(@Param("fname")String fname,@Param("sname")String sname);
	
	//更新库存销量
	public void updateCount(@Param("id")String id,@Param("count")Integer count);
}
