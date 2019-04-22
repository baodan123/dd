package sly.service;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import sly.dao.AddressDao;
import utils.MybatisUtil;
import sly.entity.Address;
import sly.entity.User;

public class AddressServiceImpl implements AddressService{

	@Override
	public List<Address> findAll() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		AddressDao addressdao = sqlSession.getMapper(AddressDao.class);
		List<Address> addresses = addressdao.findAll();
		return addresses;
	}

	@Override
	public void add(Address address) {
		SqlSession sqlSession=MybatisUtil.getSqlSession();
		AddressDao addressdao = sqlSession.getMapper(AddressDao.class);
		try {
			String id = UUID.randomUUID().toString();
			address.setId(id);
			addressdao.add(address);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException("添加addressService出错");
		}finally{
			MybatisUtil.close();
		}
		
	}

	@Override
	public void update(Address address) {
		SqlSession sqlSession=MybatisUtil.getSqlSession();
		AddressDao addressdao = sqlSession.getMapper(AddressDao.class);
		try {
			addressdao.update(address);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException("修改adressService出错");
		}finally{
			MybatisUtil.close();
		}
		
	}

	@Override
	public List<Address> findByUserId() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		AddressDao addressdao = sqlSession.getMapper(AddressDao.class);
		HttpSession session=ServletActionContext.getRequest().getSession();
		//获取登录对象
		User loginUser=(User) session.getAttribute("loginUser");
		
		List<Address> list = addressdao.findByUserId(loginUser.getId());
		return list;
	}

	@Override
	public Address findByAddressId(String address_id) {
		System.out.println("ads"+address_id);
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		AddressDao addressdao = sqlSession.getMapper(AddressDao.class);
		Address address = addressdao.findById(address_id);
		return address;
	}
	
}
