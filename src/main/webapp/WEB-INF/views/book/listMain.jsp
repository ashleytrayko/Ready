<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		#book-area {
			float : left;
			margin-right : 6px;
		}
		.book-title {
			width : 170px;
			text-decoration : none;
		}
	</style>
	<jsp:include page="../main/header.jsp"></jsp:include>
	<link rel="stylesheet" href="/resources/css/main/mainHeader.css">
</head>
<body>
	<div class="main-contents">
		<div class="col-md-3">여기는 사이드바</div>
		
		<div class="main-section">
			<h3>${category }에 대한 책</h3>
			<div>
				<h5>신작</h5>
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
			</div>
			<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
			<div>
				<h5>인기작 </h5>
				<c:forEach items="${bList2 }" var="book" end="4">
					<div class="card" id="book-area" style="width: 12rem">
						<a href="/book/detailView.kh?bookNo=${book.bookNo }" class="book-detail">
							<img src=${book.imgPath } width="180" height="250" class="card-img-top"><br>
							<div class="book-title">${book.bookTitle }</div><br>
						</a>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</html>