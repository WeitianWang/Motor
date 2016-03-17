package org.motorframework.core.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;

/** 
 * @author Weitien Wong
 * 创建日期：2015年10月2日 下午9:40:44 
 * 类说明 ：Controller基类
 */
public class BaseController {
	protected final String FORADD = "forAdd";
	protected final String FORUPDATE = "forUpdate";
	protected final String FORDETAIL = "forDetail";
	protected final String FORLIST = "forList";
	protected final String ERROR = "error";
	protected Map<String, Object> returnMap = new HashMap<String, Object>();
	
	/**
	 * Ajax返回JSON
	 * @param json
	 * @param response
	 */
	protected void renderJson(String json,HttpServletResponse response){
		render(json, response, "text/json;  charset=utf-8");
	}
	/**
	 * Ajax返回字符串
	 * @param text
	 * @param response
	 */
	protected void renderText(String text,HttpServletResponse response){
		render(text, response, "text/html; charset=utf-8");
	}
	/**
	 * Ajax前台渲染内容
	 * @param str
	 * @param response
	 * @param contentType
	 */
	protected void render(String str,HttpServletResponse response,String contentType){
		response.setContentType(contentType);
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			writer.flush();
			writer.close();
		}
	}
	
	public void setReturnError(String tip){
		returnMap.put("error",tip);
	}
	
	public void setReturnSucess(){
		returnMap.put("success", true);
	}
	
	public String getReturnJson(){
		return JSONObject.fromObject(returnMap).toString();
	}
	/**
	 * 获取登陆用户信息
	 * @param request
	 * @return
	 */
//	public User getLoginUser(HttpServletRequest request){
//		User user = (User) request.getSession().getAttribute("user");
//		return user;
//	}
	/**
	 * 获取session
	 * @param request
	 * @return	HttpSession对象
	 */
	public HttpSession getSession(HttpServletRequest request){
		return request.getSession();
	}
}
