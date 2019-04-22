package sly.service;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;

import sly.dao.TypeDao;
import utils.MybatisUtil;
import sly.entity.Type;

public class TypeServiceImpl implements TypeService{

	@Override
	public void add(Type type) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		TypeDao typedao = sqlSession.getMapper(TypeDao.class);
		String uuid = UUID.randomUUID().toString();
		type.setId(uuid);
		try {
			typedao.add(type);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException("添加typeService出错");
		}finally{
			MybatisUtil.close();
		}
	}

	@Override
	public void delete(String id) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		TypeDao typedao = sqlSession.getMapper(TypeDao.class);
		try {
			typedao.delete(id);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException("删除typeService出错");
		}finally{
			MybatisUtil.close();
		}
		
	}

	@Override
	public List<Type> findAll() {
		TypeDao typedao = MybatisUtil.getSqlSession().getMapper(TypeDao.class);
		List<Type> types = typedao.findAll();
		return types; 
	}

	@Override
	public List<Type> findFirst() {
		TypeDao typedao = MybatisUtil.getSqlSession().getMapper(TypeDao.class);
		List<Type> types = typedao.findFirst();
		return types;
	}

	@Override
	public List<Type> findSecond() {
		TypeDao typedao = MybatisUtil.getSqlSession().getMapper(TypeDao.class);
		List<Type> types = typedao.findSecond();
		return types;
	}
	//查询1.2级分类
	@Override
	public List<Type> findOne() {
		TypeDao typedao = MybatisUtil.getSqlSession().getMapper(TypeDao.class);
		List<Type> types = typedao.findOne();
		return types;
	}

	@Override
	public List<Type> findByFirstName(String fname) {
		TypeDao typedao = MybatisUtil.getSqlSession().getMapper(TypeDao.class);
		List<Type> types = typedao.findByFirstName(fname);
		return types;
	}

	@Override
	public List<Type> findByFname(String fname) {
		TypeDao typedao = MybatisUtil.getSqlSession().getMapper(TypeDao.class);
		List<Type> types = typedao.findByFname(fname);
		return types;
	}
	
}
