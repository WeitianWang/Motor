package org.motor.bss.organ.dao.impl;

import org.motor.bss.organ.dao.OrganDao;
import org.motor.bss.organ.pojo.Organ;
import org.motorframework.core.dao.impl.GenericDaoImpl;
import org.springframework.stereotype.Repository;
/**
 * ��֯����Daoʵ����
 * @author WeitienWong
 *�������ڣ�2016��2��17�� ����4:53:10 
 */
@Repository(value="bss.organ.OrganDaoImpl")
public class OrganDaoImpl extends GenericDaoImpl<Organ, String> implements OrganDao{

}
