<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
  <link rel="stylesheet" href="/resources/css/main/mainHeader.css">
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
			<h2 align="center">게시글 작성</h1>
			<form action="/comm/register.kh" method="post" enctype="multipart/form-data">
				<table align="center" border="none">
					<tr>
						<td>제목</td>
						<td><input type="text" name="commTitle"></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text" name="commWriter"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td>
							<textarea class="summernote" name="commContents"></textarea>
						</td>
					</tr>
					<tr>
						<td>
							<button>취소</button>
						</td>
						<td>
							<button>등록</button>
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
		$('.summernote').summernote({
		  height: 150,
		  width: 600,
		  lang: "ko-KR",
/* 		  focus : true, */
		});
	</script>
</body>
</html>