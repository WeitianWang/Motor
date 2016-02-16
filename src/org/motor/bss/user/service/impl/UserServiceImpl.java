package org.motor.bss.user.service.impl;

import javax.annotation.Resource;

import org.motor.bss.user.dao.UserDao;
import org.motor.bss.user.pojo.User;
import org.motor.bss.user.service.UserService;
import org.motorframework.core.dao.GenericDao;
import org.motorframework.core.service.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;

/** 
 * @author Weitian Wang
 * �������ڣ�2015��10��2�� ����11:00:52 
 * ��˵�� ��
 */
@Service("bss/user/service")
public class UserServiceImpl extends GenericServiceImpl<User,String> implements UserService {
	@Resource(name="bss/user/dao")
	private UserDao dao;

	@Override
	public GenericDao<User, String> getDao() {
		return this.dao;
	}

}
