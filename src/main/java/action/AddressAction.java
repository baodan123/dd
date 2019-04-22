package action;

import java.util.List;

import sly.service.AddressService;
import sly.service.AddressServiceImpl;

import com.opensymphony.xwork2.Action;

import sly.entity.Address;

public class AddressAction {
	private AddressService as=new AddressServiceImpl();
	private List<Address> list;
	//用户选择的地址id
	private String address_id;
	//根据用户选择的地址id返回的对象
	private Address address;
	public String findByUserId(){
		list=as.findByUserId();
		return Action.SUCCESS;
	}
	//
	public String findByAddressId(){
		System.out.println("ad"+address_id);
		address=as.findByAddressId(address_id);
		list=as.findByUserId();
		return Action.SUCCESS;
	}
	
	
	public List<Address> getList() {
		return list;
	}
	public void setList(List<Address> list) {
		this.list = list;
	}

	public String getAddress_id() {
		return address_id;
	}

	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
