package sly.service;

import java.util.List;

import sly.entity.Address;
import sly.entity.Order;

public interface OrderService {
	public void add(Order order);
	public void delete(String id);
	public List<Order> findAll();
	
	public void addOrder(Address address);
	
	public Order findById(String id);
}
