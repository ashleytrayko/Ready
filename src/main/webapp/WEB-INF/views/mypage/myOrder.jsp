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
	
		.tb-section {
			width : 75%;
			margin-left : 10%;
		}
		td > a {
			color : black;
			text-decoration : none;
		}
	</style>
</head>
<body>
	<div class="main-contents">
		<div class="main-sidebar">
			<jsp:include page="../main/mypageSideBar.jsp"></jsp:include>
		</div>
		<div class="main-section">
			<div class="tb-section">
				<table class="table table-hover align-middle" >
					<thead>
						<tr align="center">
							<th class="table-info">상품정보</th>
							<th class="table-info">구매일자</th>
							<th class="table-info">주문번호</th>
							<th class="table-info">결제금액</th>
							<th class="table-info">주문상태</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${empty oList}">
							<h3>주문한 내역이 없습니다.</h3>
						</c:if>
						<c:if test="${!empty oList}">
							<c:forEach items="${oList }" var="order" varStatus="i">
								<tr align="center">
										<td>
											<a href="/order/orderDetailView?orderId=${order.orderId }">
												<img src="${order.book.imgPath }" width="150" height="200">
											</a>
										</td>
										<td>
											<a href="/order/orderDetailView?orderId=${order.orderId }">
												${order.orderDate }
											</a>
										</td>
										<td>
											<a href="/order/orderDetailView?orderId=${order.orderId }">
												${order.orderId }
											</a>
										</td>
										<td>
											<a href="/order/orderDetailView?orderId=${order.orderId }">
												<fmt:formatNumber type="number" value="${order.totalPrice }" pattern="#,###"/>원
											</a>
										</td>
										<td>
											<a href="/order/orderDetailView?orderId=${order.orderId }">
												${order.orderState }
											</a>
										</td>
									
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
		<div class="main-sidebar">
		</div>
	</div>
	<div class="main-footer">
		<jsp:include page="../main/footer.jsp"></jsp:include>
	</div>
</body>
</html>