package org.motor.bss.user.dao.impl;

import org.motor.bss.user.dao.UserDao;
import org.motor.bss.user.pojo.User;
import org.motorframework.core.dao.impl.GenericDaoImpl;
import org.springframework.stereotype.Repository;

/** 
 * @author WeitienWong
 * �������ڣ�2015��10��2�� ����10:58:29 
 * ��˵�� ��
 */
@Repository("bss/user/dao")
public class UserDaoImpl extends GenericDaoImpl<User,String> implements UserDao{
	
}
