package sly.entity;

import java.util.Date;

public class Book {
	private String id;
	private String name;
	private String type_id;
	private Double price;
	private Double dd_price;
	private Integer stock;//库存
	private String author;
	private String press;//出版社
	private String edition;//版次
	private Date publish_date;
	private Date print_date;
	private String print_time;//印次
	private String isbn;
	private Integer format;//开本
	private Integer paper;//纸张
	private String pack;//包装
	private Integer page_num;//页数
	private Integer font_num;//字数
	private String cover;//封面
	private String recommendation;//编辑推荐
	private String summary;//内容简介
	private String resume;//作者简介
	private String catalog;//目录
	private String media;//媒体评论
	private Integer sales;//销量
	private Type type;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public Book(String id, String name, String type_id, Double price,
			Double dd_price, Integer stock, String author, String press,
			String edition, Date publish_date, Date print_date,
			String print_time, String isbn, Integer format, Integer paper,
			String pack, Integer page_num, Integer font_num,
			String recommendation, String summary, String resume,
			String catalog, String media, Integer sales) {
		super();
		this.id = id;
		this.name = name;
		this.type_id = type_id;
		this.price = price;
		this.dd_price = dd_price;
		this.stock = stock;
		this.author = author;
		this.press = press;
		this.edition = edition;
		this.publish_date = publish_date;
		this.print_date = print_date;
		this.print_time = print_time;
		this.isbn = isbn;
		this.format = format;
		this.paper = paper;
		this.pack = pack;
		this.page_num = page_num;
		this.font_num = font_num;
		this.recommendation = recommendation;
		this.summary = summary;
		this.resume = resume;
		this.catalog = catalog;
		this.media = media;
		this.sales = sales;
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

	
	public String getType_id() {
		return type_id;
	}

	public void setType_id(String type_id) {
		this.type_id = type_id;
	}

	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDd_price() {
		return dd_price;
	}
	public void setDd_price(Double dd_price) {
		this.dd_price = dd_price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public Date getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}
	public Date getPrint_date() {
		return print_date;
	}
	public void setPrint_date(Date print_date) {
		this.print_date = print_date;
	}
	public String getPrint_time() {
		return print_time;
	}
	public void setPrint_time(String print_time) {
		this.print_time = print_time;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Integer getFormat() {
		return format;
	}
	public void setFormat(Integer format) {
		this.format = format;
	}
	public Integer getPaper() {
		return paper;
	}
	public void setPaper(Integer paper) {
		this.paper = paper;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
	}
	public Integer getPage_num() {
		return page_num;
	}
	public void setPage_num(Integer page_num) {
		this.page_num = page_num;
	}
	public Integer getFont_num() {
		return font_num;
	}
	public void setFont_num(Integer font_num) {
		this.font_num = font_num;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getCatalog() {
		return catalog;
	}
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", type_id=" + type_id
				+ ", price=" + price + ", dd_price=" + dd_price + ", stock="
				+ stock + ", author=" + author + ", press=" + press
				+ ", edition=" + edition + ", publish_date=" + publish_date
				+ ", print_date=" + print_date + ", print_time=" + print_time
				+ ", isbn=" + isbn + ", format=" + format + ", paper=" + paper
				+ ", pack=" + pack + ", page_num=" + page_num + ", font_num="
				+ font_num + ", cover=" + cover + ", recommendation="
				+ recommendation + ", summary=" + summary + ", resume="
				+ resume + ", catalog=" + catalog + ", media=" + media
				+ ", sales=" + sales + "]";
	}
	

	
	
	
	
}
