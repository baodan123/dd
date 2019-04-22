package sly.entity;

public class Address {
	private String id;
	private String name;
	private String address;
	private String zip_code;
	private String phone;
	private String user_id;
	private User user;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String id, String name, String address, String zip_code,
			String phone, String user_id) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.zip_code = zip_code;
		this.phone = phone;
		this.user_id = user_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + ", address=" + address
				+ ", zip_code=" + zip_code + ", phone=" + phone + ", user_id="
				+ user_id + "]";
	}
	
}
