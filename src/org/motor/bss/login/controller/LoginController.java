package org.motor.bss.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * 登陆Controller
 * @author Weitian Wang
 * 创建日期：2015年12月22日 下午7:04:31 
 */
@Controller
public class LoginController {
	@RequestMapping(value="/bss/login.do")
	public String forLogin(HttpServletRequest request,HttpServletResponse response){
		return "login";
	}
	@RequestMapping(value="/bss/doLogin.do")
	public String doLogin(){
		return "main";
	}
}
