package org.motor.bss.menu.service;

import java.util.List;

import org.motor.bss.menu.pojo.Menu;
import org.motorframework.core.service.GenericService;

/** 
 * 系统菜单service接口
 * @author WeitienWong
 * 创建日期：2016年1月12日 上午10:49:49 
 */
public interface MenuService extends GenericService<Menu, String>{
	public List<Menu> getList();
}
