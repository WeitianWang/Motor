package org.motorframework.code.pojo;

public class Property {
	private String name;
	private String type;
	private boolean isPrimaryKey = false;
	//private String comments;
	
	public Property() {
		super();
	}
	public Property(String name, String type, boolean isPrimaryKey, String comments) {
		super();
		this.name = name;
		this.type = type;
		this.isPrimaryKey = isPrimaryKey;
		//this.comments = comments;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean getIsPrimaryKey() {
		return isPrimaryKey;
	}
	public void setIsPrimaryKey(boolean isPrimaryKey) {
		this.isPrimaryKey = isPrimaryKey;
	}
//	public String getComments() {
//		return comments;
//	}
//	public void setComments(String comments) {
//		this.comments = comments;
//	}
}
