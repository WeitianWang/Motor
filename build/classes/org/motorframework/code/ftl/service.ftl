package ${servicePackage};

import java.util.List;
import ${pojoClassName};
import org.motorframework.core.service.GenericService;

/**
 * service�ӿ�
 * 
 */
public interface  ${code.className}Service extends GenericService<${code.className},String> {
	public List<${code.className}> getList();
}
