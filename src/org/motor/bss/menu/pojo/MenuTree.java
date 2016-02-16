package org.motor.bss.menu.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Weitian Wang 创建日期：2016年1月14日 下午3:34:40
 */
public class MenuTree implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Menu> tree;

	public MenuTree(List<Menu> menus) {
		tree = buildNode(getRoots(menus), menus);
	}

	/**
     * Set the children of a node
     * 
     * @param nodes
     * @param list
     * @return
     */
    private List<Menu> buildNode(List<Menu> parentNodes, List<Menu> nodes) {
        for(int i = 0; i < parentNodes.size(); i++) {
        	Menu node = parentNodes.get(i);
            List<Menu> children = getChildren(node,nodes);
            if(children.size() > 0) {
                node.setChildren(buildNode(children, nodes));
            }
        }
        return parentNodes;
    }
	 /**
     * Get the children
     * @param list
     * @param gen
     * @return
     */
    private List<Menu> getChildren(Menu root,List<Menu> Menus) {
        List<Menu> children = new ArrayList<Menu>();
        for(Menu Menu : Menus) {
            if(root.getId().equals(Menu.getPid())) {
                children.add(Menu);
            }
        }
        return children;
    }
	/**
     * Get the roots
     * 
     * @param list
     * @return
     */
	private List<Menu> getRoots(List<Menu> list) {
		List<Menu> roots = new ArrayList<Menu>();
		for (Menu m : list) {
			if (m.getPid() == null) {
				roots.add(m);
			}
		}
		return roots;
	}

	public List<Menu> getTree() {
		return tree;
	}

}
