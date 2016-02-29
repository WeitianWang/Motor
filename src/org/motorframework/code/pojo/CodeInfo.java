package org.motorframework.code.pojo;

import java.io.Serializable;
import java.util.List;

public class CodeInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String packageName;
	private String className;
	private String jspPath;
	private List<Property> properties;
	
	public CodeInfo(){
		super();
	}
	public CodeInfo(String packageName, String className) {
		super();
		this.packageName = packageName;
		this.className = className;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public List<Property> getProperties() {
		return properties;
	}
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
	public String getJspPath() {
		return jspPath;
	}
	public void setJspPath(String jspPath) {
		this.jspPath = jspPath;
	}
}
