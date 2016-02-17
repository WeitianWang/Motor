package org.motorframework.authentication.dao.impl;

import org.motorframework.authentication.dao.AuthoriseDao;
import org.motorframework.authentication.pojo.Authoriser;
import org.motorframework.core.dao.impl.GenericDaoImpl;
import org.springframework.stereotype.Repository;

/** 
 * @author WeitienWong
 * �������ڣ�2015��10��5�� ����4:24:41 
 * ��˵�� ��
 */
@Repository("auth/dao")
public class AuthoriseDaoImpl extends GenericDaoImpl<Authoriser, String> implements AuthoriseDao{

}
