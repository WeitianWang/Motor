package org.motorframework.authentication.pojo;
/** 
 * 授权用户实体类。用于认证用户是否合法
 * @author WeitienWong<br>
 * 创建日期：2015年10月5日 下午2:06:43 
 * @since 1.0.0
 * @version 1.0.0
 */
public class Authoriser {
	//授权用户名
	private String username;
	//授权密码
	private String password;
	//授权类型
	private String authType;
	//授权日期
	private String authDate;
	
	public Authoriser() {
		super();
	}

	public Authoriser(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Authoriser(String username, String password, String authType) {
		this.username = username;
		this.password = password;
		this.authType = authType;
	}

	public Authoriser(String username, String password, String authType,
			String authDate) {
		this.username = username;
		this.password = password;
		this.authType = authType;
		this.authDate = authDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthType() {
		return authType;
	}

	public void setAuthType(String authType) {
		this.authType = authType;
	}

	public String getAuthDate() {
		return authDate;
	}

	public void setAuthDate(String authDate) {
		this.authDate = authDate;
	}
	
}
