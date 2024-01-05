<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ健康診断の結果</title>
</head>
<body>
	<h1>スッキリ健康診断の結果</h1>
	<p>
	身長：${health.height}cm<br>
	体重：${health.weight}Kg<br>
	BMI：${health.bmi}<br>
	体型：${health.bodyType}
	</p>
	<a href="HealthCheck">もどる</a>
</body>
</html>