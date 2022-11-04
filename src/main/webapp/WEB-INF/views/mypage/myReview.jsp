<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<jsp:include page="../main/header.jsp"></jsp:include>
	<link rel="stylesheet" href="/resources/css/main/mainHeader.css">
</head>
<body>
	<div class="main-contents">
		<div class="main-sidebar">
			<jsp:include page="../main/mypageSideBar.jsp"></jsp:include>
		</div>
		
		 <div class="main-section">
			<c:if test="${!empty rList }">
				<c:forEach items="${rList }" var="review" varStatus="i">
					<div class="card mb-3" style="width: 700px;">
  						<div class="row g-0">
    						<div class="col-md-2">
      							<img src="${review.book.imgPath }" class="img-fluid rounded-start" width="100" height="200">
    						</div>
    						<div class="col-md-10">
      							<div class="card-body">
        							<p class="card-title"><a href="/book/detailView.kh?bookNo=${review.bookNo }">책 제목 : ${review.book.bookTitle }</a></p>
       								<p class="card-text">내가준평점 : ${review.score } / 5</p>
       								<p class="card-text">후기 내용 : ${review.reviewContents }</p>
       								<p class="card-text">등록일 : ${review.updateDate }</p>
      							</div>
    						</div>
  						</div>
					</div>
					<br>
					<br>
					<br>
				</c:forEach>		
			</c:if>
		</div>
		<div class="main-sidebar">side Bar</div>
	</div>
		
</body>
</html>