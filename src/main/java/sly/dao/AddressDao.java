package sly.dao;

import java.util.List;

import sly.entity.Address;

public interface AddressDao extends BaseDao<Address>{
	public List<Address> findByUserId(String id);
}
