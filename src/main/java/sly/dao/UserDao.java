package sly.dao;

import org.apache.ibatis.annotations.Param;

import sly.entity.User;

public interface UserDao extends BaseDao<User>{
	public User findByEmail(String email);
	
	public void active(@Param("id")String id,@Param("inputEmailCode")String inputEmailCode);
	
	public void change(String id);
	
}
