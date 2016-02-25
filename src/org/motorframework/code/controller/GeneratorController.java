package org.motorframework.code.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.motorframework.core.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

/**
 * 代码生成器控制器
 * @author WeitienWong
 *
 */
@Controller
@RequestMapping("code")
public class GeneratorController extends BaseController {
	private String viewPath = "code/";
	@RequestMapping(value="/forAdd.do")
	public String forAdd(){
		return viewPath + FORADD;
	}
	
	@RequestMapping("generateEntity.do")
	public void generateEntity(HttpServletRequest request){
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
		try {
			String path = request.getServletContext().getRealPath("/");
			System.out.println(path);
			System.out.println(this.getClass().getClassLoader().getResource("/").getPath());
			File file = new File(path);
			cfg.setDirectoryForTemplateLoading(new File(file.getParent()));
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			Template temp = cfg.getTemplate("entity.ftl");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
