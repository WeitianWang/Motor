package org.motorframework.core.service.impl;

import java.io.Serializable;

import org.motorframework.core.dao.GenericDao;
import org.motorframework.core.service.GenericService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/** 
 * <����Serviceʵ����>
 * <p>�ṩ����־û��Ļ���������������ɾ�Ĳ��Լ���ҳ�ȹ���
 * <h3>�����˵����</h3>
 * <p>T:�����࣬����̳�ʱ��ָ����������
 * <p>ID:�־û������������ͣ�����Ϊ�࣬��String,Integer��
 * @author Weitian Wang
 * @since version 1.0.0
 * @version 1.0.0
 * @see org.motorframework.core.service.GenericService
 * 
 */
public abstract class GenericServiceImpl<T,ID extends Serializable> implements GenericService<T,ID> {

	public abstract GenericDao<T,ID> getDao();
	
	/**
	 * �־û�����
	 * @param t �־û�ʵ�����
	 */
	@Transactional
	public void save(T t) {
		getDao().save(t);
	}
	
	/**
	 * get������ȡ����
	 * @param id ��������
	 * @return T����
	 */
	@Transactional(readOnly=true)
	public T get(ID id){
		return getDao().get(id);
	}
	
	/**
	 * <ɾ������>
	 * @param t
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void delete(T t){
		getDao().delete(t);
	}
	/**
     * <����IDɾ������>
     * @param id ʵ������
     * @return true��false
     */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean deleteById(ID id){
		return getDao().deleteById(id);
	}
}
