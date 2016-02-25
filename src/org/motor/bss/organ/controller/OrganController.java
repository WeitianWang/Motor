package org.motor.bss.organ.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.motor.bss.organ.pojo.Organ;
import org.motor.bss.organ.service.OrganService;
import org.motorframework.core.controller.BaseController;
import org.motorframework.util.tree.JsonTree;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import net.sf.json.JSONArray;

/** 
 * ��֯����Controller
 * @author WeitienWong
 * �������ڣ�2016��2��17�� ����10:29:41 
 */
@Controller
@RequestMapping("bss/organ")
public class OrganController extends BaseController {
	@Resource(name="bss.organ.OrganServiceImpl")
	private OrganService service;
	private String viewPath = "bss/organ/";
	
	@RequestMapping(value="/forList.do")
	public String forList(){
		return viewPath + FORLIST;
	}
	
	@RequestMapping(value="/forAdd.do")
	public String forAdd(String parentCode,String organType,String parentName,HttpServletRequest request){
		request.setAttribute("parentCode", parentCode);
		request.setAttribute("parentName", parentName);
		request.setAttribute("organType", organType);
		return viewPath + FORADD;
	}
	@RequestMapping(value="/getList.do")
	public void getList(HttpServletResponse response){
		List<Organ> list = service.getList();
		JSONArray jarr = JSONArray.fromObject(list);
		JsonTree t = new JsonTree(jarr);
		t.setKey("organCode");
		t.setParentKey("parentCode");
		JSONArray arr = t.getTree();
		
		renderJson(arr.toString(), response);
	}
	@RequestMapping(value="/save.do")
	public void save(Organ organ,HttpServletResponse response){
		service.save(organ);
		setReturnSucess();
		returnMap.put("organ", organ);
		renderJson(getReturnJson(), response);
	}
	
	@RequestMapping(value="/delete.do")
	public void delete(@RequestParam(value="id",required=true) String id,HttpServletResponse response){
		
		if(id==null||"".equals(id)){
			setReturnError("δ���յ���ɾ����¼����ֵ���޷�ɾ��");
		}else{
			boolean b = service.deleteById(id);
			if(b)
				setReturnSucess();
			else
				setReturnError("ɾ������ʧ�ܣ�");
		}
		
		renderJson(getReturnJson(), response);
	}
	
	@RequestMapping(value="/forUpdate.do")
	public String forUpdate( String id, String parentName,HttpServletRequest request){
		if(id==null||"".equals(id)){
			request.setAttribute("error", "����Ϊ��,�޷�ɾ��������ϵ����Ա");
			return viewPath + ERROR;
		}
		Organ o = service.get(id);
		request.setAttribute("organ", o);
		request.setAttribute("parentName", parentName);
		return viewPath + FORUPDATE;
	}
	
	@RequestMapping(value="/update.do")
	public void update(Organ o,HttpServletResponse response){
		service.update(o);
		setReturnSucess();
		returnMap.put("organ", o);
		renderJson(getReturnJson(), response);
	}
	
	@RequestMapping(value="/forDetail.do")
	public String forDetail(){
		return viewPath + FORDETAIL;
	}
}
