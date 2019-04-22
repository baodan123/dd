package sly.service;

import java.util.List;

import sly.dao.AdminDao;
import utils.MybatisUtil;
import sly.entity.Admin;

public class AdminServiceImpl implements AdminService{

	@Override
	public List<Admin> findAll() {
		AdminDao admindao = MybatisUtil.getSqlSession().getMapper(AdminDao.class);
		List<Admin> admins = admindao.findAll();
		return admins;
	}
	
}
