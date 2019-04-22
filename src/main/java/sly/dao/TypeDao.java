package sly.dao;

import java.util.List;

import sly.entity.Type;

public interface TypeDao extends BaseDao<Type>{
	public List<Type> findFirst();

	public List<Type> findSecond();
	public List<Type> findOne();
	
	//根据一级分类名查询
	public List<Type> findByFirstName(String fname);
	
	public List<Type> findByFname(String fname);
}
