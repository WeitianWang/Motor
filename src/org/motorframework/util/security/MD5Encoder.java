package org.motorframework.util.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/** 
 * MD5�㷨������
 * @author Weitian Wang �������ڣ�2015��10��4�� ����11:20:01 
 * @since 1.0.0
 * @version 1.0.0
 */
public class MD5Encoder implements MotorEncoder{
	/*** 
     * MD5���� ����32λmd5��
     * @param code �������ַ���
     * @return ����32λmd5��
     */
	@Override
	public String encode(String code){
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		byte[] byteArray = null;
		try {
			byteArray = code.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for(int i=0;i<md5Bytes.length;i++){
			int val = ((int)md5Bytes[i])&0xff;
			if(val < 16){
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}
	
}
