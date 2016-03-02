package org.motor.bss.organ.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.motor.bss.organ.dao.OrganDao;
import org.motor.bss.organ.pojo.Organ;
import org.motor.bss.organ.service.OrganService;
import org.motorframework.core.dao.GenericDao;
import org.motorframework.core.service.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** 
 * ϵͳ�˵�serviceʵ����
 * @author WeitienWong
 * �������ڣ�2016��2��17�� ����10:49:49 
 */
@Service(value="bss.organ.OrganServiceImpl")
public class OrganServiceImpl extends GenericServiceImpl<Organ, String> implements OrganService {
	@Resource(name="bss.organ.OrganDaoImpl")
	private OrganDao dao;
	@Override
	public GenericDao<Organ, String> getDao() {
		return dao;
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Organ> getList() {
		return dao.getList();
	}

}
