package action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;




import org.apache.struts2.ServletActionContext;





import sly.service.UserService;
import sly.service.UserServiceImpl;
import utils.MD5Utils;
import utils.SendEmailUtil;
import utils.VerifyCodeUtils;

import com.opensymphony.xwork2.Action;

import sly.entity.User;

public class UserAction {
	private UserService us=new UserServiceImpl();
	private User user;
	private String inputCode;
	private String message;
	private String inputEmailCode;
	private List<User> users;
	private String id;
	public String findAll(){
		users=us.findAll();
		return Action.SUCCESS;
	}
	//修改激活状态
	public String change(){
		us.change(id);
		return Action.SUCCESS;
	}
	public String regist(){
		System.out.println(user);
		try {
			us.regist(user, inputCode);
			return Action.SUCCESS;
		} catch (Exception e) {
			message=e.getMessage();
			return Action.ERROR;
		}
		
	}
	//向邮箱发salt
	public String sendEmail(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		String salt=MD5Utils.getSalt();
		User loginUser =(User) session.getAttribute("loginUser");
		session.setAttribute("emailCode", salt);
		SendEmailUtil.sendMessage(loginUser.getEmail(), salt);
		return Action.SUCCESS;
	}
	//验证码
		public void getImage() throws IOException{
			String generateVerifyCode = VerifyCodeUtils.generateVerifyCode(4);
			ServletActionContext.getRequest().getSession().setAttribute("c1", generateVerifyCode);
			System.out.println("验证码："+generateVerifyCode);
			BufferedImage image = VerifyCodeUtils.getImage(200, 50, generateVerifyCode);
			ServletOutputStream outputStream = ServletActionContext.getResponse().getOutputStream();
			ImageIO.write(image, "png", outputStream);
			
		}
		//激活
		public String active(){
			try {
				us.active(inputEmailCode);
				return Action.SUCCESS;
			} catch (Exception e) {
				message=e.getMessage();
				return Action.ERROR;
			}
		}
		//登录
		public String login(){
			try {
				us.login(user);
				return Action.SUCCESS;
			} catch (Exception e) {
				message=e.getMessage();
				return Action.ERROR;
			}
		}
		//退出
		public String exit(){
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.invalidate();
			return Action.SUCCESS;
		}
		
		
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public String getInputCode() {
			return inputCode;
		}
		public void setInputCode(String inputCode) {
			this.inputCode = inputCode;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getInputEmailCode() {
			return inputEmailCode;
		}
		public void setInputEmailCode(String inputEmailCode) {
			this.inputEmailCode = inputEmailCode;
		}
		public List<User> getUsers() {
			return users;
		}
		public void setUsers(List<User> users) {
			this.users = users;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		
}	
