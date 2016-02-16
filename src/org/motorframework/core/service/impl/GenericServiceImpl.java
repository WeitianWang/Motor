package org.motorframework.core.service.impl;

import java.io.Serializable;

import org.motorframework.core.dao.GenericDao;
import org.motorframework.core.service.GenericService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/** 
 * <泛型Service实现类>
 * <p>提供对象持久化的基本操作，包括增删改查以及分页等功能
 * <h3>类参数说明：</h3>
 * <p>T:泛型类，子类继承时需指定具体类型
 * <p>ID:持久化对象主键类型，必须为类，如String,Integer等
 * @author Weitian Wang
 * @since version 1.0.0
 * @version 1.0.0
 * @see org.motorframework.core.service.GenericService
 * 
 */
public abstract class GenericServiceImpl<T,ID extends Serializable> implements GenericService<T,ID> {

	public abstract GenericDao<T,ID> getDao();
	
	/**
	 * 持久化对象
	 * @param t 持久化实体对象
	 */
	@Transactional
	public void save(T t) {
		getDao().save(t);
	}
	
	/**
	 * get方法获取对象
	 * @param id 对象主键
	 * @return T对象
	 */
	@Transactional(readOnly=true)
	public T get(ID id){
		return getDao().get(id);
	}
	
	/**
	 * <删除对象>
	 * @param t
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void delete(T t){
		getDao().delete(t);
	}
	/**
     * <根据ID删除数据>
     * @param id 实体主键
     * @return true或false
     */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean deleteById(ID id){
		return getDao().deleteById(id);
	}
}
