<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 문의글</title>
<!-- 타이틀 밑에 아래 css링크 추가해줄것 -->
<link rel="stylesheet" href="/resources/css/main/mainHeader.css">
<link rel="stylesheet" href="/resources/css/que/faqList.css">
<script src="/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>
    <div class="main-contents">
		<div class="main-sidebar">여기는 사이드바
		
		</div>
		<div class="main-section">
			<div class="faq-div">
				<h2>1:1문의글</h2>
				<table align="center" border="1" width="500">
					<tr>
						<th>유형</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록일</th>
					</tr>
					<tr>
						<td>
							<c:if test="${que.qCategory eq 'user'}">회원정보</c:if>
							<c:if test="${que.qCategory eq 'order'}">주문정보</c:if>
							<c:if test="${que.qCategory eq 'item'}">상품관련</c:if>
							<c:if test="${que.qCategory eq 'delivery'}">배송관련</c:if>
							<c:if test="${que.qCategory eq 'etc'}">기타문의</c:if>
						</td>
						<td>${que.queTitle }</td>
						<td>${que.queWriter }</td>
						<td>${que.qEnrollDate }</td>
					</tr>
					<tr>
						<td colspan="4" align="left">${que.queContents }</td>
					</tr>
					<c:if test="${!empty que.qAnswer }">
						<tr>
							<td colspan="4">
								<h2>답변</h2>
							</td>
						</tr>
						<tr>
							<td colspan="4" align="left">${que.qAnswer }</td>
						</tr>
					</c:if>
					<c:if test="${principal.user.userRole eq 'ROLE_ADMIN' }">
						<c:if test="${que.qStatus ne 'F' }">
							<tr>
								<td colspan="4" align="center">
									<a href="/que/answerView.kh?queNo=${que.queNo }&page=${page}">답변등록</a>
								</td>
							</tr>
						</c:if>
					</c:if>
					<tr>
						<td colspan="4" align="right">
							<button onclick="location.href = '/que/myList.kh'">리스트</button>
						</td>
					</tr>
				</table>
			</div>
		
		
		</div>
		<div class="main-sidebar">여기는 사이드바</div>
    </div>
	<footer>
		
	</footer>
</body>
</html>