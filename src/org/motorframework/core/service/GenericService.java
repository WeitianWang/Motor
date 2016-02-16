package org.motorframework.core.service;

import java.io.Serializable;

/** 
 * <����Service�ӿ�>
 * <p>�ṩ����־û��Ļ��������ӿڣ�������ɾ�Ĳ��Լ���ҳ�ȹ���
 * <h3>�����˵����</h3>
 * <p>T:�����࣬����̳�ʱ��ָ����������
 * <p>ID:�־û������������ͣ�����Ϊ�࣬��String,Integer��
 * 
 * @author Weitian Wang
 * @since 1.0.0
 * @version 1.0.0
 * 
 */
public interface GenericService<T,ID extends Serializable> {
	/**
	 * �־û�����
	 * @param t �־û�ʵ�����
	 */
	public void save(T t);
	
	/**
	 * ����ID��ȡ�־û��������û�д�ID��Ӧ�Ķ����򷵻�null
	 * @param id	����
	 * @return	�־û�����ʵ����null
	 */
	public T get(ID id);
	
	/**
	 * ɾ������
	 * @param t
	 */
	public void delete(T t);
	
	/**
     * <����IDɾ������>
     * @param id ʵ������
     * @return true��false
     */
	public boolean deleteById(ID id);
}
