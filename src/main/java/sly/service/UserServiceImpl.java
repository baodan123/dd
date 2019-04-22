package sly.service;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;







import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import sly.dao.UserDao;
import utils.MD5Utils;
import utils.MybatisUtil;
import sly.entity.User;

public class UserServiceImpl implements UserService {

	@Override
	public void add(User user) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserDao userdao = sqlSession.getMapper(UserDao.class);
		try {
			String uuid = UUID.randomUUID().toString();
			user.setId(uuid);
			userdao.add(user);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException("添加userService出错");
		}finally{
			MybatisUtil.close();
		}
	}

	@Override
	public void delete(String id) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserDao userdao = sqlSession.getMapper(UserDao.class);
		try {
			userdao.delete(id);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException("删除userService出错");
		}finally{
			MybatisUtil.close();
		}
		
	}

	@Override
	public void update(User user) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserDao userdao = sqlSession.getMapper(UserDao.class);
		try {
			userdao.update(user);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException("修改userService出错");
		}finally{
			MybatisUtil.close();
		}
		
	}

	@Override
	public List<User> findAll() {
		UserDao userdao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
		List<User> users = userdao.findAll();
		MybatisUtil.close();
		return users;
	}

	@Override
	public void regist(User user, String inputCode) {
		UserDao userdao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
		//获取session
		HttpSession session = ServletActionContext.getRequest().getSession();
		String code = (String) session.getAttribute("c1");
		
		if (code.equalsIgnoreCase(inputCode)) {
			System.out.println("验证码输入正确");
			User checkUser =userdao.findByEmail(user.getEmail());
			if(checkUser !=null){
				throw new RuntimeException("该邮箱已注册");
			}else{
				user.setId(UUID.randomUUID().toString());
				user.setStatus("正常");
				String salt =MD5Utils.getSalt();
				user.setSalt(salt);
				//加密方式：密码+盐
				String password=MD5Utils.getPassword(user.getPassword()+salt);
				user.setPassword(password);
				/*System.out.println("SS注册前:"+user);*/
				try {
					userdao.add(user);
					/*System.out.println("SS注册:"+user);*/
					//为已注册用户登录
					session.setAttribute("loginUser", user);
					MybatisUtil.commit();
				} catch (Exception e) {
					MybatisUtil.rollback();
					throw new RuntimeException("这里注册失败");
				}finally{
					MybatisUtil.close();
				}
			}
		}else{
			throw new RuntimeException("验证码错误");
		}
		
	}
	
	@Override
	public void active(String inputEmailCode) {
		HttpSession session=ServletActionContext.getRequest().getSession();
		String emailCode=(String) session.getAttribute("emailCode");
		System.out.println("e"+emailCode);
		System.out.println("i"+inputEmailCode);
		if(emailCode.equals(inputEmailCode)){
			User loginUser=(User) session.getAttribute("loginUser");
			loginUser.setCode(inputEmailCode);
			try {
				UserDao userdao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
				userdao.active(loginUser.getId(), inputEmailCode);
				//重新覆盖登录用户
				session.setAttribute("loginUser", loginUser);
				MybatisUtil.commit();
			} catch (Exception e) {
				MybatisUtil.rollback();
				throw new RuntimeException("用户激活失败");
			}
		}else{
			throw new RuntimeException("邮箱验证码错误");
		}
	}

	@Override
	public void login(User user) {
		UserDao userdao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
		User checkUser=userdao.findByEmail(user.getEmail());
		//判断账号是否存在
		if(checkUser==null){
			throw new RuntimeException("用户不存在");
		}else {
			//判断密码是否正确
			if(checkUser.getPassword().equals(MD5Utils.getPassword(user.getPassword()
					+checkUser.getSalt()))){
					//判断是否冻结
				if(checkUser.getStatus().equals("正常")){
					HttpSession session = ServletActionContext.getRequest().getSession();
					session.setAttribute("loginUser", checkUser);
					System.out.println("登陆成功");
				}else{
					throw new RuntimeException("用户已冻结");
				}
			}else{
				throw new RuntimeException("密码错误");
			}
		}
		
	}

	@Override
	public void change(String id) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserDao userdao = sqlSession.getMapper(UserDao.class);
		try {
			userdao.change(id);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException("修改userService状态出错");
		}finally{
			MybatisUtil.close();
		}
		
		
	}
	
}
