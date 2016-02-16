package org.motor.bss.user.controller;

import javax.annotation.Resource;

import org.motor.bss.user.pojo.User;
import org.motor.bss.user.service.UserService;
import org.motorframework.core.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** 
 * @author Weitian Wang
 * 创建日期：2015年10月2日 下午10:54:27 
 * 类说明 ：
 */
@Controller
@RequestMapping("bss/user")
public class UserController extends BaseController{
	private String viewPath = "bss/user/";
	
	@Resource(name="bss/user/service")
	private UserService service;
	
	@RequestMapping(value="/forAdd.do",method=RequestMethod.POST)
	public String forAdd(){
		User u = new User();
		u.setUserId("123");
		u.setUserName("Test");
		u.setAddr("China");
		u.setBirthday("2015-10-03");
		u.setGender("1");
		u.setHiredate("2015-10-03");
		u.setMobile("18660130351");
		u.setPassword("123");
		service.save(u);
		return viewPath + FORADD;
	}
	@RequestMapping(value="/getUser.do",method=RequestMethod.POST)
	public String getUser(){
		User u = service.get("123");
		
		return viewPath + FORADD;
	}
}
