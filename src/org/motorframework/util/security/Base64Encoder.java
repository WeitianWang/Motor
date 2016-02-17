package org.motorframework.util.security;

import java.io.UnsupportedEncodingException;
import org.apache.tomcat.util.codec.binary.Base64;

/** 
 * Base64编码解码工具类，基于org.apache.tomcat.util.codec.binary.Base64
 * @author WeitienWong
 * 创建日期：2015年10月5日 下午9:24:32 
 * @since 1.0.0
 * @version 1.0.0
 */
public class Base64Encoder{

	/**
	 * Base64编码
	 * @param code 待编码字符串
	 * @return	Base64码
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
	 * Base64解码
	 * @param code	待解码字符串
	 * @return	解码后的字符串
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
