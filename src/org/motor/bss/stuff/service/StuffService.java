package org.motor.bss.stuff.service;

import java.util.List;
import org.motor.bss.stuff.pojo.Stuff;
import org.motorframework.core.pojo.Page;
import org.motorframework.core.service.GenericService;

public interface StuffService extends GenericService<Stuff,String> {
	public List<Stuff> getPageList(Page page);
	
	public int getTotal();
}
