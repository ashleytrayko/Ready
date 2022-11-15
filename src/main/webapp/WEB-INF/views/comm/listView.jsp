<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/png"  href="/resources/images/favicon.ico"/>
<title>리디 커뮤니티</title>
<!-- 타이틀 밑에 아래 css링크 추가해줄것 -->
<link rel="stylesheet" href="/resources/css/main/mainHeader.css">
<link rel="stylesheet" href="/resources/css/comm/listView.css">
<link rel="stylesheet" href="/resources/css/comm/commForm.css">
</head>
<body>
	<jsp:include page="../main/commHeader.jsp"></jsp:include>
    <div class="main-contents">
		<div class="main-sidebar"></div>
		<div class="main-section">
		<!-- 이 안에서 작업! 여기가 본문-->
			<div class="list-div">
				<h1 class="list-title">리디 커뮤니티</h1>
				<table border="1" class="list-table center">
					<tr class="list-nav" height="50px">
						<th width="10%">번호</th>
						<th colspan="2" width="40%">제목</th>
						<th class="th-left" width="15%">작성자</th>
						<th width="15%">작성일</th>
						<th width="10%">조회수</th>
						<th width="10%">추천수</th>
					</tr>
					
					<c:if test="${!empty cList }">
						<c:forEach items="${cList }" var="comm" varStatus="i">
							<tr class="tr-line">
								<td><%-- ${comm.boardNo } --%>${totalCount - ((currentPage-1) * 10 +i.index)}<!--${i.count } 얘는 게시글 ASC로 출력--></td>
								<td colspan="2" class="th-left"><a class="td-title" href="#" onclick="location.href='/comm/detail.kh?boardNo=${comm.boardNo }&page=${currentPage }'" >${comm.commTitle  }</a></td>
								<!--  -->
								<td class="th-left">${comm.commWriter }</td>
 	<%-- 							<td>${comm.cCreateDate }</td> --%>
 								<td>
								<fmt:formatDate value="${comm.cCreateDate}" pattern="YY/MM/dd" />
								<c:set var="now" value="<%=new java.util.Date()%>" />
								</td>
								<td>${comm.cCount }</td>
								<td>${comm.cLike }</td>
							</tr>
						</c:forEach>
						<tr class="center" height="20">
						<td colspan="7" class="paging-td">
							<c:if test="${currentPage != 1 }">
								<a class="a-button" href="/comm/${urlVal }.kh?page=${currentPage - 1 }&searchCondition=${searchCondition}&searchValue=${searchValue}">
									[이전]
								</a>
							</c:if>
							<c:forEach var="p" begin="${startNavi }" end="${endNavi }">
								<c:if test="${currentPage eq p }">
									<b>${p }</b>
								</c:if>
								<c:if test="${currentPage ne p }">
									<a class="a-button" href="/comm/${urlVal }.kh?page=${p }&searchCondition=${searchCondition}&searchValue=${searchValue}">
										${p }
									</a>
								</c:if>
							</c:forEach>
							<c:if test="${maxPage > currentPage }">
								<a class="a-button" href="/comm/${urlVal }.kh?page=${currentPage + 1 }&searchCondition=${searchCondition}&searchValue=${searchValue}">
									[다음]
								</a>
							</c:if>
						</td>
					</tr>
					</c:if>
					<c:if test="${empty cList }">
						<tr>
							<td colspan="7" class="center"><b>데이터가 존재하지 않습니다.</b></td>
						</tr>
					</c:if>
					<tr>
						<td colspan="7" class="center">
							<form action="/comm/search.kh" method="get">
								<select name="searchCondition">
									<option value="all" <c:if test="${searchCondition eq 'all' }">selected</c:if>>전체</option>
									<option value="writer" <c:if test="${searchCondition eq 'writer' }">selected</c:if>>작성자</option>
									<option value="title" <c:if test="${searchCondition eq 'title' }">selected</c:if>>제목</option>
									<option value="contents" <c:if test="${searchCondition eq 'contents' }">selected</c:if>>내용</option>
								</select>
								<input type="text" name="searchValue" value="${searchValue }">
								<input class="rvs-sig-btn" type="submit" value="검색">
							</form>
						</td>
					</tr>
					<tr>
						<td colspan="7" align="right">
							<button class="sig-btn" onclick="location.href='/comm/viewWrite.kh'">글쓰기</button>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="main-sidebar"></div>
    </div>
	<footer>
	<div class="main-footer">
		<jsp:include page="../main/footer.jsp"></jsp:include>
	</div>
	</footer>
</body>
</html>

