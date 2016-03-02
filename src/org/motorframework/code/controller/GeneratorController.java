package org.motorframework.code.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.motorframework.code.pojo.CodeInfo;
import org.motorframework.core.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateNotFoundException;
import net.sf.json.JSONObject;
import oracle.net.aso.f;

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
	
	@RequestMapping("generateCode.do")
	public void generate(CodeInfo code,HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", code);
		map.put("pojoClassName", code.getPackageName()+".pojo."+code.getClassName());
		map.put("daoClassName", code.getPackageName()+".dao."+code.getClassName()+"Dao");
		map.put("serviceClassName", code.getPackageName()+".service."+code.getClassName()+"Service");
		map.put("pojoPackage", code.getPackageName()+".pojo");
		map.put("daoPackage", code.getPackageName()+".dao");
		map.put("daoImplPackage", code.getPackageName()+".dao.impl");
		map.put("servicePackage", code.getPackageName()+".service");
		map.put("serviceImplPackage", code.getPackageName()+".service.impl");
		map.put("controllerPackage", code.getPackageName()+".controller");
		
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
		String path = request.getServletContext().getRealPath("/")+"WEB-INF\\classes\\org\\motorframework\\code\\ftl\\";
		try {
			cfg.setDirectoryForTemplateLoading(new File(path));
			cfg.setDefaultEncoding("GBK");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
//			generateEntity(cfg, map, path);
//			generateDao(cfg, map, path);
//			generateDaoImpl(cfg, map, path);
//			generateService(cfg, map, path);
//			generateServiceImpl(cfg, map, path);
//			generateController(cfg, map, path);
			generateCode(cfg, map, path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void generateCode(Configuration cfg,Map<String, Object> map,String path) throws Exception{
		Template template = cfg.getTemplate("entity.ftl");
		File outFile = new File(path+((CodeInfo)map.get("code")).getClassName()+".java");
		process(outFile, template, map);
		
		template = cfg.getTemplate("dao.ftl");
		outFile = new File(path+((CodeInfo)map.get("code")).getClassName()+"Dao.java");
		process(outFile, template, map);
		
		template = cfg.getTemplate("daoImpl.ftl");
		outFile = new File(path+((CodeInfo)map.get("code")).getClassName()+"DaoImpl.java");
		process(outFile, template, map);
		
		template = cfg.getTemplate("service.ftl");
		outFile = new File(path+((CodeInfo)map.get("code")).getClassName()+"Service.java");
		process(outFile, template, map);
		
		template = cfg.getTemplate("serviceImpl.ftl");
		outFile = new File(path+((CodeInfo)map.get("code")).getClassName()+"ServiceImpl.java");
		process(outFile, template, map);
		
		template = cfg.getTemplate("controller.ftl");
		outFile = new File(path+((CodeInfo)map.get("code")).getClassName()+"Controller.java");
		process(outFile, template, map);
	}
	private void generateEntity(Configuration cfg,Map<String, Object> map,String path) throws Exception{
		Template template = cfg.getTemplate("entity.ftl");
		File outFile = new File(path+((CodeInfo)map.get("code")).getClassName()+".java");
		process(outFile, template, map);
	}
	
	private void generateDao(Configuration cfg,Map<String, Object> map,String path) throws Exception{
		Template template = cfg.getTemplate("dao.ftl");
		File outFile = new File(path+((CodeInfo)map.get("code")).getClassName()+"Dao.java");
		process(outFile, template, map);
	}
	
	private void generateDaoImpl(Configuration cfg,Map<String, Object> map,String path) throws Exception{
		Template template = cfg.getTemplate("daoImpl.ftl");
		File outFile = new File(path+((CodeInfo)map.get("code")).getClassName()+"DaoImpl.java");
		process(outFile, template, map);
	}
	
	private void generateService(Configuration cfg,Map<String, Object> map,String path)  throws Exception{
		Template template = cfg.getTemplate("service.ftl");
		File outFile = new File(path+((CodeInfo)map.get("code")).getClassName()+"Service.java");
		process(outFile, template, map);
	}
	
	private void generateServiceImpl(Configuration cfg,Map<String, Object> map,String path)  throws Exception{
		Template template = cfg.getTemplate("serviceImpl.ftl");
		File outFile = new File(path+((CodeInfo)map.get("code")).getClassName()+"ServiceImpl.java");
		process(outFile, template, map);
	}
	
	private void generateController(Configuration cfg,Map<String, Object> map,String path)  throws Exception{
		Template template = cfg.getTemplate("controller.ftl");
		File outFile = new File(path+((CodeInfo)map.get("code")).getClassName()+"Controller.java");
		process(outFile, template, map);
	}
	
	private void process(File outFile,Template template,Map<String, Object> map) throws Exception{
		if (!outFile.getParentFile().exists()) {
			outFile.getParentFile().mkdirs();
		}
		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
		template.process(map, out);
		out.flush();
		out.close();
	}
}
