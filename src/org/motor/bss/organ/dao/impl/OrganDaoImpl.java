package org.motor.bss.organ.dao.impl;

import org.motor.bss.organ.dao.OrganDao;
import org.motor.bss.organ.pojo.Organ;
import org.motorframework.core.dao.impl.GenericDaoImpl;
import org.springframework.stereotype.Repository;
/**
 * 组织机构Dao实现类
 * @author WeitienWong
 *创建日期：2016年2月17日 下午4:53:10 
 */
@Repository(value="bss.organ.OrganDaoImpl")
public class OrganDaoImpl extends GenericDaoImpl<Organ, String> implements OrganDao{

}
