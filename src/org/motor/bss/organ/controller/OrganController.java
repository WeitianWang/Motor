package org.motor.bss.organ.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.motor.bss.menu.pojo.Menu;
import org.motor.bss.menu.pojo.MenuTree;
import org.motor.bss.organ.pojo.Organ;
import org.motor.bss.organ.service.OrganService;
import org.motorframework.core.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/** 
 * 组织机构Controller
 * @author WeitienWong
 * 创建日期：2016年2月17日 上午10:29:41 
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
		for(Organ o : list){
			System.out.println(JSONObject.fromObject(o));
		}
		//MenuTree t = new MenuTree(list);
		
		//renderJson(JSONArray.fromObject(t.getTree()).toString(), response);
	}
}
