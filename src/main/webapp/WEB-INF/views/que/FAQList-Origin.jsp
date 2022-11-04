<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>게시글 목록</title>
<!-- 타이틀 밑에 아래 css링크 추가해줄것 -->
<link rel="stylesheet" href="/resources/css/main/mainHeader.css">
<link rel="stylesheet" href="/resources/css/que/faqList.css">
</head>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>
    <div class="main-contents">
		<div class="main-sidebar">여기는 사이드바</div>
		<div class="main-section">
		<!-- 이 안에서 작업! 여기가 본문-->
			<div class="faq-div">
				<h1>고객센터 FAQ</h1>
				<table align="center" border="1" width="700">
				<!-- th의 width를 colspan으로 동일하게 먹이고 싶었는데 먹질 않아서
				colgroup으로 스타일을 주었더니 원하는대로 작동 -->
				<colgroup>
				    <col width="12%"/>
				    <col width="13%"/>
				    <col width="12%"/>
				    <col width="13%"/>
				    <col width="12%"/>
				    <col width="13%"/>
				    <col width="12%"/>
				    <col width="13%"/>
				</colgroup>
					<tr>
						<th class="faq-category" colspan="2">회원정보</th>
						<th class="faq-category" colspan="2">배송관련</th>
						<th class="faq-category" colspan="2">상품관련</th>
						<th class="faq-category" colspan="2">교환/환불</th>
					</tr>
					<tr class="faq-header">
						<td>유형</td>
						<td colspan="7" align="left">제목</td>
					</tr>
					<c:if test="${!empty qList }">
						<c:forEach items="${qList }" var="question" varStatus="i">
							<tr>
								<td>
									<c:if test="${question.qCategory eq 'user'}">회원정보</c:if>
									<c:if test="${question.qCategory eq 'order'}">주문정보</c:if>
									<c:if test="${question.qCategory eq 'item'}">상품관련</c:if>
									<c:if test="${question.qCategory eq 'delivery'}">배송관련</c:if>
									<c:if test="${question.qCategory eq 'etc'}">기타문의</c:if>
								</td>
								<td colspan="7" align="left">${question.queTitle }</td>
							</tr>
						</c:forEach>
						<%-- <tr align="center" height="20">
						<td colspan="8">
							<c:if test="${currentPage != 1 }">
								<a href="/que/${urlVal }.kh?page=${currentPage - 1 }&searchCondition=${searchCondition}&searchValue=${searchValue}">[이전]</a>
							</c:if>
							<c:forEach var="p" begin="${startNavi }" end="${endNavi }">
								<c:if test="${currentPage eq p }">
									<b>${p }</b>
								</c:if>
								<c:if test="${currentPage ne p }">
									<a href="/que/${urlVal }.kh?page=${p }&searchCondition=${searchCondition}&searchValue=${searchValue}">${p }</a>
								</c:if>
							</c:forEach>
							<c:if test="${maxPage > currentPage }">
								<a href="/que/${urlVal }.kh?page=${currentPage + 1 }&searchCondition=${searchCondition}&searchValue=${searchValue}">[다음]</a>
							</c:if>
						</td>
					</tr>
					</c:if>
					<c:if test="${empty qList }">
						<tr>
							<td colspan="8" align="center"><b>데이터가 존재하지 않습니다.</b></td>
						</tr> --%>
					</c:if>
					<tr>
						<td colspan="8" align="center">
							<form action="/question/search.kh" method="get">
								<select name="searchCondition">
									<option value="all" <c:if test="${searchCondition eq 'all' }">selected</c:if>>전체</option>
									<option value="title" <c:if test="${searchCondition eq 'title' }">selected</c:if>>제목</option>
									<option value="contents" <c:if test="${searchCondition eq 'contents' }">selected</c:if>>내용</option>
								</select>
								<input type="text" name="searchValue" value="${searchValue }">
								<input type="submit" value="검색">
							</form>
						</td>
					</tr>
					<tr>
						<td colspan="8" align="right">
								<button onclick="location.href='/que/myList.kh'">내 문의글</button>
								<button onclick="location.href='/que/viewWrite.kh'">글쓰기</button>
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