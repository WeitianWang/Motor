package org.motorframework.core.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.motorframework.core.dao.GenericDao;
import org.springframework.util.Assert;

/** 
 * <����Dao�ӿ�>
 * <p>�ṩ����־û��Ļ��������ӿڣ�������ɾ�Ĳ��Լ���ҳ�ȹ���
 * <h3>�����˵����</h3>
 * <p>T:�����࣬����̳�ʱ��ָ����������
 * <p>ID:�־û������������ͣ�����Ϊ�࣬��String,Integer��
 * @author WeitienWong 2015��9��28�� ����1:29:42 
 * @since 1.0.0
 * @version 1.0.0
 * @see org.motorframework.core.dao.GenericDao
 */
public class GenericDaoImpl<T,ID extends Serializable> implements GenericDao<T,ID>{
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	//����Class
	protected Class<T> genericClass;
	
	public GenericDaoImpl(){
		//��ȡ���͸���
		Type type = getClass().getGenericSuperclass();
		//���û��ʵ��ParameterizedType�ӿ�,����֧�ַ�
		if(type instanceof ParameterizedType){
			Type[] types = ((ParameterizedType)type).getActualTypeArguments();
			genericClass = (Class<T>) types[0];
		}else{
			System.out.println("��֧�ַ���");
		}
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected SessionFactory getSessionFactory(){
		Assert.isNull(sessionFactory,"����sessionFactoryΪ�գ�����������Ƿ�������ȷ��");
		return this.sessionFactory;
	}
	
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	/**
	 * �־û�����
	 * @param t	�־û�����ʵ��
	 */
	@Override
	public void save(T t) {
		this.getSession().save(t);
	}

	/**
	 * ��������ʵ��
	 * @param t	�־û�����ʵ��
	 */
	@Override
	public void saveOrUpdate(T t) {
		this.getSession().saveOrUpdate(t);
		
	}

	/**
     * <load>
     * <����ʵ���load����>
     * @param id ʵ���id
     * @return ��ѯ������ʵ��
     */
	@Override
	public T load(ID id) {
		T t = (T)this.getSession().load(genericClass, id);
		return t;
	}
	
	/**
     * <get>
     * <����ʵ���get����>
     * @param id ʵ���id
     * @return ��ѯ������ʵ��
     */
	@Override
	public T get(ID id) {
		T t = (T)this.getSession().get(genericClass, id);
		
		return t;
	}

	/**
     * <contains>
     * <�������Ƿ������session��>
     * @param t ʵ��
     * @return �Ƿ����
     */
	@Override
	public boolean contains(T t) {
		return this.getSession().contains(t);
	}

	/**
     * <delete>
     * <ɾ�����е�t����>
     * @param t ʵ��
     */
	@Override
	public void delete(T t) {
		this.getSession().delete(t);
	}

	/**
     * <����IDɾ������>
     * @param id ʵ������
     * @return true��false
     */
	@Override
	public boolean deleteById(ID id) {
		T t = get(id);
		if(t == null)
			return false;
		delete(t);
		return true;
	}
	/**
     * <ɾ�������е����ж���>
     * @param entities ʵ���Collection����
     */
	@Override
	public void deleteAll(Collection<T> entities) {
		for(T t : entities){
			delete(t);
		}
	}
	/**
     * <ִ���޸Ļ�ɾ��Hql���>
     * @param hql HQL���
     * @param values ������������
     * @return �޸Ļ�ɾ���Ķ��������
     */
	public int executeHql(String hql,Object...values){
		Query query = this.createHqlQuery(hql, values);
		return query.executeUpdate();
	}
	
	/**
     * <ִ���޸Ļ�ɾ��Sql���>
     * @param sql SQL���
     * @param values ������������
     * @return �޸Ļ�ɾ���Ķ��������
     */
	public int executeSql(String sql,Object...values){
		Query query = this.createSqlQuery(sql, values);
		return query.executeUpdate();
	}
	/**
     * <����HQL������Ψһʵ��>
     * @param hql HQL���
     * @param values ����������Object����
     * @return ʵ�����
     */
	@Override
	public T getByHql(String hql, Object... values) {
		Query query = this.createHqlQuery(hql, values);
		return (T) query.uniqueResult();
	}
	/**
     * <����SQL������Ψһʵ��>
     * @param sql SQL���
     * @param values ����������Object����
     * @return ��ѯʵ��
     */
	@Override
	public T getBySql(String sql, Object... values) {
		Query query = this.createSqlQuery(sql, values);
		return (T) query.uniqueResult();
	}

	/**
     * <����HQL��䣬�õ���Ӧ��list>
     * @param hql HQL���
     * @param values ����������Object����
     * @return ��ѯ���ʵ���List����
     */
	@Override
	public List<T> getListByHql(String hql, Object... values) {
		Query query = this.createHqlQuery(hql, values);
		return query.list();
	}
	
	/**
     * <����SQL��䣬�õ���Ӧ��list>
     * @param sql SQL���
     * @param values ����������Object����
     * @return ��ѯ���ʵ���List����
     */
	@Override
	public List<T> getListBySql(String sql, Object... values) {
		SQLQuery query = this.getSession().createSQLQuery(sql).addEntity(genericClass);
		wrapQuery(query, values);
		return query.list();
	}

	/**
	 * ����Query�������
	 * @param query		Query����
	 * @param values	��������
	 */
	private void wrapQuery(Query query,Object...values){
		if(values==null)
			return;
		for(int i = 0;i < values.length;i++){
			query.setParameter(i, values[i]);
		}
	}
	
	/**
	 * ��������HQL��Query����
	 * @param hql	HQL���
	 * @param values	��������
	 * @return	Query����
	 */
	private Query createHqlQuery(String hql,Object...values){
		Query query = this.getSession().createQuery(hql);
		if(values != null){
			wrapQuery(query, values);
		}
		return query;
	}
	
	/**
	 * ��������SQL��Query����
	 * @param sql	SQL���
	 * @param values	��������
	 * @return	Query����
	 */
	public Query createSqlQuery(String sql,Object...values){
		Query query = this.getSession().createSQLQuery(sql);
		if(values != null){
			wrapQuery(query, values);
		}
		return query;
	}
	
	/**
     * <ˢ��ʵ��>
     * @param t ʵ�����
     */
    @Override
    public void refresh(T t) {
        this.getSession().refresh(t);
    }
 
    /**
     * <����ʵ��>
     * @param t ʵ�����
     */
    @Override
    public void update(T t) {
        this.getSession().update(t);
    }
    
    /**
	 * <��ȡ����list>
	 * @return ���󼯺�
	 */
    public List<T> getList(){
    	return this.getSession().createQuery("from "+genericClass.getName()).list();
    }
}
