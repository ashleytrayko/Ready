<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
			<table align="center" border="1">
					<tr>
						<th>번호</th>
						<th colspan="2">제목</th>
						<th>날짜</th>
						<th>조회수</th>
						<th>추천수</th>
					</tr>
					<c:if test="${!empty cList }">
						<c:forEach items="${cList }" var="comm" varStatus="i">
							<tr>
								<td><%-- ${comm.boardNo } --%>${fn:length(cList) - i.index}<!--${i.count } 얘는 게시글 ASC로 출력--></td>
								<td colspan="2"><a href="#" onclick="location.href='/comm/detail.kh?boardNo=${comm.boardNo }&page=${currentPage }'" >${comm.commTitle  }</a></td>
								<!--  -->
								<td>${comm.cCreateDate }</td>
								<td>${comm.cCount }</td>
								<td>${comm.cLike }</td>
							</tr>
						</c:forEach>
						<tr align="center" height="20">
						<td colspan="7">
							<c:if test="${currentPage != 1 }">
								<a href="/comm/${urlVal }.kh?page=${currentPage - 1 }">[이전]</a>
							</c:if>
							<c:forEach var="p" begin="${startNavi }" end="${endNavi }">
								<c:if test="${currentPage eq p }">
									<b>${p }</b>
								</c:if>
								<c:if test="${currentPage ne p }">
									<a href="/comm/${urlVal }.kh?page=${p }">${p }</a>
								</c:if>
							</c:forEach>
							<c:if test="${maxPage > currentPage }">
								<a href="/comm/${urlVal }.kh?page=${currentPage + 1 }">[다음]</a>
							</c:if>
						</td>
					</tr>
					</c:if>
					<c:if test="${empty cList }">
						<tr>
							<td colspan="7" align="center"><b>데이터가 존재하지 않습니다.</b></td>
						</tr>
					</c:if>
				</table>
		</div>
		<div>
		</div>
	</div>
</body>
</html>