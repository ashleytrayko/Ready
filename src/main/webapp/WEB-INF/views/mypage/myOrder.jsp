<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<style>
	
	.listOne{
		border-bottom : 1px solid #dcdcdc;
	}
	</style>
</head>
<body>
	<div class="main-contents">
		<div class="main-sidebar">
			<jsp:include page="../main/mypageSideBar.jsp"></jsp:include>
		</div>
		<div class="main-section">
			<c:if test="${empty oList}">
				주문한 내역이 없습니다.
			</c:if>
			<c:if test="${!empty oList}">
				<c:forEach items="${oList }" var="order" varStatus="i">
					<%-- <c:forEach items="${oList }" var="order" varStatus="j">
						<c:if test="${j.orderId = j+1.orderId }">
						
						</c:if>
					</c:forEach >--%>
					<div class="listOne">
					<a href="/order/orderDetailView?orderId=${order.orderId }">
						<div>주문 번호 : ${order.orderId }</div>
						<div>
							<img src=${order.book.imgPath } width="150" height="100">
						</div>
						<div>
							결제 가격 : <fmt:formatNumber type="number" value="${order.productPrice }" pattern="#,###"/>원
						</div>
						<div>
							구매 일자 : ${order.orderDate }
						</div>
						<div>
							구매 상태 : ${order.orderState }
						</div>
					</a>
					</div>
				</c:forEach>
			</c:if>
		</div>
		<div class="main-sidebar">
		</div>
	</div>
</body>
</html>