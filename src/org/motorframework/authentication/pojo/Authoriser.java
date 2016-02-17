package org.motorframework.authentication.pojo;
/** 
 * ��Ȩ�û�ʵ���ࡣ������֤�û��Ƿ�Ϸ�
 * @author WeitienWong<br>
 * �������ڣ�2015��10��5�� ����2:06:43 
 * @since 1.0.0
 * @version 1.0.0
 */
public class Authoriser {
	//��Ȩ�û���
	private String username;
	//��Ȩ����
	private String password;
	//��Ȩ����
	private String authType;
	//��Ȩ����
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
