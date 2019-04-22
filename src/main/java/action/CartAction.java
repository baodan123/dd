package action;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import sly.service.BookService;
import sly.service.BookServiceImpl;

import com.opensymphony.xwork2.Action;

import sly.entity.Book;
import sly.entity.Item;

public class CartAction {
	private String bookid;
	private Integer num;
	private String id;
	private BookService bs=new BookServiceImpl();
	/*public String loginTest(){
		//获取Session
		HttpSession session=ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("loginUser");
		if(user.equals("") || user==null){
			return Action.ERROR;
		}else{
			return Action.SUCCESS;
		}
	}*/
	public String addCart(){
		//获取Session
		HttpSession session=ServletActionContext.getRequest().getSession();
		//从session获取购物车的map
		Map<String, Object> cart = (Map<String, Object>) session.getAttribute("cart");
		//第一次使用
		if(cart==null){
			cart=new HashMap<String,Object>();
		}
		//判断添加的图书是否存在
		if(cart.containsKey(bookid)){
			Item cartItem =(Item) cart.get(bookid);
			cartItem.setCounts(cartItem.getCounts()+1);
		}else{
			Item cartItem=new Item();
			Book book=bs.findById(bookid);
			cartItem.setBook(book);
			cartItem.setCounts(1);
			//放到map中
			cart.put(bookid, cartItem);
			session.setAttribute("cart", cart);
		}
		calc();
		return Action.SUCCESS;
	}
	//计算总金额和节省的钱
	public void calc(){
		//获取session
		HttpSession session=ServletActionContext.getRequest().getSession();
		Map<String, Object> cart=(Map<String, Object>) session.getAttribute("cart");
		Double total=0d;
		Double save=0d;
		//遍历Map计算
		for (Map.Entry<String, Object> entry : cart.entrySet()) {
			Item cartItem=(Item) entry.getValue();
			total+=cartItem.getCounts()*cartItem.getBook().getDd_price();
			save+=(cartItem.getBook().getPrice()-cartItem.getBook().getDd_price())*cartItem.getCounts();
		}
		session.setAttribute("total", total);
		session.setAttribute("save", save);
	}
	//删除购物车
	public String delete(){
		HttpSession session =ServletActionContext.getRequest().getSession();
		Map<String, Object> cart=(Map<String, Object>) session.getAttribute("cart");
		cart.remove(bookid);
		calc();
		return Action.SUCCESS;
	}
	//修改物品数量
	public String update(){
		HttpSession session =ServletActionContext.getRequest().getSession();
		Map<String, Object> cart=(Map<String, Object>) session.getAttribute("cart");
		System.out.println("ID:"+id);
		System.out.println("NUM:"+num);
		Item cartItem=(Item) cart.get(id);
		cartItem.setCounts(num);
		calc();
		return Action.SUCCESS;
	}
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
