package org.motor.bss.stuff.dao.impl;

import org.motor.bss.stuff.dao.StuffDao;
import org.motor.bss.stuff.pojo.Stuff;
import org.motorframework.core.dao.impl.GenericDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * 员工Dao实现类
 * @author WeitienWong
 *
 */
@Repository(value="bss.stuff.StuffDaoImpl")
public class StuffDaoImpl extends GenericDaoImpl<Stuff, String> implements StuffDao {
	
}
