<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png"  href="/resources/images/favicon.ico"/>
<meta charset="UTF-8">
<title>공지사항</title>
<!-- 타이틀 밑에 아래 css링크 추가해줄것 -->
<link rel="stylesheet" href="/resources/css/main/mainHeader.css">
<link rel="stylesheet" href="/resources/css/admin/admin.css">
<link rel="stylesheet" href="../resources/css/admin/button.css"/>
<style>
      a > button {
         background-color:#AA7139;
         color : white;
      }
      a > button:hover {
         background-color:#804A15;
         color : white;
      }
</style>
</head>
<body>
	<jsp:include page="../../admin/adminHeader.jsp"></jsp:include>
	<div class="main-contents">
		<div class="main-sidebar">
						<jsp:include page="../../admin/adminSideBar.jsp"></jsp:include>
		</div>
		<div class="main-section">
			<!-- 이 안에서 작업! 여기가 본문-->
			<div class="container col-lg-8">
			<h1>공지사항 관리</h1>
			<table class="table table-hover text-center">
				<thead>
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록시간</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${noticeList }" var="noticeList" varStatus="i">
					<tr>
						<td>${noticeList.noticeNumber }</td>
						<td><a href="/admin/noticeDetail?noticeNumber=${noticeList.noticeNumber }">${noticeList.noticeTitle }</a></td>
						<td>${noticeList.noticeWriter }</td>
						<td><fmt:formatDate value="${noticeList.postDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					</tr>
					</c:forEach>
						<tr align="center" height="20">
			            <td colspan="6">
			                <c:if test="${currentPage != 1}">
			                    <a href="/admin/${urlVal }?page=${currentPage - 1 }">
			                    	<button class="btn btn-outline-dark">이전</button>
			                    </a>
			                </c:if>
			                <c:if test="${currentPage == 1}">
			                    	<button class="btn btn-outline-dark disabled">이전</button>
			                </c:if>
			                <c:forEach var="p" begin = "${startNavi }" end="${endNavi }">
			                    <c:if test="${currentPage eq p }">
			                        <button class="btn btn-dark">${p}</button> 
			                    </c:if>
			                    <c:if test="${currentPage ne p }">
			                        <a href = "/admin/${urlVal }?page=${p }&searchCondition=${searchCondition }&searchValue=${searchValue }">
			                        <button class="btn btn-outline-dark">${p}</button>
			                        </a>
			                    </c:if>
			                </c:forEach>
			            	<c:if test = "${currentPage < maxPage }">
			                	<a href = "/admin/${urlVal}?page=${currentPage + 1}">
			                	<button class="btn btn-outline-dark">
			                		다음
			                	</button>
			                	</a>
			            	</c:if>
			            	<c:if test = "${currentPage == maxPage }">
			                	<button class="btn btn-outline-dark disabled">
			                		다음
			                	</button>
			            	</c:if>
			            </td>
					</tr>
				</tbody>
			</table>
			
			<div class="btn-section2" style="text-align:center">
				<button class="btn" onclick="writeNotice()" >공지사항 등록</button>
			</div>
		</div>
			<footer>
								<jsp:include page="../../../views/main/footer.jsp"></jsp:include>
			</footer>
		</div>
	<script>

	function writeNotice(){
		location.href="/admin/admin-noticeForm";
	}
	</script>
</body>
</html>