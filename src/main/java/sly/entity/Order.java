package sly.entity;

import java.util.Date;

public class Order {
	private String id;
	private Double total;
	private String status;
	private Date create_date;
	private String order_number;
	private Address address;
	private User user;
	private String address_id;
	private String user_id;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Order(String id, Double total, String status, Date create_date,
			String order_number, String address_id, String user_id) {
		super();
		this.id = id;
		this.total = total;
		this.status = status;
		this.create_date = create_date;
		this.order_number = order_number;
		this.address_id = address_id;
		this.user_id = user_id;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Double getTotal() {
		return total;
	}



	public void setTotal(Double total) {
		this.total = total;
	}



	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getOrder_number() {
		return order_number;
	}

	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}

	public String getAddress_id() {
		return address_id;
	}
	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", total=" + total + ", status=" + status
				+ ", create_date=" + create_date + ", order_number="
				+ order_number + ", address_id=" + address_id + ", user_id="
				+ user_id + "]";
	}
	
	
	
}
