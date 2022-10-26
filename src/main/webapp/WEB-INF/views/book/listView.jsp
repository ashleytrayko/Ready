<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<div class="col-md-3">여기는 사이드바</div>
		<div class="main-section">
			<c:if test="${!empty bList }">
				<c:forEach items="${bList }" var="book" varStatus="i">
					<div>
						<img src=${book.imgPath } width="200" height="250"><br>
						<a href="/book/detailView.kh?bookNo=${book.bookNo }">${book.bookTitle }</a><br>
						<span>${book.priceSales }</span><br>
						<span>${book.mileage }</span><br>
						<span>${book.publisher }</span><br>
					</div>
					<br>
					<br>
					<br>
				</c:forEach>		
			</c:if>
			<table>
			        <tr align="center" height="20">
			            <td colspan="6">
			                <c:if test="${currentPage != 1}">
			                    <a href="/book/${urlVal }.kh?page=${currentPage - 1 }">[이전]</a>
			                </c:if>
			                <c:forEach var="p" begin = "${startNavi }" end="${endNavi }">
			                    <c:if test="${currentPage eq p }">
			                        <b>${p}</b> 
			                    </c:if>
			                    <c:if test="${currentPage ne p }">
			                        <a href = "/book/${urlVal }.kh?page=${p }&searchCondition=${searchCondition }&searchValue=${searchValue }">${p}</a>
			                    </c:if>
			                </c:forEach>
			            	<c:if test = "${currentPage < maxPage }">
			                	<a href = "/book/${urlVal}.kh?page=${currentPage + 1}">[다음]</a>
			            	</c:if>
			            </td>
		        	</tr>
			</table>
		</div>
	</div>
</body>
</html>