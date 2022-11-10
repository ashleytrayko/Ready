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
			<div class="container col-lg-8">
			
		
			<!-- 이 안에서 작업! 여기가 본문-->
			<h1>판결 페이지</h1>
			<div class="container">
				<form action="/admin/punish" method="post">
					<div class="form-group">
						<label for="userNickname">닉네임</label> 
						<input type="text" class="form-control mt-2 mb-3" id="userNickname" name="userNickname" value="${commWriter }">
					</div>
					<div class="form-group">
						<label for="punishment">처벌내용</label><br>
						<input type="radio" name="punishment" value="suspend">
						<label>글쓰기 정지</label>
						<input type="radio" name="punishment" value="getout">
						<label>강제 탈퇴</label>
<!-- 							<option value="suspend">글쓰기 정지</option>
							<option value="getout">강제탈퇴</option> -->
					</div>
						<label for="punishReason">처벌사유</label>
					<div class="form-group">
						<textarea class="form-control" rows="10" cols="50" name="punishReason"></textarea>
					</div>
					<button class="btn btn-outline-dark" type="submit">판결</button>
				</form>
			</div>
		</div>
	</div>
		</div>
	<footer> </footer>
	<script>
	</script>
</body>
</html>