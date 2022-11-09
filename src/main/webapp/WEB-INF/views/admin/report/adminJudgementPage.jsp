<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공용jsp틀</title>
<!-- 타이틀 밑에 아래 css링크 추가해줄것 -->
<link rel="stylesheet" href="/resources/css/main/mainHeader.css">
</head>
<body>
	<jsp:include page="../../admin/adminHeader.jsp"></jsp:include>
	<div class="main-contents">
		<div class="main-sidebar">
						<jsp:include page="../../admin/adminSideBar.jsp"></jsp:include>
		</div>
		<div class="main-section">
			<!-- 이 안에서 작업! 여기가 본문-->
			<h1>판결 페이지</h1>
			<div class="container">
				<form action="/admin/punish" method="post">
					<div class="form-group">
						<label for="userId">닉네임</label> 
						<input type="text" class="form-control" id="userNickname" name="userNickname" value="${commWriter }">
					</div>
					<div class="form-group">
						<label for="punishment">처벌내용</label>
						<select name="punishment">
							<option value="suspend">글쓰기 정지</option>
							<option value="getout">강제탈퇴</option>
						</select>
					</div>
					<div class="form-group">
						<label for="">처벌사유</label>
						<textarea rows="10" cols="50" name="punishReason"></textarea>
					</div>
					<button type="submit">판결</button>
				</form>
			</div>
		</div>
		<div class="main-sidebar">여기는 사이드바</div>
	</div>
	<footer> </footer>
	<script>
	</script>
</body>
</html>