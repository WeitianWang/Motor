package org.motorframework.core.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/** 
 * <泛型Dao接口>
 * <p>提供对象持久化的基本操作接口，包括增删改查以及分页等功能
 * <h3>类参数说明：</h3>
 * <p>T:泛型类，子类继承时需指定具体类型
 * <p>ID:持久化对象主键类型，必须为类，如String,Integer等
 * @author Weitian Wang 2015年9月28日 下午1:29:42 
 * @since 1.0.0
 * @version 1.0.0
 */
public interface GenericDao<T,ID extends Serializable> {
	/**
	 * 持久化对象
	 * @param t	持久化对象实体
	 */
	public void save(T t);
	/**
	 * 保存或更新实体
	 * @param t	持久化对象实体
	 */
	public void saveOrUpdate(T t);
	/**
	 * load方法加载实体
	 * @param id 实体主键
	 * @return	实体对象
	 */
	public T load(ID id);
	/**
	 * get方法加载实体
	 * @param id 实体主键
	 * @return	实体对象
	 */
	public T get(ID id);
	/**
	 * <contains>
	 * @param t 持久化对象实体
	 * @return	true或false
	 */
	public boolean contains(T t);
	/**
     * <delete>
     * <删除表中的t数据>
     * @param t 实体对象
     */
	public void delete(T t);
	/**
     * <根据ID删除数据>
     * @param id 实体主键
     * @return true或false
     */
	public boolean deleteById(ID id);
	/**
     * <删除集合中的所有对象>
     * @param entities 实体的Collection集合
     */
	public void deleteAll(Collection<T> entities);
	/**
     * <执行修改或删除Hql语句>
     * @param hql HQL语句
     * @param values 不定参数数组
     * @return 修改或删除的对象的数量
     */
	public int executeHql(String hql,Object...values);
	
	/**
     * <执行修改或删除Sql语句>
     * @param sql SQL语句
     * @param values 不定参数数组
     * @return 修改或删除的对象的数量
     */
	public int executeSql(String sql,Object...values);
	/**
     * <根据HQL语句查找唯一实体>
     * @param hql HQL语句
     * @param values 不定参数的Object数组
     * @return 查询实体
     */
	public T getByHql(String hql,Object...values);
	 /**
     * <根据SQL语句查找唯一实体>
     * @param sql SQL语句
     * @param values 不定参数的Object数组
     * @return 查询实体
     */
	public T getBySql(String sql,Object...values);
	/**
     * <根据HQL语句，得到对应的list>
     * @param hql HQL语句
     * @param values 不定参数的Object数组
     * @return 查询多个实体的List集合
     */
	public List<T> getListByHql(String hql,Object...values);
	/**
     * <根据SQL语句，得到对应的list>
     * @param sql HQL语句
     * @param values 不定参数的Object数组
     * @return 查询多个实体的List集合
     */
	public List<T> getListBySql(String sql,Object...values);
	/**
     * <刷新实体>
     * @param t 实体对象
     */
	public void refresh(T t);
	/**
     * <更新实体>
     * 
     * @param t 实体对象
     */
	public void update(T t);
}
