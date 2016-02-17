package org.motorframework.authentication.dao.impl;

import org.motorframework.authentication.dao.AuthoriseDao;
import org.motorframework.authentication.pojo.Authoriser;
import org.motorframework.core.dao.impl.GenericDaoImpl;
import org.springframework.stereotype.Repository;

/** 
 * @author WeitienWong
 * 创建日期：2015年10月5日 下午4:24:41 
 * 类说明 ：
 */
@Repository("auth/dao")
public class AuthoriseDaoImpl extends GenericDaoImpl<Authoriser, String> implements AuthoriseDao{

}
