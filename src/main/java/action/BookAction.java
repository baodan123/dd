package action;

import java.io.*;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

import sly.service.BookService;
import sly.service.BookServiceImpl;
import sly.service.TypeService;
import sly.service.TypeServiceImpl;

import com.opensymphony.xwork2.Action;

import sly.entity.Book;
import sly.entity.Type;


public class BookAction {
	public BookService bs=new BookServiceImpl();
	public TypeService ts=new TypeServiceImpl();
	public Book book;
	public List<Book> books;
	public String id;
	public List<Type> types;
	public String key;
	private String content;
	public List<Book> recommend;
	public List<Book> sales;
	public List<Book> createDate;
	public List<Book> newSales;
	private File file;
	private String fileFileName;
	private String fileCountType;
	private String fname;//一级分类name
	private String sname;//二级分类name
	
	//查询所有图书
	public String findAll(){
		books = bs.findAll();
		return Action.SUCCESS;
	}
	//模糊查询
	public String findBy(){
		books = bs.findBy(key,content);
		return Action.SUCCESS;
	}
	//按id查询
	public String findById(){
		book=bs.findById(id);
		return Action.SUCCESS;
	}
	//添加前的查询2级分类
	public String findSecond(){
		types = ts.findSecond();
		return Action.SUCCESS;
	}
	//添加图书
	public String add() throws IOException{
		System.out.println("Ac"+book);
		System.out.println(file);
    	System.out.println(fileFileName);
    	//获取输入流
        FileInputStream is=  new FileInputStream(file);
        //根据相对路径获取绝对路径名
        String realPath  =  ServletActionContext.getServletContext().getRealPath("/back/img");
        //获取输出流
        System.out.println(realPath);
        
        FileOutputStream os=new FileOutputStream(new  File(realPath,fileFileName));
        //文件拷贝
        //工具类copy
        IOUtils.copy(is, os);
        //优雅关流
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);
		book.setCover(getFileFileName());
		bs.add(book);
		return Action.SUCCESS;
	}
	
	//修改前的回显，查询
	public String updateEx(){
		book=bs.findById(id);
		types=ts.findSecond();
		return Action.SUCCESS;	
	}
	//修改图书
	public String update() throws IOException{
		System.out.println(book);
    	//获取输入流
        FileInputStream is=  new FileInputStream(file);
        //根据相对路径获取绝对路径名
        String realPath  =  ServletActionContext.getServletContext().getRealPath("/back/img");
        //获取输出流
        System.out.println(realPath);
        
        FileOutputStream os=new FileOutputStream(new  File(realPath,fileFileName));
        //文件拷贝
        //工具类copy
        IOUtils.copy(is, os);
        //优雅关流
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);
        book.setCover(getFileFileName());
		bs.update(book);
		return Action.SUCCESS;	
	}
	//删除图书
	public String delete(){
		bs.delete(id);
		return Action.SUCCESS;	
	}
	//主页的查询
	public String mainPage(){
		//一级二级分类
		types=ts.findOne();  
		//推荐
		recommend = bs.findRecommend();
		//销量
		sales = bs.findBySale();
		//新上架8
		createDate = bs.findByCreateDate();
		//新书热销8
		newSales = bs.findByNewAndCreateDate();
		return Action.SUCCESS;
	}
	//二级页面
	public String secondPage(){
		//根据1.2级分类查询图书
		books=bs.findByName(fname, sname);
		//根据一级分类名查询1.2级分类
		types=ts.findByFname(fname);

		return Action.SUCCESS;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Type> getTypes() {
		return types;
	}
	public void setTypes(List<Type> types) {
		this.types = types;
	}
	public List<Book> getRecommend() {
		return recommend;
	}
	public void setRecommend(List<Book> recommend) {
		this.recommend = recommend;
	}
	public List<Book> getSales() {
		return sales;
	}
	public void setSales(List<Book> sales) {
		this.sales = sales;
	}
	public List<Book> getCreateDate() {
		return createDate;
	}
	public void setCreateDate(List<Book> createDate) {
		this.createDate = createDate;
	}
	public List<Book> getNewSales() {
		return newSales;
	}
	public void setNewSales(List<Book> newSales) {
		this.newSales = newSales;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileCountType() {
		return fileCountType;
	}
	public void setFileCountType(String fileCountType) {
		this.fileCountType = fileCountType;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	

	
	
}
