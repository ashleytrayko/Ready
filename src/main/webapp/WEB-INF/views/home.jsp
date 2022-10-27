<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>READ'Y</title>
	<jsp:include page="../views/main/header.jsp"></jsp:include>
	<link rel="stylesheet" href="/resources/css/main/mainHeader.css">
</head>
<body>
	<p>${principal.username}</p>
	<div class="main-contents">
		<div class="col-md-3">여기는 사이드바</div>
		<div class="main-section">
				<button onclick="viewCategory(event);">소설</button>
				<button onclick="viewCategory(event);">만화</button>
				<button onclick="viewCategory(event);">자기계발</button>
		</div>
	</div>
	
	
	<script>
		function viewCategory(event) {
			category = event.target.innerText;
			location.href="/book/category.kh?searchCondition=" + category;
		}
	</script>

</body>
</html>
