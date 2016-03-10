package ${controllerPackage};

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ${pojoClassName};
import ${servicePackage};
import org.motorframework.core.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/** 
 * Controller
 * @author Motor
 */
@Controller
@RequestMapping("${code.jspPath}")
public class ${code.className}Controller extends BaseController {
	@Resource(name="${code.className}ServiceImpl")
	private ${code.className}Service service;
	private String viewPath = "${code.jspPath}";
	
	@RequestMapping(value="/forList.do")
	public String forList(){
		return viewPath + FORLIST;
	}
	
	@RequestMapping(value="/forAdd.do")
	public String forAdd(HttpServletRequest request){
		return viewPath + FORADD;
	}
	
	@RequestMapping(value="/getList.do")
	public void getList(HttpServletResponse response){
		List<${code.className}> list = service.getList();
		
	}
	
	@RequestMapping(value="/save.do")
	public void save(${code.className} obj,HttpServletResponse response){
		service.save(obj);
	}
	
	@RequestMapping(value="/delete.do")
	public void delete(@RequestParam(value="id",required=true) String id,HttpServletResponse response){
		
		if(id==null||"".equals(id)){
			setReturnError("未接收到待删除记录主键值，无法删除");
		}else{
			boolean b = service.deleteById(id);
			if(b)
				setReturnSucess();
			else
				setReturnError("删除数据失败！");
		}
		
		renderJson(getReturnJson(), response);
	}
	
	@RequestMapping(value="/forUpdate.do")
	public String forUpdate(String id,HttpServletRequest request){
		if(id==null||"".equals(id)){
			request.setAttribute("error", "主键为空,无法修改，请联系管理员");
			return viewPath + ERROR;
		}
		${code.className} obj = service.get(id);
		
		request.setAttribute("obj", obj);
		
		return viewPath + FORUPDATE;
	}
	
	@RequestMapping(value="/update.do")
	public void update(${code.className} obj,HttpServletResponse response){
		service.update(obj);
		setReturnSucess();
		returnMap.put("obj", obj);
		renderJson(getReturnJson(), response);
	}
	
	@RequestMapping(value="/forDetail.do")
	public String forDetail(){
		return viewPath + FORDETAIL;
	}
}
