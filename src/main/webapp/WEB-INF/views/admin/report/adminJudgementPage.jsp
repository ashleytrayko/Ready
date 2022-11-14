<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png"  href="/resources/images/favicon.ico"/>
<meta charset="UTF-8">
<title>처분 페이지</title>
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
					<input type="hidden" id="boardNo" name="boardNo" value="${boardNo }">
					<div class="form-group">
						<label for="userId">닉네임</label> 
						<input type="text" class="form-control mt-2 mb-3" id="userId" name="userId" value="${userId }">
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
						<label class="mt-3" for="punishReason">처벌사유</label>
					<div class="form-group">
						<textarea class="form-control" rows="10" cols="50" name="punishReason"></textarea>
					</div>
					<div class="mt-3" style="text-align: center">
						<button class="btn btn-outline-dark" type="submit">판결</button>
						<button class="btn btn-outline-dark" onclick="history.back()">돌아가기</button>
					</div>
				</form>
			</div>
		</div>
			<footer>
								<jsp:include page="../../../views/main/footer.jsp"></jsp:include>
			</footer>
	</div>
		</div>
	<script>
	</script>
</body>
</html>