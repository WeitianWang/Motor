package org.motorframework.core.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/** 
 * <����Dao�ӿ�>
 * <p>�ṩ����־û��Ļ��������ӿڣ�������ɾ�Ĳ��Լ���ҳ�ȹ���
 * <h3>�����˵����</h3>
 * <p>T:�����࣬����̳�ʱ��ָ����������
 * <p>ID:�־û������������ͣ�����Ϊ�࣬��String,Integer��
 * @author Weitian Wang 2015��9��28�� ����1:29:42 
 * @since 1.0.0
 * @version 1.0.0
 */
public interface GenericDao<T,ID extends Serializable> {
	/**
	 * �־û�����
	 * @param t	�־û�����ʵ��
	 */
	public void save(T t);
	/**
	 * ��������ʵ��
	 * @param t	�־û�����ʵ��
	 */
	public void saveOrUpdate(T t);
	/**
	 * load��������ʵ��
	 * @param id ʵ������
	 * @return	ʵ�����
	 */
	public T load(ID id);
	/**
	 * get��������ʵ��
	 * @param id ʵ������
	 * @return	ʵ�����
	 */
	public T get(ID id);
	/**
	 * <contains>
	 * @param t �־û�����ʵ��
	 * @return	true��false
	 */
	public boolean contains(T t);
	/**
     * <delete>
     * <ɾ�����е�t����>
     * @param t ʵ�����
     */
	public void delete(T t);
	/**
     * <����IDɾ������>
     * @param id ʵ������
     * @return true��false
     */
	public boolean deleteById(ID id);
	/**
     * <ɾ�������е����ж���>
     * @param entities ʵ���Collection����
     */
	public void deleteAll(Collection<T> entities);
	/**
     * <ִ���޸Ļ�ɾ��Hql���>
     * @param hql HQL���
     * @param values ������������
     * @return �޸Ļ�ɾ���Ķ��������
     */
	public int executeHql(String hql,Object...values);
	
	/**
     * <ִ���޸Ļ�ɾ��Sql���>
     * @param sql SQL���
     * @param values ������������
     * @return �޸Ļ�ɾ���Ķ��������
     */
	public int executeSql(String sql,Object...values);
	/**
     * <����HQL������Ψһʵ��>
     * @param hql HQL���
     * @param values ����������Object����
     * @return ��ѯʵ��
     */
	public T getByHql(String hql,Object...values);
	 /**
     * <����SQL������Ψһʵ��>
     * @param sql SQL���
     * @param values ����������Object����
     * @return ��ѯʵ��
     */
	public T getBySql(String sql,Object...values);
	/**
     * <����HQL��䣬�õ���Ӧ��list>
     * @param hql HQL���
     * @param values ����������Object����
     * @return ��ѯ���ʵ���List����
     */
	public List<T> getListByHql(String hql,Object...values);
	/**
     * <����SQL��䣬�õ���Ӧ��list>
     * @param sql HQL���
     * @param values ����������Object����
     * @return ��ѯ���ʵ���List����
     */
	public List<T> getListBySql(String sql,Object...values);
	/**
     * <ˢ��ʵ��>
     * @param t ʵ�����
     */
	public void refresh(T t);
	/**
     * <����ʵ��>
     * 
     * @param t ʵ�����
     */
	public void update(T t);
}
