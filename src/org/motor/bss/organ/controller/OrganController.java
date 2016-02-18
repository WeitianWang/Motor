package org.motor.bss.organ.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.motor.bss.organ.pojo.Organ;
import org.motor.bss.organ.service.OrganService;
import org.motorframework.core.controller.BaseController;
import org.motorframework.util.tree.Node;
import org.motorframework.util.tree.Tree;
import org.motorframework.util.tree.JsonTree;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
	
	@RequestMapping(value="/getList.do")
	public void getList(HttpServletResponse response){
		List<Organ> list = service.getList();
		JSONArray jarr = JSONArray.fromObject(list);
		JsonTree t = new JsonTree(jarr);
		t.setKey("organCode");
		t.setParentKey("parentCode");
		JSONArray arr = t.getTree();
		System.out.println(arr);
		renderJson(arr.toString(), response);
	}
}
