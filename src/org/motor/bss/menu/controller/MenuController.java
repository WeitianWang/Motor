package org.motor.bss.menu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.motor.bss.menu.pojo.Menu;
import org.motor.bss.menu.pojo.MenuTree;
import org.motor.bss.menu.service.MenuService;
import org.motorframework.core.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/** 
 * @author Weitian Wang
 * 创建日期：2016年1月4日 上午10:29:41 
 */
@Controller
@RequestMapping("bss/menu")
public class MenuController extends BaseController{
	@Resource(name="bss.menu.MenuServiceImpl")
	private MenuService service;
	
	private String viewPath = "bss/menu/";
	
	@RequestMapping(value="/forList.do")
	public String forList(){
		return viewPath + FORLIST;
	}
	
	@RequestMapping(value="/forAdd.do")
	public String forAdd(@RequestParam(value="pid",defaultValue="") String pid,@RequestParam(value="parentName",defaultValue="顶层菜单(无上级)") String parentName,HttpServletRequest request){
		request.setAttribute("pid", pid);
		request.setAttribute("parentName",parentName);
		
		return viewPath + FORADD;
	}
	
	@RequestMapping(value="/forDetail.do")
	public String forDetail(){
		return viewPath + FORDETAIL;
	}

	@RequestMapping(value="/getList.do")
	public void getList(HttpServletResponse response){
		List<Menu> list = service.getList();
		
		MenuTree t = new MenuTree(list);
		
		renderJson(JSONArray.fromObject(t.getTree()).toString(), response);
	}
	
	@RequestMapping(value="/save.do")
	public void save(@ModelAttribute Menu m,HttpServletResponse response){
		service.save(m);
		setReturnSucess();
		returnMap.put("menu", m);
		renderJson(getReturnJson(), response);
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
}
