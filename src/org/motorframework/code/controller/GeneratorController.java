package org.motorframework.code.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;

import org.motorframework.code.pojo.CodeInfo;
import org.motorframework.core.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import net.sf.json.JSONObject;

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
	public  void generateEntity(@ModelAttribute CodeInfo info,HttpServletRequest request){
		String className = request.getParameter("className");
		System.out.println(JSONObject.fromObject(info));
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
		try {
			String path = request.getServletContext().getRealPath("/")+"WEB-INF\\classes\\org\\motorframework\\code\\ftl\\";
			//File file = new File(path);
			cfg.setDirectoryForTemplateLoading(new File(path));
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			Template template = cfg.getTemplate("entity.ftl");
			File outFile = new File(path+className);
			if (!outFile.getParentFile().exists()) {
				outFile.getParentFile().mkdirs();
			}
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
			template.process(info, out);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
