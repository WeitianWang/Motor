package org.motor.bss.user.dao.impl;

import org.motor.bss.user.dao.UserDao;
import org.motor.bss.user.pojo.User;
import org.motorframework.core.dao.impl.GenericDaoImpl;
import org.springframework.stereotype.Repository;

/** 
 * @author WeitienWong
 * 创建日期：2015年10月2日 下午10:58:29 
 * 类说明 ：
 */
@Repository("bss/user/dao")
public class UserDaoImpl extends GenericDaoImpl<User,String> implements UserDao{
	
}
