package org.zerock.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;


@RequestMapping("/sample/*")
@Controller     //servlet-context.xml 의 component-scan 태그 때문.
public class SampleController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("")
	public void basic() {
		logger.info("basic.....");
		
	}
	
	@RequestMapping(value="/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basic2() {
		logger.info("basic2.....");
		
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		logger.info("basic only get ....");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		//java class를 이요하는 방식
		logger.info("" + dto);
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		// 간단한 방식
		logger.info("name:" +name);
		logger.info("age:" + age);
		return "ex02";
	}
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		logger.info("ids: " +ids);
		return "ex02List";
	}
	
	@GetMapping("/ex02Bean")
	public void ex02Bean(SampleDTOList list) {
		logger.info("list dtos: " + list);
		//return "ex02Bean";
	}
	
	//@InitBinder
	//public void initBinder(WebDataBinder binder) {
	//	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
	//	binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
	//}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		logger.info("todo: "+todo);
		return "ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		logger.info("dto :" + dto);
		logger.info("page :"+page);
		
		return "sample/ex04";
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		logger.info("/ex06......................");
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		
		return dto;
	}
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07(){
		logger.info("/ex07........................");
		String msg= "{\"name\" : \"홍길동\"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg,header,HttpStatus.OK);
	}
	
	//@GetMapping("/exUpload")
	@PostMapping("/exUpload")
	public void exUpload() {
		logger.info("/exUpload.....");
	}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files ) {
		files.forEach(file-> {
			logger.info("..................................");
			logger.info("name+ " +file.getOriginalFilename());
			logger.info("size: "+file.getSize());
		});
		//return "sample/exUpload";
	}
	
}
