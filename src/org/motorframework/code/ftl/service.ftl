package ${servicePackage};

import java.util.List;
import ${pojoClassName};
import org.motorframework.core.service.GenericService;

/**
 * service½Ó¿Ú
 * 
 */
public interface  ${code.className}Service extends GenericService<${code.className},String> {
	public List<${code.className}> getList();
}
