package org.motor.bss.menu.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import net.sf.json.JSONString;

import org.hibernate.annotations.GenericGenerator;

/** 
 * 系统菜单实体类
 * @author Weitian Wang
 * 创建日期：2016年1月12日 下午3:25:55 
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED )
@Table(name="M_MENU")
public class Menu implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String pid;
	private String uri;
	private String icon;
	private Integer order;
	private String target;
	private List<Menu> children = new ArrayList<Menu>();
	
	/**
	 * 以下属性为fancyTree空件所需属性
	 */
	private String key;
	private String title;
	//private String extraClasses;
	
	
	public Menu(){
		
	}

	public Menu(String id){
		this.id = id;
	}
	public Menu(String id, String name, String pid, String uri, String icon) {
		super();
		this.id = id;
		this.name = name;
		this.pid = pid;
		this.uri = uri;
		this.icon = icon;
	}
	
	@Id
	@Column(name="MENU_ID")
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid",strategy="uuid")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name="MENU_NAME",nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="MENU_PID")
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	@Column(name="MENU_URI")
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Column(name="MENU_ICON")
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	@Column(name="MENU_ORDER")
	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}
	
	@Column(name="MENU_TARGET")
	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
	
	@Transient
	public List<Menu> getChildren() {
		return children;
	}
	public void setChildren(List<Menu> children) {
		this.children = children;
	}


	@Transient
	public String getKey() {
		return id;
	}

	
	@Transient
	public String getTitle() {
		return name;
	}

	
//	@Transient
//	public String getExtraClasses() {
//		return icon;
//	}
}
