<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공용jsp틀</title>
<!-- 타이틀 밑에 아래 css링크 추가해줄것 -->
<link rel="stylesheet" href="/resources/css/main/mainHeader.css">
</head>
<body>
	<jsp:include page="../../admin/adminHeader.jsp"></jsp:include>
	<div class="main-contents">
		<div class="main-sidebar">
						<jsp:include page="../../admin/adminSideBar.jsp"></jsp:include>
		</div>
		<div class="main-section">
			<!-- 이 안에서 작업! 여기가 본문-->
			<h1>신고 관리</h1>
			<table border="1" align="center">
				<thead>
					<tr>
						<th></th>
						<th>글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록시간</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${reportList }" var="reportList" varStatus="i">
					<tr>
						<td><input type="checkbox"></td>
						<td>${reportList.boardNo}</td>
						<td><a href="/admin/reportDetail?boardNo=${reportList.boardNo}">${reportList.commTitle }</a></td>
						<td>${reportList.commWriter }</td>
						<td>${reportList.cUpdateDate }</td>
					</tr>
					</c:forEach>
					<tr align="center" height="20">
						<td colspan="7">
							<c:if test="${currentPage != 1 }">
								<a href="/admin/${urlVal }?page=${currentPage - 1 }&searchCondition=${searchCondition}&searchValue=${searchValue}">[이전]</a>
							</c:if>
							<c:forEach var="p" begin="${startNavi }" end="${endNavi }">
								<c:if test="${currentPage eq p }">
									<b>${p }</b>
								</c:if>
								<c:if test="${currentPage ne p }">
									<a href="/admin/${urlVal }?page=${p }&searchCondition=${searchCondition}&searchValue=${searchValue}">${p }</a>
								</c:if>
							</c:forEach>
							<c:if test="${maxPage > currentPage }">
								<a href="/admin/${urlVal }?page=${currentPage + 1 }&searchCondition=${searchCondition}&searchValue=${searchValue}">[다음]</a>
							</c:if>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="main-sidebar">여기는 사이드바</div>
	</div>
	<footer> </footer>
	<script>
	</script>
</body>
</html>