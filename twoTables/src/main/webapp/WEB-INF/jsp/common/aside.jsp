<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<aside>
	<h2>サブメニュー</h2>
	<ul>
		<li><a href="create">新規登録</a></li>
		<li><a href="createDept">新規部署登録</a></li>
		<li><a href="deptList">部署一覧</a></li>
		<li>
			<form class="search-form" action="searchName" method="GET">
				<input type="text" name="name" placeholder="名前検索">
				<button type="submit" class="image-btn">${img_find}</button>
			</form>
		</li>
		<li>
			<form class="search-form" action="searchDept" method="GET">
				<select name="dept_id">
					<c:forEach var="dept" items="${deptList}">
						<option value="${dept.id}">${dept.name}</option>
					</c:forEach>
				</select>
				<button type="submit" class="image-btn">${img_find}</button>
			</form>
		</li>
	</ul>
</aside>