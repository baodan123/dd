package sly.entity;

import java.util.List;

public class Type {
	private String id;
	private String name;
	private String parent;
	private String levels;
	private List<Type> second;
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Type(String id, String name, String parent, String levels) {
		super();
		this.id = id;
		this.name = name;
		this.parent = parent;
		this.levels = levels;
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
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getLevels() {
		return levels;
	}
	public void setLevels(String levels) {
		this.levels = levels;
	}

	
	public List<Type> getSecond() {
		return second;
	}
	public void setSecond(List<Type> second) {
		this.second = second;
	}
	@Override
	public String toString() {
		return "Type [id=" + id + ", name=" + name + ", parent=" + parent
				+ ", levels=" + levels + "]";
	}
	
	
}
