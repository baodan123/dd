package sly.service;

import java.util.List;

import sly.entity.Address;

public interface AddressService {
	public List<Address> findAll();
	
	public void add(Address address);
	public void update(Address address);
	
	public List<Address> findByUserId();
	
	public Address findByAddressId(String address_id);
}
