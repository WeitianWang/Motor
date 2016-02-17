package org.motorframework.util.security;

import java.text.SimpleDateFormat;


/** 
 * @author WeitienWong
 * 创建日期：2015年10月5日 下午8:30:10 
 * 类说明 ：
 */
public class Test {
	public static void main(String[] args) {
		MD5Encoder md5 = new MD5Encoder();
		System.out.println(md5.encode("superadmin"));
	}
}
