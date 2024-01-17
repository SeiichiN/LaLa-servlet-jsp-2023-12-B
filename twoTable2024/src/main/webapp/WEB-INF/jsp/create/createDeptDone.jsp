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
			<h2>新規部署登録結果</h2>
			<p><c:out value="${msg}" /></p>
			<p><a href="deptList">一覧へ</a></p>
		</article>
		<jsp:include page="../common/asideDept.jsp" />
	</main>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>