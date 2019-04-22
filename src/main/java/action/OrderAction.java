package action;

import java.util.List;

import sly.service.OrderService;
import sly.service.OrderServiceImpl;
import utils.MybatisUtil;

import com.opensymphony.xwork2.Action;

import sly.dao.ItemDao;
import sly.entity.Address;
import sly.entity.Item;
import sly.entity.Order;

public class OrderAction {
	OrderService os=new OrderServiceImpl();
	private List<Order> orders;
	private Address address;
	private Order order;
	private String id;
	private List<Item>items;
	//后台查询所有--连3表
	public String findAll(){
		orders=os.findAll();
		return Action.SUCCESS;
	}
	//详情
	public String detail(){
		ItemDao itemDao=MybatisUtil.getSqlSession().getMapper(ItemDao.class);
		items = itemDao.findByOrder(id);
		order=os.findById(id);
		return Action.SUCCESS;
	}
	//添加订单
	public String add(){
		os.addOrder(address);
		return Action.SUCCESS;
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
}
