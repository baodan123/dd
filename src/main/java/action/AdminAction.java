package action;

import java.util.List;



import sly.service.AdminService;
import sly.service.AdminServiceImpl;

import com.opensymphony.xwork2.Action;

import sly.entity.Admin;


public class AdminAction {
	public List<Admin>admins;
	public String username;
	public String password;
	public String login(){
		AdminService as =new AdminServiceImpl();
		admins = as.findAll();
		for (Admin admin : admins) {
			if(username.equals(admin.getUsername())&&password.equals(admin.getPassword())){
				return Action.SUCCESS;
			}
		}return "no";
		
	}
	public List<Admin> getAdmins() {
		return admins;
	}
	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
