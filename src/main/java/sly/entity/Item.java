package sly.entity;

import java.util.Date;

public class Item {
	private String id;
	private String order_id;
	private Integer counts;
	private String bookid;
	private Date createDate;
	private Book book;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Item(String id, String order_id, Integer counts, String bookid,
			Date createDate) {
		super();
		this.id = id;
		this.order_id = order_id;
		this.counts = counts;
		this.bookid = bookid;
		this.createDate = createDate;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	
	
	public Integer getCounts() {
		return counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}

	
	public String getBookid() {
		return bookid;
	}



	public void setBookid(String bookid) {
		this.bookid = bookid;
	}



	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	


	public Book getBook() {
		return book;
	}



	public void setBook(Book book) {
		this.book = book;
	}



	@Override
	public String toString() {
		return "Item [id=" + id + ", order_id=" + order_id + ", counts="
				+ counts + ", bookid=" + bookid + ", createDate=" + createDate
				+ "]";
	}
	
	
}
