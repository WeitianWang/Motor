package org.motor.bss.menu.dao.impl;

import org.motor.bss.menu.dao.MenuDao;
import org.motor.bss.menu.pojo.Menu;
import org.motorframework.core.dao.impl.GenericDaoImpl;
import org.springframework.stereotype.Repository;

/** 
 * ϵͳ�˵�Daoʵ����
 * @author WeitienWong
 * �������ڣ�2016��1��12�� ����4:54:33 
 */
@Repository(value="bss.menu.MenuDaoImpl")
public class MenuDaoImpl extends GenericDaoImpl<Menu, String> implements MenuDao{
	
}
