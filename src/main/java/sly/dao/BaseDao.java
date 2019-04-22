package sly.dao;

import java.util.List;



public interface BaseDao<T>{
	public void add(T t);
	public void delete(String id);
	public void update(T t);
	public List<T> findAll();
	public T findById(String id);
}	
