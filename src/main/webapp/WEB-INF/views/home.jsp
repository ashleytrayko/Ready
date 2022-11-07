<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
			margin-left : 3%;
		}
		.book-title {
			width : 170px;
			text-decoration : none;
		}
		.card {
			width : 15%;
		}
		.more{
			float : right;
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
				
				<div>
					<h5>READ'Y 베스트셀러</h5>
					<a href = "/book/category.kh?category=Best" class="more">더보기</a>
				</div>
				<c:forEach items="${bList1 }" var="book" end="4">
					<div class="card" id="book-area">
						<a href="/book/detailView.kh?bookNo=${book.bookNo }" class="book-detail">
							<img src=${book.imgPath } width="180" height="250" class="card-img-top"><br>
							<div class="card-body">
								<c:choose>
                            		<c:when test="${fn:length(book.bookTitle) gt 20 }">
                            			<c:out value="${fn:substring(book.bookTitle, 0, 19) }...">
                            			</c:out>
                            		</c:when>
                            		<c:otherwise>
                            			<c:out value="${book.bookTitle }">
                            			</c:out>
                            		</c:otherwise>
<%--                             <p id="bookTitle" style="margin-bottom: 10%;">${cartList.book.bookTitle }</p> --%>
                            	</c:choose>	
							</div><br>
						</a>
					</div>
				</c:forEach>
				<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
				<c:if test="${!empty bList3 && !empty principal }">
				<div>
					<h5>READ'Y 추천도서</h5>
					<a href = "/book/category.kh?category=Best" class="more">더보기</a>
				</div>
				<c:forEach items="${bList3 }" var="book" end="4">
					<div class="card" id="book-area">
						<a href="/book/detailView.kh?bookNo=${book.bookNo }" class="book-detail">
							<img src=${book.imgPath } width="180" height="250" class="card-img-top"><br>
							<div class="card-body">
								<c:choose>
                            		<c:when test="${fn:length(book.bookTitle) gt 20 }">
                            			<c:out value="${fn:substring(book.bookTitle, 0, 19) }...">
                            			</c:out>
                            		</c:when>
                            		<c:otherwise>
                            			<c:out value="${book.bookTitle }">
                            			</c:out>
                            		</c:otherwise>
<%--                             <p id="bookTitle" style="margin-bottom: 10%;">${cartList.book.bookTitle }</p> --%>
                            	</c:choose>	
							</div><br>
						</a>
					</div>
				</c:forEach>
				<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
				</c:if>
				<div>
					<h5>READ'Y 신작</h5>
					<a href = "/book/category.kh?category=New" class="more">더보기</a>
				</div>
				<c:forEach items="${bList2 }" var="book" end="4">
					<div class="card" id="book-area">
						<a href="/book/detailView.kh?bookNo=${book.bookNo }" class="book-detail">
							<img src=${book.imgPath } width="180" height="250" class="card-img-top"><br>
							<div class="card-body">
								<c:choose>
                            		<c:when test="${fn:length(book.bookTitle) gt 20 }">
                            			<c:out value="${fn:substring(book.bookTitle, 0, 19) }...">
                            			</c:out>
                            		</c:when>
                            		<c:otherwise>
                            			<c:out value="${book.bookTitle }">
                            			</c:out>
                            		</c:otherwise>
<%--                             <p id="bookTitle" style="margin-bottom: 10%;">${cartList.book.bookTitle }</p> --%>
                            	</c:choose>	
							</div><br>
						</a>
					</div>
				</c:forEach>
				<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
				<div>
					<h5>READ'Y 소설</h5>
					<a href = "/book/category.kh?category=소설" class="more">더보기</a>
				</div>
				<c:forEach items="${bList4 }" var="book" end="4">
					<div class="card" id="book-area">
						<a href="/book/detailView.kh?bookNo=${book.bookNo }" class="book-detail">
							<img src=${book.imgPath } width="180" height="250" class="card-img-top"><br>
							<div class="card-body">
								<c:choose>
                            		<c:when test="${fn:length(book.bookTitle) gt 20 }">
                            			<c:out value="${fn:substring(book.bookTitle, 0, 19) }...">
                            			</c:out>
                            		</c:when>
                            		<c:otherwise>
                            			<c:out value="${book.bookTitle }">
                            			</c:out>
                            		</c:otherwise>
<%--                             <p id="bookTitle" style="margin-bottom: 10%;">${cartList.book.bookTitle }</p> --%>
                            	</c:choose>	
							</div><br>
						</a>
					</div>
				</c:forEach>
				<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
				<div>
					<h5>READ'Y 만화</h5>
					<a href = "/book/category.kh?category=만화" class="more">더보기</a>
				</div>
				<c:forEach items="${bList5 }" var="book" end="4">
					<div class="card" id="book-area">
						<a href="/book/detailView.kh?bookNo=${book.bookNo }" class="book-detail">
							<img src=${book.imgPath } width="180" height="250" class="card-img-top"><br>
							<div class="card-body">
								<c:choose>
                            		<c:when test="${fn:length(book.bookTitle) gt 20 }">
                            			<c:out value="${fn:substring(book.bookTitle, 0, 19) }...">
                            			</c:out>
                            		</c:when>
                            		<c:otherwise>
                            			<c:out value="${book.bookTitle }">
                            			</c:out>
                            		</c:otherwise>
<%--                             <p id="bookTitle" style="margin-bottom: 10%;">${cartList.book.bookTitle }</p> --%>
                            	</c:choose>	
							</div><br>
						</a>
					</div>
				</c:forEach>
				<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
				<div>
					<h5>READ'Y Study</h5>
					<a href = "/book/category.kh?category=study" class="more">더보기</a>
				</div>
				<c:forEach items="${bList6 }" var="book" end="4">
					<div class="card" id="book-area">
						<a href="/book/detailView.kh?bookNo=${book.bookNo }" class="book-detail">
							<img src=${book.imgPath } width="180" height="250" class="card-img-top"><br>
							<div class="card-body">
								<c:choose>
                            		<c:when test="${fn:length(book.bookTitle) gt 20 }">
                            			<c:out value="${fn:substring(book.bookTitle, 0, 19) }...">
                            			</c:out>
                            		</c:when>
                            		<c:otherwise>
                            			<c:out value="${book.bookTitle }">
                            			</c:out>
                            		</c:otherwise>
<%--                             <p id="bookTitle" style="margin-bottom: 10%;">${cartList.book.bookTitle }</p> --%>
                            	</c:choose>	
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
