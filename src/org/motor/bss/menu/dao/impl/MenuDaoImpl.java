package org.motor.bss.menu.dao.impl;

import org.motor.bss.menu.dao.MenuDao;
import org.motor.bss.menu.pojo.Menu;
import org.motorframework.core.dao.impl.GenericDaoImpl;
import org.springframework.stereotype.Repository;

/** 
 * 系统菜单Dao实现类
 * @author WeitienWong
 * 创建日期：2016年1月12日 下午4:54:33 
 */
@Repository(value="bss.menu.MenuDaoImpl")
public class MenuDaoImpl extends GenericDaoImpl<Menu, String> implements MenuDao{
	
}
