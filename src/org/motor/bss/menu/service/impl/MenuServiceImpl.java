package org.motor.bss.menu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.motor.bss.menu.dao.MenuDao;
import org.motor.bss.menu.pojo.Menu;
import org.motor.bss.menu.service.MenuService;
import org.motorframework.core.dao.GenericDao;
import org.motorframework.core.service.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/** 
 * @author Weitian Wang
 * �������ڣ�2016��1��12�� ����10:50:51 
 * ��˵�� ��
 */
@Service(value="bss.menu.MenuServiceImpl")
public class MenuServiceImpl extends GenericServiceImpl<Menu, String> implements MenuService{
	@Resource(name="bss.menu.MenuDaoImpl")
	private MenuDao dao;
	@Override
	public GenericDao<Menu, String> getDao() {
		return dao;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Menu> getList(){
		String sql = "SELECT MENU_ID,MENU_NAME,MENU_URI,MENU_PID,MENU_ICON,MENU_ORDER,MENU_TARGET FROM M_MENU ORDER BY MENU_ORDER ASC";
		return dao.getListBySql(sql, null);
	}
	
}
