package ${serviceImplPackage};

import java.util.List;
import javax.annotation.Resource;
import ${pojoClassName};
import ${daoClassName};
import ${serviceClassName};
import org.motorframework.core.dao.GenericDao;
import org.motorframework.core.service.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** 
 * service µœ÷¿‡
 * @author Motor
 */
@Service(value=" ${code.className}ServiceImpl")
public class  ${code.className}ServiceImpl extends GenericServiceImpl<${code.className},String> implements  ${code.className}Service {
	@Resource(name="${code.className}DaoImpl")
	private  ${code.className}Dao dao;
	
	@Override
	public GenericDao<${code.className},String> getDao() {
		return dao;
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<${code.className}> getList() {
		return dao.getList();
	}

}
