<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 추가</title>
</head>
<body>
	<h2>회원 추가</h2>
	<form:form method="post" modelAttribute="memberForm">
		<form:label path="memberid">사용자id:</form:label>
		<form:input path="memberid"/><br/>
		<form:label path="passwd">비번:</form:label>
		<form:password path="passwd"/><br/>
		<form:label path="email">이메일:</form:label>
		<form:input path="email"/><br/>
		<form:label path="usertype">사용자타입:</form:label>
		<form:input path="usertype"/><br/>
		<br/>
		<input type="submit" value="저장"/>
	</form:form>
	


</body>
</html>