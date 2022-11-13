<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png"  href="/resources/images/favicon.ico"/>
<meta charset="UTF-8">
<title>공지사항 보기</title>
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
			<div class="container col-lg-8">
				<table class="table">
					<thead>
					<tr>
						<th class="table-light" colspan="2">
							<h5>${notice.noticeTitle }</h5>
						</th>
					</tr>
					</thead>
					<tbody>
					<tr>
						<td style="text-align:left">
							${notice.noticeWriter }
						</td>
						<td style="text-align:right">
							<fmt:formatDate value="${notice.postDate }" pattern="yyyy-mm-dd hh:mm:ss"/>
						</td>
					</tr>
					<tr>	
						<td colspan="2">
							<p>${notice.noticeContents }</p>
						</td>
					</tr>
					<tr>
						<td colspan=2" style="text-align:center">
							<button class="btn btn-outline-dark" onclick="modifyNotice(${notice.noticeNumber})">수정하기</button>
							<button class="btn btn-outline-dark" onclick="location.href='/admin/admin-notice'">목록으로</button>
							<button class="btn btn-outline-dark" onclick="removeNotice(${notice.noticeNumber})">삭제하기</button>
						</td>
					</tr>
					</tbody>
				</table>
			</div>
		<footer> 
							<jsp:include page="../../../views/main/footer.jsp"></jsp:include>
		</footer>
		</div>
	</div>
	<script>
		$('.summernote').summernote({
			height : 150,
			width : 600,
			lang : "ko-KR",
		/* 		  focus : true, */
		});
		
		function removeNotice(noticeNumber){
			location.href="/admin/removeNotice?noticeNumber="+noticeNumber;
		}
		
		function modifyNotice(noticeNumber){
			location.href="/admin/modifyNoticeForm?noticeNumber="+noticeNumber;
		}
	</script>
</body>
</html>