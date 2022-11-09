<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공용jsp틀</title>
<!-- 타이틀 밑에 아래 css링크 추가해줄것 -->
<link rel="stylesheet" href="/resources/css/main/mainHeader.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- 서머노트를 위해 추가해야할 부분 -->
<script src="/resources/js/summernote-lite.js"></script>
<script src="/resources/js/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="/resources/css/summernote-lite.css">
</head>
<body>
	<jsp:include page="../../admin/adminHeader.jsp"></jsp:include>
	<div class="main-contents">
		<div class="main-sidebar">
						<jsp:include page="../../admin/adminSideBar.jsp"></jsp:include>
		</div>
		<div class="main-section">
			<!-- 이 안에서 작업! 여기가 본문-->
			<h1>공지사항 수정</h1>
			<form method="post" action="/admin/modifyNotice">
				<input type="hidden" name="noticeNumber" value="${notice.noticeNumber }">
				<input type="text" name="noticeTitle" value="${notice.noticeTitle }">
				<textarea class="summernote" name="noticeContents">${notice.noticeContents }</textarea>
				<button type="submit">공지사항 수정</button>
				<button type="button" onclick="history.back();">뒤로가기</button>
			</form>
		</div>
		<div class="main-sidebar">여기는 사이드바</div>
	</div>
	<footer> </footer>
	<script>
		$('.summernote').summernote({
			height : 150,
			width : 600,
			lang : "ko-KR",
		/* 		  focus : true, */
		});
	</script>
</body>
</html>