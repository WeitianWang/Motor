package org.motorframework.util.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/** 
 * SHA��������40λSHA��
 * @author WeitienWong
 * �������ڣ�2015��10��4�� ����11:45:51 
 */
public class SHAEncoder implements MotorEncoder{

	/*** 
     * SHA���� ����40λSHA��
     * @param code �������ַ���
     * @return ����40λSHA��
     */
	@Override
	public String encode(String code) {
		MessageDigest sha = null;
		try {
			sha = MessageDigest.getInstance("SHA");
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
		byte[] shaBytes = sha.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for(int i=0;i<shaBytes.length;i++){
			int val = ((int)shaBytes[i])&0xff;
			if(val < 16){
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}

}
