package org.motorframework.authentication.service.impl;

import javax.annotation.Resource;

import org.motorframework.authentication.dao.AuthoriseDao;
import org.motorframework.authentication.pojo.Authoriser;
import org.motorframework.authentication.service.AuthoriseService;
import org.motorframework.core.dao.GenericDao;
import org.motorframework.core.service.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;

/** 
 * @author WeitienWong
 * 创建日期：2015年10月5日 下午4:26:41 
 * 类说明 ：
 */
@Service("authoriseService")
public class AuthoriseServiceImpl extends GenericServiceImpl<Authoriser, String> implements AuthoriseService{
	
	@Resource(name="auth/dao")
	private AuthoriseDao dao;
	
	@Override
	public GenericDao<Authoriser, String> getDao() {
		return this.dao;
	}

}
