package org.motor.bss.organ.service;

import java.util.List;
import org.motor.bss.organ.pojo.Organ;
import org.motorframework.core.service.GenericService;

/**
 * ��֯����service�ӿ�
 * 
 * @author WeitienWong �������ڣ�2016��2��17�� ����10:49:49
 */
public interface OrganService extends GenericService<Organ, String> {
	public List<Organ> getList();
}
