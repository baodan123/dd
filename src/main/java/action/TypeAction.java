package action;

import java.util.List;

import sly.service.TypeService;
import sly.service.TypeServiceImpl;

import com.opensymphony.xwork2.Action;

import sly.entity.Type;

public class TypeAction {
	private List<Type> types;
	private Type type;
	private String id;
	TypeService ts=new TypeServiceImpl();
	//查询所有
	public String findAll(){
		types = ts.findAll();
		return Action.SUCCESS;
	}
	//添加一级标签
	public String addFirst(){
		ts.add(type);
		return Action.SUCCESS;
	}
	//添加二级标签
	public String addSecond(){
		ts.add(type);
		return Action.SUCCESS;
	}
	//添加二级标签前的查询一级标签
	public String findFirst(){
		types=ts.findFirst();
		return Action.SUCCESS;
	}
	//删除
	public String delete(){
		ts.delete(id);
		return Action.SUCCESS;
	}
	public List<Type> getTypes() {
		return types;
	}
	public void setTypes(List<Type> types) {
		this.types = types;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
