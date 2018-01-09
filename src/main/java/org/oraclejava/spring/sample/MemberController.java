package org.oraclejava.spring.sample;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	private static ApplicationContext context;
	private static JdbcTemplate jdbcTemplate;
	
	static {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate = context.getBean(JdbcTemplate.class);
	}
	
	@RequestMapping(value="/member/list", method=RequestMethod.GET)
	public String displayMember(Map<String, Object> model) {

		List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from members");
		
		model.put("memberList", list);
		
		
		//for(Map<String, Object> map : list) 
		{
			//String memberid = map.get("memberid").toString();
			//String password = map.get("passwd").toString();
			
			
			//System.out.println(memberid + "," + password);
		}
		
		return "member/list";
	}
	
	

}
