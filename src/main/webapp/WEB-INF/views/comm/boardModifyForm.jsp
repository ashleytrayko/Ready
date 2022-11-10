<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정 페이지</title>
<!-- 타이틀 밑에 아래 css링크 추가해줄것 -->
<link rel="stylesheet" href="/resources/css/main/mainHeader.css">
<link rel="stylesheet" href="/resources/css/que/queWriteForm.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- 서머노트를 위해 추가해야할 부분 -->
  <script src="/resources/js/summernote-lite.js"></script>
  <script src="/resources/js/lang/summernote-ko-KR.js"></script>
  <link rel="stylesheet" href="/resources/css/summernote-lite.css">
</head>
<body>
	<jsp:include page="../main/commHeader.jsp"></jsp:include>
    <div class="main-contents">
		<div class="main-sidebar">여기는 사이드바</div>
		<div class="main-section">
		<!-- 이 안에서 작업! 여기가 본문-->
			<h2 align="center">게시글 수정</h1>
			<form action="/comm/modify.kh" method="post" enctype="multipart/form-data">
				<input type="hidden" name="page" value="${page }">
				<input type="hidden" name="boardNo" value="${comm.boardNo }">
				<table align="center" border="none">
					<tr>
						<td>제목</td>
						<td><input type="text" name="commTitle" value="${comm.commTitle}" class="qTitle" placeholder="제목을 입력해주세요." autofocus></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text" name="commWriter" value="${comm.commWriter }" readonly class="qTitle"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td>
							<textarea class="summernote" name="commContents" value="${comm.commContents }"></textarea>
						</td>
					</tr>
					<tr>
						<td>
							<button type="button" onclick="listMember();">취소</button>
						</td>
						<td>
							<input type="submit" value="등록">
						</td>
					</tr>
				</table>
			</form>
		
		
		
		</div>
		<div class="main-sidebar">여기는 사이드바</div>
    </div>
	<footer>
		
	</footer>
	<script>
		function listMember() {
			if(confirm("목록으로 돌아가시겠습니까?")) {
				location.href = "/comm/list.kh";
			}
		}
		// 서머노트 초기화
		$('.summernote').val("${comm.commContents}");
		$('.summernote').summernote({
		        height: 300,
		        width: 600,
		        lang: 'ko-KR',
		        placeholder: '내용을 입력해주세요.'
		 });
	</script>
</body>
</html>