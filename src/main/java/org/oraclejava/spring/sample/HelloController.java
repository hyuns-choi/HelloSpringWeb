package org.oraclejava.spring.sample;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	
	@RequestMapping("/hello")
	public String helloWorld() {
		logger.info("----------hello world-----------");
		//return "hello";
		// 다른 url로 이동
		return "redirect:/hello2";
		//return "redirect:http://www.daum.net";
	}
	
	@RequestMapping("/hello2")
	public String hello2(Map<String, Object> model) {
		// new 할필요 없음
		//Date date = new Date();
		model.put("msg", "안녕하세요!!.");
		//model.put("date", "현재시간은 : " + date);
		model.put("date", "현재시간은 : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		return "hello2";
	}
	
	@RequestMapping(value="/hello3", method=RequestMethod.GET)
	public String hello3(@RequestParam("test") String test, @RequestParam("pass") String pass, Map<String, Object> model) {
		model.put("test", test);
		model.put("pass", pass);
		
		return "hello3";
	}
	
	@RequestMapping(value="/user", method= {RequestMethod.GET/*, RequestMethod.POST*/})
	@ResponseBody	// json 출력
	public UserInfo getUser(
			@RequestParam(value="userId", required=false) String userId,
			@RequestParam(value="deptNo", required=false) String deptNo) {
		
		//if(userId == null) userId = "8888";
		if(userId == null) return null;
		
		UserInfo info = new UserInfo();
		info.setDeptNo(deptNo);
		info.setUserId(userId);
		info.setUserName("승짱");
		
		return info;
	}
	
	// rest  diary/2018/01/08,  loc/38.001,125.02 (동등구조)
	//http://localhost:8081/HelloSpringWeb/user2/3/7
	@RequestMapping(value="/user2/{userId}/{deptNo}", method= {RequestMethod.GET/*, RequestMethod.POST*/})
	@ResponseBody	// json 출력
	public UserInfo getUser2(@PathVariable("userId") String userId,
			@PathVariable("deptNo") String deptNo) {
		
		//if(userId == null) userId = "8888";
		if(userId == null) return null;
		
		UserInfo info = new UserInfo();
		info.setDeptNo(deptNo);
		info.setUserId(userId);
		info.setUserName("승짱");
		
		return info;
	}
	
	
	// rest http://localhost:8081/HelloSpringWeb/user3/3,7
	@RequestMapping(value="/user3/{userId},{deptNo}", method= {RequestMethod.GET/*, RequestMethod.POST*/})
	@ResponseBody	// json 출력
	public UserInfo getUser3(@PathVariable("userId") String userId,
			@PathVariable("deptNo") String deptNo) {
		
		// 처리안됨
		//if(userId == null) return null;
		//if(deptNo == null) return null;
		
		UserInfo info = new UserInfo();
		info.setDeptNo(deptNo);
		info.setUserId(userId);
		info.setUserName("승짱");
			
		return info;
	}
}
