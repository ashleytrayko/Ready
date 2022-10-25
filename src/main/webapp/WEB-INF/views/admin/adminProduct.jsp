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
</head>
<body>
	<jsp:include page="../admin/adminHeader.jsp"></jsp:include>
	<div class="main-contents">
		<div class="main-sidebar">
			여기는 사이드바
			<div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark"
				style="width: 280px;">
				<a href="/"
					class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
					<span class="fs-4">Admin Page</span>
				</a>
				<hr>
				<ul class="nav nav-pills flex-column mb-auto">
					<li class="nav-item"><a href="/admin" class="nav-link active"
						aria-current="page"> Admin Home </a></li>
					<li><a href="/admin-notice" class="nav-link text-white">
							공지사항 </a></li>
					<li><a href="/admin-banner" class="nav-link text-white">
							배너관리 </a></li>
					<li><a href="/admin-report" class="nav-link text-white">
							신고관리 </a></li>
					<li><a href="/admin-product" class="nav-link text-white">
							상품관리 </a></li>
					<li><a href="/admin-order" class="nav-link text-white">
							주문관리 </a></li>
					<li><a href="/admin-qna" class="nav-link text-white">
							Q&A관리 </a></li>
				</ul>
				<hr>
				<div class="dropdown">
					<a href="#"
						class="d-flex align-items-center text-white text-decoration-none dropdown-toggle"
						id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
						<img src="https://github.com/mdo.png" alt="" width="32"
						height="32" class="rounded-circle me-2"> <strong>Admin</strong>
					</a>
					<ul class="dropdown-menu dropdown-menu-dark text-small shadow"
						aria-labelledby="dropdownUser1">
						<li><a class="dropdown-item" href="#">New project...</a></li>
						<li><a class="dropdown-item" href="#">Settings</a></li>
						<li><a class="dropdown-item" href="#">Profile</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="#">Sign out</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="main-section">
			<!-- 이 안에서 작업! 여기가 본문-->
			<h1>상품 관리</h1>
			<table border="1" align="center">
				<thead>
					<tr>
						<th></th>
						<th>상품번호</th>
						<th>책 제목</th>
						<th>저자</th>
						<th>출판사</th>
						<th>수정</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${bookList }" var="bookList" varStatus="i">
					<tr>
						<td><input type="checkbox"></td>
						<td>${bookList.bookNo }</td>
						<td>
						<a href="/book/detailView.kh?bookNo=${bookList.bookNo }">
						${bookList.bookTitle }
						</a>
						</td>
						<td>${bookList.bookWriter }</td>
						<td>${bookList.publisher }</td>
						<td><button type="button" onclick="modifyNotice(${noticeList.noticeNumber})">수정하기</button></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<button>상품 등록</button>
			<button>상품 삭제</button>



		</div>
		<div class="main-sidebar">여기는 사이드바</div>
	</div>
	<footer> </footer>
	<script>
	function modifyNotice(noticeNumber){
		location.href="/modifyNoticeForm?noticeNumber="+noticeNumber;
	}
	</script>
</body>
</html>