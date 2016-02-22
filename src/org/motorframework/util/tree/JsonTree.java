package org.motorframework.util.tree;

import java.io.Serializable;
import java.util.Iterator;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 树形结构实体类
 * @author WeitienWong 创建日期：2016年2月18日 下午3:34:40
 */
public class JsonTree  implements Serializable {

	private static final long serialVersionUID = 1L;

	private JSONArray nodes;
	private String key = "id";
	private String parentKey = "parentId";
	private String childrenKey = "children";
	private JSONArray roots = new JSONArray();
	private JSONArray tree;
	
	public JsonTree(){
	}
	public JsonTree(JSONArray nodes){
		this.nodes = nodes;
	}
	public JSONArray getTree() {
		getRoots();
		tree = buildTree(roots);
		return tree;
	}
	
	/**
	 * Create tree branch
	 * @param parents
	 * @return
	 */
	private JSONArray buildTree(JSONArray parents){
		for(int i=0;i<parents.size();i++){
			JSONObject parent = parents.getJSONObject(i);
			JSONArray childArr = getChildren(parent.getString(key));
			if(childArr.size()>0){
				parent.put(childrenKey, buildTree(childArr));
			}
		}
		return parents;
	}
	
	/**
	 * Get root nodes
	 */
	private void getRoots(){
		Iterator it = this.nodes.iterator();
		while(it.hasNext()){
			JSONObject  obj = JSONObject.fromObject(it.next());
			String pId = obj.getString(parentKey);
			if(pId==null||"".equals(pId)){
				roots.add(obj);
				it.remove();
			}
		}
	}
	
	/**
	 * Get child nodes by parent node-key
	 * @param id   parent node-key
	 * @return
	 */
	private JSONArray getChildren(String id){
		JSONArray children = new JSONArray();
		Iterator it = this.nodes.iterator();
		while(it.hasNext()){
			JSONObject obj = JSONObject.fromObject(it.next());
			if(id.equals(obj.getString(parentKey))){
				children.add(obj);
			}
		}
		return children;
	}
	public JSONArray getNodes() {
		return nodes;
	}
	public void setNodes(JSONArray nodes) {
		this.nodes = nodes;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getParentKey() {
		return parentKey;
	}
	public void setParentKey(String parentKey) {
		this.parentKey = parentKey;
	}
	public String getChildrenKey() {
		return childrenKey;
	}
	public void setChildrenKey(String childrenKey) {
		this.childrenKey = childrenKey;
	}
}
