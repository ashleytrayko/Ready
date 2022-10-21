<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${!empty bList }">
		<c:forEach items="${bList }" var="book" varStatus="i">
			<div>
				<span>${book.bookNo }</span>
				<a href="/book/detailView.kh?bookNo=${book.bookNo }">${book.bookTitle }</a><br>
				<img src=${book.imgPath } width="50" height="100"><br>
				<span>${book.priceSales }</span><br>
				<span>${book.mileage }</span><br>
				<span>${book.publisher }</span><br>
			</div>
			<br>
			<br>
			<br>
		</c:forEach>		
	</c:if>
</body>
</html>