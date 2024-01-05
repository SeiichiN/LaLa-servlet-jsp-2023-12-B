<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/common.jsp" %>
<%
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
String today = sdf.format(date);
%>
<!DOCTYPE html>
<html>
<jsp:include page="common/head.jsp" />
<body>
	<jsp:include page="common/header.jsp" />
	<article>
		<h1>どこつぶへようこそ<%= name %></h1>
		<p>今日は<%= today %>です。</p>
		<div>${human}</div>
		<div>${human.name}</div>
		<div>${human.age}</div>
		<p>${sessionScope.human.name} : ${sessionScope.human.age }</p>
	</article>
	<jsp:include page="common/footer.jsp" />
</body>
</html>