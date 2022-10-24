<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공용jsp틀</title>
<!-- 타이틀 밑에 아래 css링크 추가해줄것 -->
<link rel="stylesheet" href="/resources/css/main/mainHeader.css">
</head>
<body>
	<jsp:include page="../main/commHeader.jsp"></jsp:include>
    <div class="main-contents">
		<div class="main-sidebar">여기는 사이드바
		
		</div>
		<div class="main-section">
		<!-- 이 안에서 작업! 여기가 본문-->
		
		
		
		</div>
		<div class="main-sidebar">여기는 사이드바</div>
    </div>
	<footer>
		
	</footer>
</body>
</html>