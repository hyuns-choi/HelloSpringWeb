package org.oraclejava.spring.sample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	private static ApplicationContext context;
	private static JdbcTemplate jdbcTemplate;
	private static NamedParameterJdbcTemplate jdbcTemplate2;
	
	static {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate = context.getBean(JdbcTemplate.class);
		
		jdbcTemplate2 = context.getBean(NamedParameterJdbcTemplate.class);
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

	
	@RequestMapping(value="/member/add", method=RequestMethod.GET)
	public String createMember(Map<String, Object> model) {
		model.put("memberForm", new MemberForm());
		return "member/add";
	}
	
	@RequestMapping(value="/member/add", method=RequestMethod.POST)
	public String createMember(MemberForm form) {
		
		Member member = new Member();
		member.setMemberid(form.getMemberid());
		member.setPasswd(form.getPasswd());
		member.setEmail(form.getEmail());
		member.setUsertype(form.getUsertype());
		member.setActive("1");
		
		String sql = "insert into members(memberid, passwd, email, usertype, active) values (" +
				":memberid, :passwd, :email, :usertype, :active)";
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("memberid", member.getMemberid());
		parameters.put("passwd", member.getPasswd());
		parameters.put("email", member.getEmail());
		parameters.put("usertype", member.getUsertype());
		parameters.put("active", member.getActive());
		
		jdbcTemplate2.update(sql, parameters);
		
		return "redirect:/member/list";
	}
	

	@RequestMapping(value="/member/edit/{memberId}", method=RequestMethod.GET)
	public String editMember(Map<String, Object> model, @PathVariable String memberId) {
		
		Map<String, Object> map = jdbcTemplate.queryForMap("select * from members where memberid=?", memberId);
		
		MemberForm form = new MemberForm();
		form.setMemberid(map.get("memberid").toString());
		form.setPasswd(map.get("passwd").toString());
		form.setEmail(map.get("email").toString());
		form.setUsertype(map.get("usertype").toString());
		form.setActive(map.get("active").toString());
		
		model.put("memberForm", form);
		return "member/edit";
	}
	
	@RequestMapping(value="/member/edit/{memberId}", method=RequestMethod.POST)
	public String editMember(MemberForm form, @PathVariable String memberId) {
		
		Member member = new Member();
		member.setMemberid(form.getMemberid());
		member.setPasswd(form.getPasswd());
		member.setEmail(form.getEmail());
		member.setUsertype(form.getUsertype());
		member.setActive("1");
		
		String sql = "update members set passwd=:passwd, email=:email, usertype=:usertype where memberid = :memberid";
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("memberid", memberId);//member.getMemberid());
		parameters.put("passwd", member.getPasswd());
		parameters.put("email", member.getEmail());
		parameters.put("usertype", member.getUsertype());
		//parameters.put("active", member.getActive());
		
		jdbcTemplate2.update(sql, parameters);
		
		return "redirect:/member/list";
	}
	
	@RequestMapping(value="/member/del/{memberId}", method=RequestMethod.GET)
	public String delMember(MemberForm form, @PathVariable String memberId) {
		
		String sql = "delete from members where memberid = '" + memberId + "'";
		
		jdbcTemplate.update(sql);
		
		return "redirect:/member/list";
	}
	
	
}
