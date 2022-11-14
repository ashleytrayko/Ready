<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/png"  href="/resources/images/favicon.ico"/>
<title>게시글 작성</title>
  <link rel="stylesheet" href="/resources/css/main/mainHeader.css">
  <link rel="stylesheet" href="/resources/css/que/queWriteForm.css">
  <link rel="stylesheet" href="/resources/css/comm/listView.css">
  <link rel="stylesheet" href="/resources/css/comm/commForm.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- 서머노트를 위해 추가해야할 부분 -->
  <script src="/resources/js/summernote-lite.js"></script>
  <script src="/resources/js/lang/summernote-ko-KR.js"></script>
  <link rel="stylesheet" href="/resources/css/summernote-lite.css">
  <!--  -->
</head>
<body>
	<jsp:include page="../main/commHeader.jsp"></jsp:include>
	<div class="main-contents">
		<div class="main-sidebar">여기는 사이드바</div>
		<div class="main-section">
			<div class="list-div">
				<h2 class="list-title">게시글 작성</h2>
				<form action="/comm/register.kh" method="post" enctype="multipart/form-data" class="main-form">
					<table class="table-style list-table">
						<tr>
							<td class="center">제목</td>
							<td><input type="text" name="commTitle" class="qTitle write-title write-input border-top" placeholder="제목을 입력해주세요." autofocus></td>
						</tr>
						<tr>
							<td class="center">작성자</td>
							<td><input type="text" name="commWriter" class="write-input write-title qTitle input-readonly" value="${principal.user.userNickname }" readonly class="qTitle"></td>
							<input type="hidden" name="commId" value="${principal.user.userId }" readonly>
						</tr>
						<tr>
							<td class="center">내용</td>
							<td>
								<textarea class="summernote" name="commContents" width="100%"></textarea>
							</td>
						</tr>
						<tr>
							<td colspan="2" align="right">
								<button type="button" onclick="listMember();">취소</button>
								<button>등록</button>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="main-sidebar">여기는 사이드바</div>
    </div>
	<footer>
		
	</footer>
	<script>
		$('.summernote').summernote({
		 	placeholder: '내용을 입력해주세요.',
	        height: 300,
	        lang: 'ko-KR',
	 	});
		function listMember() {
			if(confirm("목록으로 돌아가시겠습니까?")) {
				location.href = "/comm/list.kh";
			}
		}
	</script>
</body>
</html>