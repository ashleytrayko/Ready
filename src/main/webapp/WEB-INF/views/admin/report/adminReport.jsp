<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png"  href="/resources/images/favicon.ico"/>
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
			<div class="container col-lg-8">
			<!-- 이 안에서 작업! 여기가 본문-->
			<h1>신고 관리</h1>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록시간</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${reportList }" var="reportList" varStatus="i">
					<tr>
						<td>${reportList.boardNo}</td>
						<td><a href="/admin/reportDetail?boardNo=${reportList.boardNo}">${reportList.commTitle }</a></td>
						<td>${reportList.commWriter }</td>
						<td>${reportList.cUpdateDate }</td>
					</tr>
					</c:forEach>
					<tr align="center" height="20">
						<td colspan="7">
							<c:if test="${currentPage != 1 }">
								<a href="/admin/${urlVal }?page=${currentPage - 1 }&searchCondition=${searchCondition}&searchValue=${searchValue}">
									<button class="btn btn-outline-dark">이전</button>
								</a>
							</c:if>
							<c:if test="${currentPage == 1 }">
									<button class="btn btn-outline-dark disabled">이전</button>
							</c:if>
							<c:forEach var="p" begin="${startNavi }" end="${endNavi }">
								<c:if test="${currentPage eq p }">
									<button class="btn btn-dark">${p}</button>
								</c:if>
								<c:if test="${currentPage ne p }">
									<a href="/admin/${urlVal }?page=${p }&searchCondition=${searchCondition}&searchValue=${searchValue}">
									<button class="btn btn-outline-dark">${p}</button>
									</a>
								</c:if>
							</c:forEach>
							<c:if test="${maxPage > currentPage }">
								<a href="/admin/${urlVal }?page=${currentPage + 1 }&searchCondition=${searchCondition}&searchValue=${searchValue}">
								<button class="btn btn-outline-dark">
			                		다음
			                	</button>
								</a>
							</c:if>
							<c:if test="${maxPage == currentPage }">
								<button class="btn btn-outline-dark disabled">
			                		다음
			                	</button>
							</c:if>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		</div>
	</div>
	<footer> </footer>
	<script>
	</script>
</body>
</html>