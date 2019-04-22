package sly.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import sly.dao.AddressDao;
import sly.dao.BookDao;
import sly.dao.ItemDao;
import sly.dao.OrderDao;
import utils.MybatisUtil;
import sly.entity.Address;
import sly.entity.Item;
import sly.entity.Order;
import sly.entity.User;

public class OrderServiceImpl implements OrderService{

	@Override
	public void add(Order order) {
		OrderDao orderdao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
		try {
			String id=UUID.randomUUID().toString();
			order.setId(id);
			orderdao.add(order);
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
			throw new RuntimeException("添加orderSS出错");
		}finally{
			MybatisUtil.close();
		}
		
	}

	@Override
	public void delete(String id) {
		OrderDao orderdao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
		try {
			orderdao.delete(id);
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
			throw new RuntimeException("删除orderSS出错");
		}finally{
			MybatisUtil.close();
		}
		
	}

	@Override
	public List<Order> findAll() {
		OrderDao orderdao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
		List<Order> orders = orderdao.findAll();
		return orders;
	}

	@Override
	public void addOrder(Address address) {
		//获取session
		HttpSession session=ServletActionContext.getRequest().getSession();
		//获取用户
		User loginUser = (User) session.getAttribute("loginUser");
		System.out.println("登录用户："+loginUser);
		Double total=(Double) session.getAttribute("total");
		Map<String, Item> cart=(Map<String, Item>) session.getAttribute("cart");
		//获取dao
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		OrderDao orderdao = sqlSession.getMapper(OrderDao.class);
		AddressDao addressdao = sqlSession.getMapper(AddressDao.class);
		ItemDao itemdao = sqlSession.getMapper(ItemDao.class);
		BookDao bookdao = sqlSession.getMapper(BookDao.class);
		
		try {
			//1.判断是否是新地址
			if(address.getId()==null || "".equals(address.getId())){
				//新地址入库
				address.setId(UUID.randomUUID().toString());
				address.setUser_id(loginUser.getId());
				System.out.println("地址："+address);
				addressdao.add(address);
			}else{
				//旧地址，判断是否改变
				Address checkAddress=addressdao.findById(address.getId());
				if(!checkAddress.equals(address)){
					//不一样，修改地址
					System.out.println("地址："+address);
					addressdao.update(address);
				}
			}
			//2.添加订单
			Order order=new Order();
			order.setId(UUID.randomUUID().toString());
			java.util.Date date=new java.util.Date(); 
			order.setOrder_number(String.valueOf(date.getTime()));
			session.setAttribute("order_number", order.getOrder_number());
			order.setUser_id(loginUser.getId());
			order.setTotal(total);
			order.setCreate_date(date);
			order.setAddress_id(address.getId());
			order.setStatus("未支付");
			System.out.println("订单："+order);
			orderdao.add(order);
			//3.添加订单项
			for (Entry<String, Item> entry : cart.entrySet()) {
				Item orderItem =new Item();
				orderItem.setId(UUID.randomUUID().toString());
				orderItem.setBookid(entry.getKey());
				orderItem.setCounts(entry.getValue().getCounts());
				orderItem.setCreateDate(date);
				orderItem.setOrder_id(order.getId());
				//添加
				itemdao.add(orderItem);
				System.out.println("订单项："+orderItem);
				//修改图书销量和库存
				bookdao.updateCount(entry.getKey(), entry.getValue().getCounts());
			}
			//5.清空购物车
			session.removeAttribute("cart");
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
			throw  new RuntimeException("添加订单失败");
		}
	}

	@Override
	public Order findById(String id) {
		OrderDao orderdao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
		Order order = orderdao.findById(id);
		return order;
	}
	
	
}
