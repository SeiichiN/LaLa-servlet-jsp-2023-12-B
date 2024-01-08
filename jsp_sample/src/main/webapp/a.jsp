<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <% request.setAttribute("Greeting", "Hello World"); %> --%>
<jsp:include page="b.jsp" flush="true" >
	<jsp:param name="Greeting" value="Hello World" />
</jsp:include>
