<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<sec:authorize access="hasRole('ROLE_ADMIN')">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>
<html>
<head>
<meta charset="UTF-8">
<title>공용jsp틀</title>
<!-- 타이틀 밑에 아래 css링크 추가해줄것 -->
<link rel="stylesheet" href="/resources/css/main/mainHeader.css">
</head>
<body>
	<jsp:include page="../admin/adminHeader.jsp"></jsp:include>
	<div class="main-contents">
		<div class="main-sidebar">
			<jsp:include page="../admin/adminSideBar.jsp"></jsp:include>
		</div>
		<div class="main-section">
			<!-- 이 안에서 작업! 여기가 본문-->
			<h2>관리자님 안녕하세요.</h2>
			<h5>관리자 메뉴입니다.</h5>
			<h5>원하는 메뉴를 왼쪽에서 선택해주세요.</h5>
			<p>오늘의 주요 업무</p>
			<p>문의 n건, 처리 n-m건</p>
			</div>
		</div>
	</div>
	
	<footer></footer>
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>

</body>
</html>