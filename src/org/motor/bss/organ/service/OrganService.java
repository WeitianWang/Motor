package org.motor.bss.organ.service;

import java.util.List;
import org.motor.bss.organ.pojo.Organ;
import org.motorframework.core.service.GenericService;

/**
 * 组织机构service接口
 * 
 * @author WeitienWong 创建日期：2016年2月17日 上午10:49:49
 */
public interface OrganService extends GenericService<Organ, String> {
	public List<Organ> getList();
}
