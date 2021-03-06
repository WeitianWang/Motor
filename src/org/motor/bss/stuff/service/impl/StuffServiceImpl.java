package org.motor.bss.stuff.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.motor.bss.stuff.dao.StuffDao;
import org.motor.bss.stuff.pojo.Stuff;
import org.motor.bss.stuff.service.StuffService;
import org.motorframework.core.dao.GenericDao;
import org.motorframework.core.pojo.Page;
import org.motorframework.core.service.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service(value="bss.stuff.StuffServiceImpl")
public class StuffServiceImpl extends GenericServiceImpl<Stuff,String> implements StuffService {
	@Resource(name="bss.stuff.StuffDaoImpl")
	private StuffDao dao;
	@Override
	public GenericDao<Stuff, String> getDao() {
		return dao;
	}
	
	@Override
	public List<Stuff> getPageList(Page page) {
		return dao.getPageList(page);
	}

	@Override
	public int getTotal() {
		return dao.getTotal();
	}

}
