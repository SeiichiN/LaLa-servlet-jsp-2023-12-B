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
			<h2>新規社員情報登録</h2>
			<ul>
				<c:forEach var="errMsg" items="${errors}">
					<li class="errMsg"><c:out value="${errMsg}"/></li>					
				</c:forEach>
			</ul>
			<form action="createConfirm" method="post">
				<ul>
					<li>
						<label>ID:<input type="text" name="id"
						                 value="<c:out value="${emp.id}"/>"></label>
					</li>
					<li>
						<label>名前:<input type="text" name="name"
						                   value="<c:out value="${emp.name}"/>"></label>
					</li>
					<li>
						<label>年齢:<input type="number" name="age"
						                   value="<c:out value="${emp.age}"/>"></label>
					</li>
					<li>
						<label>部署:
							<select name="dept_id">
								<c:forEach var="dept" items="${deptList}">
									<option value="<c:out value="${dept.id}"/>"
											<c:if test="${dept.id == emp.dept.id}">selected</c:if>>
										<c:out value="${dept.name}"/>
									</option>
								</c:forEach>
							</select>
						</label>
					</li>
				</ul>
				<input type="submit" value="確認">
				<input type="submit" value="取消" 
				       formaction="list" formmethod="get">				
			</form>
		</article>
		<jsp:include page="../common/aside.jsp" />
	</main>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>