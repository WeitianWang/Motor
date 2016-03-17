package org.motor.bss.stuff.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.motor.bss.stuff.pojo.Stuff;
import org.motor.bss.stuff.service.StuffService;
import org.motorframework.core.controller.BaseController;
import org.motorframework.core.pojo.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 员工模块控制器
 * @author WeitienWong
 *
 */
@Controller
@RequestMapping("bss/stuff")
public class StuffController  extends BaseController{
	@Resource(name="bss.stuff.StuffServiceImpl")
	private StuffService service;
	
	private String viewPath = "bss/stuff/";
	
	@RequestMapping(value="/forList.do")
	public String forList(){
		return viewPath + FORLIST;
	}
	
	@RequestMapping(value="/forAdd.do")
	public String forAdd(){
		return viewPath + FORADD;
	}
	
	@RequestMapping(value="/forDetail.do")
	public String forDetail(HttpServletRequest request){
		return viewPath + FORDETAIL;
	}
	
	@RequestMapping(value="/save.do")
	public void save(Stuff s,HttpServletResponse response){
		service.save(s);
		setReturnSucess();
		renderJson(getReturnJson(), response);
	}
	
	@RequestMapping(value="/list.do")
	public void getPageList(Page page,HttpServletRequest request,HttpServletResponse response){
		List<Stuff> list = service.getPageList(page);
		int total = service.getTotal();
		returnMap.put("total",total);
		returnMap.put("rows",list);
		renderJson(getReturnJson(), response);
	}
}
