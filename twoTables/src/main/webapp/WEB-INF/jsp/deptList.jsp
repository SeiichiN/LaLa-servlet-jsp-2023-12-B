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
					<th>部署名</th>
					<th class="no-border"></th>
					<th class="no-border"></th>
				</tr>
				<c:forEach var="dept" items="${deptList}">
					<tr>
						<td><c:out value="${dept.id}"/></td>
						<td><c:out value="${dept.name}"/></td>
						<td class="no-border">
						  <form acttion="updateDept" method="GET">
						  	<input type="hidden" name="dept_id" value="${dept.id}">
						  	<button class="image-btn" type="submit">${img_pencil}</buttopn>
						  </form>
						</td>
						<td class="no-border">
						  <form acttion="deleteDept" method="GET">
						  	<input type="hidden" name="dept_id" value="${dept.id}">
						  	<button class="image-btn" type="submit">${img_trash}</buttopn>
						  </form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</article>
		<jsp:include page="common/aside.jsp" />
	</main>
	<jsp:include page="common/footer.jsp" />
</body>
</html>