package org.motorframework.authentication.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.motorframework.authentication.pojo.Authoriser;
import org.motorframework.authentication.service.AuthoriseService;
import org.motorframework.core.controller.BaseController;
import org.motorframework.util.security.MD5Encoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * @author WeitienWong
 * �������ڣ�2015��10��5�� ����4:50:55 
 * ��˵�� ��
 */
@Controller
public class AuthenticateController extends BaseController {
	@Resource(name="authoriseService")
	private AuthoriseService service;
	
	@RequestMapping("authenticate.do")
	public void authenticate(String username,String password,HttpServletResponse response){
		Authoriser a = service.get(username);
		if (a==null) {
			renderText("false", response);
		}else{
			MD5Encoder md5 = new MD5Encoder();
			password = md5.encode(password);
			if(a.getPassword().equals(password)){
				renderText("true", response);
			}else{
				renderText("false", response);
			}
		}
	}
	
	@RequestMapping("authorize.do")
	public String authorize(String username,HttpServletRequest request,HttpServletResponse response){
		HttpSession session = getSession(request);
		Authoriser a = service.get(username);
		session.setAttribute("Authorizer",a);
		/**
		 * �û���Ȩ�����û�Ȩ�޷���session��
		 */
		return "main";
	}
}
