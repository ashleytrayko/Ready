<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="isAuthenticated()">
   <sec:authentication property="principal" var="principal" />
</sec:authorize>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>READ'Y</title>
	<style>
		#book-area {
			float : left;
			margin-right : 10px;
		}
		.book-title {
			width : 170px;
			text-decoration : none;
		}
	</style>
	<jsp:include page="../views/main/header.jsp"></jsp:include>
	<link rel="stylesheet" href="/resources/css/main/mainHeader.css">
</head>
<body>
	<div class="main-contents">
		<div class="main-sidebar">여기는 사이드바</div>
		<div class="main-section">
				<button class="btn btn-outline-secondary" onclick="viewCategory(event);">소설</button>
				<button class="btn btn-outline-secondary" onclick="viewCategory(event);">만화</button>
				<button class="btn btn-outline-secondary" onclick="viewCategory(event);">자기계발</button>
				
				<h5>READ'Y 베스트셀러</h5>
<!-- 				더보기 : /book/bookList.kh?category=신작 -->
				<c:forEach items="${bList1 }" var="book" end="4">
					<div class="card" id="book-area" style="width: 12rem">
						<a href="/book/detailView.kh?bookNo=${book.bookNo }" class="book-detail">
							<img src=${book.imgPath } width="180" height="250" class="card-img-top"><br>
							<div class="card-body">
								<p class="card-text">${book.bookTitle }
							</div><br>
						</a>
					</div>
				</c:forEach>
				<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
				<h5>READ'Y 신작</h5>
<!-- 				더보기 : /book/bookList.kh?category=신작 -->
				<c:forEach items="${bList2 }" var="book" end="4">
					<div class="card" id="book-area" style="width: 12rem">
						<a href="/book/detailView.kh?bookNo=${book.bookNo }" class="book-detail">
							<img src=${book.imgPath } width="180" height="250" class="card-img-top"><br>
							<div class="card-body">
								<p class="card-text">${book.bookTitle }
							</div><br>
						</a>
					</div>
				</c:forEach>
		</div>
	</div>
	
	
	<script>
		function viewCategory(event) {
			category = event.target.innerText;
			location.href="/book/category.kh?category=" + category;
		}
	</script>

</body>
</html>
