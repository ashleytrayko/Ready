<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<style>
		table {
		width : 70%;
		top padding : 100px;
		margin : 0;
		}
	</style>
	<jsp:include page="../main/header.jsp"></jsp:include>
	<link rel="stylesheet" href="/resources/css/main/mainHeader.css">
</head>

<body>
	<div class="main-contents">
		<div class="col-md-3">
      		<jsp:include page="../main/mypageSideBar.jsp"></jsp:include>
		</div>
		<div class="main-section">
		<br><br>
			<h3>${principal.username}님의 마이페이지</h3><br><br>
			<div>
				<div>현재 회원님의 등급은 '${principal.user.userTier }' 입니다.</div>
				<br><br>
				<div>총 결제 금액</div>
			</div>
			<table class="table table-hover">
				<tr>
					<th>등급</th>
					<th>조건</th>
					<th>혜택</th>
				<tr>
				<tr>
					<td>브론즈</td>
					<td>가입시 자동등급</td>
					<td>구매시 3% 할인</td>
				</tr>
				<tr>
					<td>실버</td>
					<td>총 200,000원 구매시 승급</td>
					<td>구매시 5% 할인</td>
				</tr>
				<tr>
					<td>골드</td>
					<td>총 500,000원 구매시 승급</td>
					<td>구매시 7% 할인</td>
				</tr>
				<tr>
					<td>VIP</td>
					<td>총 1,000,000원 구매시 승급</td>
					<td>구매시 10% 할인</td>
				</tr>
			</table>
		</div>
		
		<div class="col-md=3">sideBar
		</div>
	</div>
</body>
</html>