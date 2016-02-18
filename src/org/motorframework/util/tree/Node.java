package org.motorframework.util.tree;

import java.io.Serializable;
import java.util.List;

public abstract class Node implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String parentId;
	private List<Node> children;
	
	public abstract String getId() ;
	
	public void setId(String id) {
		this.id = id;
	}
	public abstract String getName() ;
	
	public void setName(String name) {
		this.name = name;
	}
	public abstract String getParentId();
	
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public List<Node> getChildren() {
		return children;
	}
	public void setChildren(List<Node> children) {
		this.children = children;
	}
}
