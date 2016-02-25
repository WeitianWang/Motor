package org.motor.bss.stuff.controller;

import javax.annotation.Resource;
import org.motor.bss.stuff.service.StuffService;
import org.motorframework.core.controller.BaseController;
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
	
	@RequestMapping(value="/forDetail.do")
	public String forDetail(){
		return viewPath + FORDETAIL;
	}
}
