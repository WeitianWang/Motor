package org.motorframework.util.security;

import java.text.SimpleDateFormat;


/** 
 * @author WeitienWong
 * �������ڣ�2015��10��5�� ����8:30:10 
 * ��˵�� ��
 */
public class Test {
	public static void main(String[] args) {
		MD5Encoder md5 = new MD5Encoder();
		System.out.println(md5.encode("superadmin"));
	}
}
