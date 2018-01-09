package org.oraclejava.spring.sample;

import javax.xml.bind.annotation.XmlRootElement;

//xml로 사용하겠다는 없으면 json   http://localhost:8081/HelloSpringWeb/user.json?userId=11233&deptNo=333
//						  http://localhost:8081/HelloSpringWeb/user.xml?userId=11233&deptNo=333
@XmlRootElement		
public class UserInfo {
	private String userId;
	private String userName;
	private String deptNo;	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}	
}
