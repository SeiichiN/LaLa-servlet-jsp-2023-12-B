<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// String msg = (String) request.getAttribute("Greeting");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
The greeting from b is:<%= request.getParameter("Greeting") %>
</body>
</html>