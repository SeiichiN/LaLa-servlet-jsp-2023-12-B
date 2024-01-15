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
			<h2>社員情報更新確認</h2>
			<ul>
				<li>
					ID:<c:out value="${emp.id}"/>
				</li>
				<li>
					名前:<c:out value="${emp.name}"/>
				</li>
				<li>
					年齢:<c:out value="${emp.age}"/>
				</li>
				<li>
					部署:<c:out value="${emp.dept.name}"/>
				</li>
			</ul>
			<form action="deleteDone" method="post">
				<input type="hidden" name="id" value="${emp.id}">
				<input type="submit" value="削除">
				<input type="submit" value="取消" 
				       formaction="delete" formmethod="post">				
			</form>
		</article>
		<jsp:include page="../common/aside.jsp" />
	</main>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>