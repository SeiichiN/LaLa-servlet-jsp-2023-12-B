<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="common/head.jsp" />
<body>
	<jsp:include page="common/header.jsp" />
	<main class="main center">
		<article>
			<table>
				<tr>
					<th>ID</th>
					<th>名前</th>
					<th>年齢</th>
					<th class="no-border"></th>
					<th class="no-border"></th>
				</tr>
				<c:forEach var="emp" items="${empList}">
					<tr>
						<td>${emp.id}</td>
						<td>${emp.name}</td>
						<td>${emp.age}</td>
						<td class="no-border">編集</td>
						<td class="no-border">削除</td>
					</tr>
				</c:forEach>
			</table>
		</article>
		<jsp:include page="common/aside.jsp" />
	</main>
	<jsp:include page="common/footer.jsp" />
</body>
</html>