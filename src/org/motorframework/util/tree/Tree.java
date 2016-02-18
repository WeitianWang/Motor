package org.motorframework.util.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 树形结构实体类
 * @author WeitienWong 创建日期：2016年2月18日 下午3:34:40
 */
public class Tree  implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Node> tree;
	private List<Node> nodes;
	private List<Node> roots = new ArrayList<Node>();
	
	public Tree(){
		
	}
	public Tree(List<Node> nodes){
		this.nodes = nodes;
		getRoots();
		tree = buildTree(roots);
	}
	
	/**
	 * Create tree branch
	 * @param parents
	 * @return branch list
	 */
	public List<Node> buildTree(List<Node> parents){
		for(int i=0;i<parents.size();i++){
			Node node =parents.get(i);
			List<Node> children = getChildren(node);
			if(children.size()>0){
				node.setChildren(buildTree(children));
			}
		}
		return parents;
	}
	
	/**
	 * Get the root nodes of the node collection
	 */
	public void getRoots(){
		Iterator<Node> it = this.nodes.iterator();
		while(it.hasNext()){
			Node n = it.next();
			if(n.getParentId()==null||"".equals(n.getParentId())){
				roots.add(n);
				it.remove();
			}
		}
	}
	
	/**
	 * Get children of a branch
	 * @param root
	 * @return
	 */
	public List<Node> getChildren(Node root){
		List<Node> children = new ArrayList<Node>();
		Iterator<Node> it = this.nodes.iterator();
		String parentId = root.getId();
		while(it.hasNext()){
			Node n = it.next();
			if(n.getParentId().equals(parentId)){
				children.add(n);
				it.remove();
			}
		}
		return children;
	}
	
	public List<Node> getTree() {
		return tree;
	}
	public List<Node> getNodes() {
		return nodes;
	}
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
}
