<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>${book.bookTitle }</div>
	<div>
		<img src=${book.imgPath } width="100" height="150">
		<div>${book.bookWriter }</div>
		<div>${book.publisher }</div>
		<div>${book.priceSales }</div>
		<div>${book.mileage }</div>
	</div>
	<div>
		<a href="#">구매하기</a>
		<a href="#">장바구니</a>
	</div>
</body>
</html>