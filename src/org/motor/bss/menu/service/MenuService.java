package org.motor.bss.menu.service;

import java.util.List;

import org.motor.bss.menu.pojo.Menu;
import org.motorframework.core.service.GenericService;

/** 
 * ϵͳ�˵�service�ӿ�
 * @author WeitienWong
 * �������ڣ�2016��1��12�� ����10:49:49 
 */
public interface MenuService extends GenericService<Menu, String>{
	public List<Menu> getList();
}
