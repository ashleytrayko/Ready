<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		.card-body > a {
			color : black;
			text-decoration : none;
		}
		.review-section {
			margin-left : 22%;
		}
	</style>
	<jsp:include page="../main/header.jsp"></jsp:include>
	<link rel="stylesheet" href="/resources/css/main/mainHeader.css">
</head>
<body>
	<div class="main-contents">
		<div class="main-sidebar">
			<jsp:include page="../main/mypageSideBar.jsp"></jsp:include>
		</div>
		
		 <div class="main-section">
		 	<div class="review-section">
				<c:if test="${!empty rList }">
					<c:forEach items="${rList }" var="review" varStatus="i">
						<div class="card mb-3" style="width: 700px;">
	  						<div class="row g-0">
	    						<div class="col-md-2">
	      							<img src="${review.book.imgPath }" class="img-fluid rounded-start" width="200" height="250">
	    						</div>
	    						<div class="col-md-10">
	      							<div class="card-body">
	        							<a href="/book/detailView.kh?bookNo=${review.bookNo }">
	        								<p class="card-title">
	        									<c:choose>
	                            					<c:when test="${fn:length(review.book.bookTitle) gt 20 }">
	                            						<c:out value="${fn:substring(review.book.bookTitle, 0, 19) }..."></c:out>
	                            					</c:when>
	                            					<c:otherwise>
	                            						<c:out value="책 제목 : ${review.book.bookTitle }	"></c:out>			
	                            					</c:otherwise>
	<%--                             			<p id="bookTitle" style="margin-bottom: 10%;">${cartList.book.bookTitle }</p> --%>
	                            				</c:choose>	
	        								</p>
	       									<p class="card-text">내가준평점 : ${review.score } / 5</p>
	       									<p class="card-text">후기 내용 : ${review.reviewContents }</p>
	       									<p class="card-text">등록일 : ${review.updateDate }</p>
	       								</a>
	      							</div>
	    						</div>
	  						</div>
						</div>
						<br>
						<br>
						<br>
					</c:forEach>	
					
				</c:if>
				<c:if test="${empty rList }">
					<div>
						등록한 후기가 없습니다.
					</div>
				</c:if>
			</div>
		</div>
		<div class="main-sidebar">side Bar</div>
	</div>
		
</body>
</html>