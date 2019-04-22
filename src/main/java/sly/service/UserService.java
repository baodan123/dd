package sly.service;

import java.util.List;

import sly.entity.User;

public interface UserService {
	public void add(User user);
	public void delete(String id);
	public void update(User user);
	public List<User> findAll();
	
	public void regist(User user,String inputCode);
	
	public void active(String inputEmailCode);
	
	public void login(User user);
	
	public void change(String id);
}
