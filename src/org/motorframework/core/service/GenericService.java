package org.motorframework.core.service;

import java.io.Serializable;

/** 
 * <泛型Service接口>
 * <p>提供对象持久化的基本操作接口，包括增删改查以及分页等功能
 * <h3>类参数说明：</h3>
 * <p>T:泛型类，子类继承时需指定具体类型
 * <p>ID:持久化对象主键类型，必须为类，如String,Integer等
 * 
 * @author Weitian Wang
 * @since 1.0.0
 * @version 1.0.0
 * 
 */
public interface GenericService<T,ID extends Serializable> {
	/**
	 * 持久化对象
	 * @param t 持久化实体对象
	 */
	public void save(T t);
	
	/**
	 * 根据ID获取持久化对象，如果没有此ID对应的对象则返回null
	 * @param id	主键
	 * @return	持久化对象实例或null
	 */
	public T get(ID id);
	
	/**
	 * 删除对象
	 * @param t
	 */
	public void delete(T t);
	
	/**
     * <根据ID删除数据>
     * @param id 实体主键
     * @return true或false
     */
	public boolean deleteById(ID id);
}
