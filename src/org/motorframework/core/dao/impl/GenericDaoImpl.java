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
 * <泛型Dao接口>
 * <p>提供对象持久化的基本操作接口，包括增删改查以及分页等功能
 * <h3>类参数说明：</h3>
 * <p>T:泛型类，子类继承时需指定具体类型
 * <p>ID:持久化对象主键类型，必须为类，如String,Integer等
 * @author WeitienWong 2015年9月28日 下午1:29:42 
 * @since 1.0.0
 * @version 1.0.0
 * @see org.motorframework.core.dao.GenericDao
 */
public class GenericDaoImpl<T,ID extends Serializable> implements GenericDao<T,ID>{
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	//泛型Class
	protected Class<T> genericClass;
	
	public GenericDaoImpl(){
		//获取泛型父类
		Type type = getClass().getGenericSuperclass();
		//如果没有实现ParameterizedType接口,即不支持泛
		if(type instanceof ParameterizedType){
			Type[] types = ((ParameterizedType)type).getActualTypeArguments();
			genericClass = (Class<T>) types[0];
		}else{
			System.out.println("不支持泛型");
		}
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected SessionFactory getSessionFactory(){
		Assert.isNull(sessionFactory,"属性sessionFactory为空，请检查此属性是否设置正确！");
		return this.sessionFactory;
	}
	
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	/**
	 * 持久化对象
	 * @param t	持久化对象实体
	 */
	@Override
	public void save(T t) {
		this.getSession().save(t);
	}

	/**
	 * 保存或更新实体
	 * @param t	持久化对象实体
	 */
	@Override
	public void saveOrUpdate(T t) {
		this.getSession().saveOrUpdate(t);
		
	}

	/**
     * <load>
     * <加载实体的load方法>
     * @param id 实体的id
     * @return 查询出来的实体
     */
	@Override
	public T load(ID id) {
		T t = (T)this.getSession().load(genericClass, id);
		return t;
	}
	
	/**
     * <get>
     * <加载实体的get方法>
     * @param id 实体的id
     * @return 查询出来的实体
     */
	@Override
	public T get(ID id) {
		T t = (T)this.getSession().get(genericClass, id);
		
		return t;
	}

	/**
     * <contains>
     * <检查对象是否包含在session中>
     * @param t 实体
     * @return 是否包含
     */
	@Override
	public boolean contains(T t) {
		return this.getSession().contains(t);
	}

	/**
     * <delete>
     * <删除表中的t数据>
     * @param t 实体
     */
	@Override
	public void delete(T t) {
		this.getSession().delete(t);
	}

	/**
     * <根据ID删除数据>
     * @param id 实体主键
     * @return true或false
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
     * <删除集合中的所有对象>
     * @param entities 实体的Collection集合
     */
	@Override
	public void deleteAll(Collection<T> entities) {
		for(T t : entities){
			delete(t);
		}
	}
	/**
     * <执行修改或删除Hql语句>
     * @param hql HQL语句
     * @param values 不定参数数组
     * @return 修改或删除的对象的数量
     */
	public int executeHql(String hql,Object...values){
		Query query = this.createHqlQuery(hql, values);
		return query.executeUpdate();
	}
	
	/**
     * <执行修改或删除Sql语句>
     * @param sql SQL语句
     * @param values 不定参数数组
     * @return 修改或删除的对象的数量
     */
	public int executeSql(String sql,Object...values){
		Query query = this.createSqlQuery(sql, values);
		return query.executeUpdate();
	}
	/**
     * <根据HQL语句查找唯一实体>
     * @param hql HQL语句
     * @param values 不定参数的Object数组
     * @return 实体对象
     */
	@Override
	public T getByHql(String hql, Object... values) {
		Query query = this.createHqlQuery(hql, values);
		return (T) query.uniqueResult();
	}
	/**
     * <根据SQL语句查找唯一实体>
     * @param sql SQL语句
     * @param values 不定参数的Object数组
     * @return 查询实体
     */
	@Override
	public T getBySql(String sql, Object... values) {
		Query query = this.createSqlQuery(sql, values);
		return (T) query.uniqueResult();
	}

	/**
     * <根据HQL语句，得到对应的list>
     * @param hql HQL语句
     * @param values 不定参数的Object数组
     * @return 查询多个实体的List集合
     */
	@Override
	public List<T> getListByHql(String hql, Object... values) {
		Query query = this.createHqlQuery(hql, values);
		return query.list();
	}
	
	/**
     * <根据SQL语句，得到对应的list>
     * @param sql SQL语句
     * @param values 不定参数的Object数组
     * @return 查询多个实体的List集合
     */
	@Override
	public List<T> getListBySql(String sql, Object... values) {
		SQLQuery query = this.getSession().createSQLQuery(sql).addEntity(genericClass);
		wrapQuery(query, values);
		return query.list();
	}

	/**
	 * 设置Query对象参数
	 * @param query		Query对象
	 * @param values	不定参数
	 */
	private void wrapQuery(Query query,Object...values){
		if(values==null)
			return;
		for(int i = 0;i < values.length;i++){
			query.setParameter(i, values[i]);
		}
	}
	
	/**
	 * 创建基于HQL的Query对象
	 * @param hql	HQL语句
	 * @param values	不定参数
	 * @return	Query对象
	 */
	private Query createHqlQuery(String hql,Object...values){
		Query query = this.getSession().createQuery(hql);
		if(values != null){
			wrapQuery(query, values);
		}
		return query;
	}
	
	/**
	 * 创建基于SQL的Query对象
	 * @param sql	SQL语句
	 * @param values	不定参数
	 * @return	Query对象
	 */
	public Query createSqlQuery(String sql,Object...values){
		Query query = this.getSession().createSQLQuery(sql);
		if(values != null){
			wrapQuery(query, values);
		}
		return query;
	}
	
	/**
     * <刷新实体>
     * @param t 实体对象
     */
    @Override
    public void refresh(T t) {
        this.getSession().refresh(t);
    }
 
    /**
     * <更新实体>
     * @param t 实体对象
     */
    @Override
    public void update(T t) {
        this.getSession().update(t);
    }
    
    /**
	 * <获取对象list>
	 * @return 对象集合
	 */
    public List<T> getList(){
    	return this.getSession().createQuery("from "+genericClass.getName()).list();
    }
}
