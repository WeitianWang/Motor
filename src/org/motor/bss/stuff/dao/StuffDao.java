package org.motor.bss.stuff.dao;

import java.util.List;

import org.motor.bss.stuff.pojo.Stuff;
import org.motorframework.core.dao.GenericDao;
import org.motorframework.core.pojo.Page;

public interface StuffDao extends GenericDao<Stuff, String> {
	
	public List<Stuff> getPageList(Page page);
	
	public int getTotal();
}
