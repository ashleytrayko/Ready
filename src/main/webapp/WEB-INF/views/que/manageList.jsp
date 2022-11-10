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
<title>문의글 확인 페이지-관리자</title>
<!-- 타이틀 밑에 아래 css링크 추가해줄것 -->
<link rel="stylesheet" href="/resources/css/main/mainHeader.css">
<link rel="stylesheet" href="/resources/css/que/faqList.css">
</head>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>
    <div class="main-contents">
		<div class="main-sidebar">여기는 사이드바
		</div>
		<div class="main-section">
		<div class="faq-div">
				<h1>문의글 관리 페이지</h1>
				<table align="center" border="1" width="700">
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
					<tr class="faq-header">
						<th>유형</th>
						<th colspan="4" align="left">제목</th>
						<th>등록일</th>
						<th>작성자</th>
						<th>답변여부</th>
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
								<td colspan="4" align="left"><a href="#" onclick="location.href='/que/myQue.kh?queNo=${question.queNo}&page=${currentPage}'">${question.queTitle }</a></td>
								<td>${question.qEnrollDate }</td>
								<td>${question.queWriter }</td>
								<td>
									<c:if test="${question.qStatus eq 'N' }">답변대기</c:if>
									<c:if test="${question.qStatus eq 'Y' }">답변완료</c:if>
								</td>
							</tr>
						</c:forEach>
						<tr align="center" height="20">
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
						</tr>
					</c:if>
					<tr>
						<td colspan="8" align="center">
							<form action="/question/search.kh" method="get">
								<select name="searchCondition">
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
								<button onclick="location.href='/que/faq01.kh'">FAQ 리스트</button>
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