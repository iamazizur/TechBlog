<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="styles.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<%@include file="nav.jsp"%>
	<h1>Something went wrong</h1>

	<h3>
		Error :
		<%=exception.getMessage()%></h3>



	<%@include file="scripts.jsp"%>
</body>
</html>