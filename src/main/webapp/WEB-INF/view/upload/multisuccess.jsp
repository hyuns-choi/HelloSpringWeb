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
<title>multi File Upload</title>
</head>
<body>
	<h4>멀티 파일 업로드</h4>
	업로드 성공</p>
	
	<table border="1" style="width: 800px" align="center">
		<tr style="background-color: orange; height: 30px">
			<th style="width: 50px">순번</th>
			<th style="width: 400px">파일명</th>
			<th style="width: 50px">파일타입</th>
			<th style="width: 50px">사이즈</th>
		</tr>
		<c:forEach var="file" items="${fileList}" varStatus="status">
			<tr style="height: 30px">
				<td>${status.count}</td>
				<td>${file.filename}</td>
				<td>${file.filetype}</td>
				<td>${file.filesize}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>