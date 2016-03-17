package org.motor.bss.stuff.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.motor.bss.stuff.dao.StuffDao;
import org.motor.bss.stuff.pojo.Stuff;
import org.motorframework.core.dao.impl.GenericDaoImpl;
import org.motorframework.core.pojo.Page;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 员工Dao实现类
 * @author WeitienWong
 *
 */
@Repository(value="bss.stuff.StuffDaoImpl")
public class StuffDaoImpl extends GenericDaoImpl<Stuff, String> implements StuffDao {

	@Transactional(readOnly=true)
	@Override
	public List<Stuff> getPageList(Page page) {
		String sql = "SELECT * FROM (SELECT T.*,ROWNUM RN FROM M_STUFF T) WHERE RN>=? AND RN<=?";
		List<Stuff> list = getListBySql(sql, page.getBeginNumber(),page.getEndNumber());
		return list;
	}

	@Transactional(readOnly=true)
	@Override
	public int getTotal() {
		int total = 0;
		String sql = "SELECT COUNT(*) FROM M_STUFF";
		Query query = createSqlQuery(sql, null);
		total = ((Number)query.uniqueResult()).intValue();
		return total;
	}
	
}
