package org.motorframework.util.security;

import java.io.UnsupportedEncodingException;
import org.apache.tomcat.util.codec.binary.Base64;

/** 
 * Base64������빤���࣬����org.apache.tomcat.util.codec.binary.Base64
 * @author WeitienWong
 * �������ڣ�2015��10��5�� ����9:24:32 
 * @since 1.0.0
 * @version 1.0.0
 */
public class Base64Encoder{

	/**
	 * Base64����
	 * @param code �������ַ���
	 * @return	Base64��
	 */
	public String encode(String code) {
		String encode = null;
		try {
			byte[] bytes = Base64.encodeBase64(code.getBytes("UTF-8"));
			encode = new String(bytes);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encode;
	}
	
	/**
	 * Base64����
	 * @param code	�������ַ���
	 * @return	�������ַ���
	 */
	public String decode(String code){
		String encode = null;
		try {
			byte[] bytes = Base64.decodeBase64(code.getBytes("UTF-8"));
			encode = new String(bytes);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encode;
	}
}
