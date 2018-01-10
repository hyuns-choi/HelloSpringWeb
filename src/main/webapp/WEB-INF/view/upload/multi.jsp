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
<title>Multi File Upload</title>
</head>
<body>
	<h4>멀티 파일 업로드</h4>
	
	<form:form modelAttribute="formUpload" method="post" enctype="multipart/form-data">
	<!-- FileUpload CommonsMultipartFile[] 'files' 이름과 같이 해야함 -->
		<form:input path="files" type="file" multiple="multiple"/>
		
		<input type="submit"/>	
	
	</form:form>
		
		
</body>
</html>