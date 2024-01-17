<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="../common/head.jsp" />
<body>
	<jsp:include page="../common/header.jsp" />
	<main class="main center">
		<article>
			<h2>新規部署登録</h2>
			<ul>
				<c:forEach var="errMsg" items="${errors}">
					<li class="errMsg"><c:out value="${errMsg}"/></li>					
				</c:forEach>
			</ul>
			<form action="createDeptConfirm" method="post">
				<ul>
					<li>
						<label>部署ID:<input type="text" name="id"
						                 value="<c:out value="${dept.id}"/>"></label>
					</li>
					<li>
						<label>部署名:<input type="text" name="name"
						                   value="<c:out value="${dept.name}"/>"></label>
					</li>
				</ul>
				<input type="submit" value="確認">
				<input type="submit" value="取消" 
				       formaction="deptList" formmethod="get">				
			</form>
		</article>
		<jsp:include page="../common/aside.jsp" />
	</main>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>