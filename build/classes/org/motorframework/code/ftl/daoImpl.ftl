package ${daoImplPackage};

import ${daoClassName};
import ${pojoClassName};
import org.motorframework.core.dao.impl.GenericDaoImpl;
import org.springframework.stereotype.Repository;
/**
 * Dao µœ÷¿‡
 * @author Auto
 */
@Repository(value="${code.className}DaoImpl")
public class ${code.className}DaoImpl extends GenericDaoImpl<${code.className},String> implements ${code.className}Dao{

}