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
			<h2>部署情報更新確認</h2>
			<ul>
				<li>
					ID:<c:out value="${dept.id}"/>
				</li>
				<li>
					部署名:<c:out value="${dept.name}"/>
				</li>
			</ul>
			<form action="updateDeptDone" method="post">
				<input type="hidden" name="dept_id" value="${dept.id}">
				<input type="hidden" name="dept_name" value="${dept.name}">
				<input type="submit" value="更新">
				<input type="submit" value="取消" 
				       formaction="updateDept" formmethod="post">				
			</form>
		</article>
		<jsp:include page="../common/asideDept.jsp" />
	</main>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>