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
		.page-title {
			margin-left : 10%;
		}
		.tb-section {
			width : 75%;
			margin-left : 10%;
		}
		td > a {
			color : black;
			text-decoration : none;
		}
		a > button {
			background-color:#E4DDD3;
		}
		a > button:hover {
			background-color:#D8BB9C;
			color : white;
		}
		#btn-b {
			background-color:#D8BB9C;
			color : white;
		}
	</style>
</head>
<body>
	<div class="main-contents">
		<div class="main-sidebar">
			<jsp:include page="../main/mypageSideBar.jsp"></jsp:include>
		</div>
		<div class="main-section">
			<br>
			<div class="page-title">
				<h3>${principal.user.userName}님의 주문 내역</h3>
			</div>
			<br><br><br>
			<div class="tb-section">
				<table class="table table-hover align-middle" >
					<thead>
						<tr align="center" bgcolor="#E4DDD3">
							<th>상품정보</th>
							<th>구매일자</th>
							<th>주문번호</th>
							<th>결제금액</th>
							<th>주문상태</th>
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
												<c:if test="${order.orderState eq 'R'}">	
												환불 완료
												</c:if>
												<c:if test="${order.orderState eq 'Y'}">	
												구매 확정
												</c:if>
												<c:if test="${order.orderState eq 'N'}">	
												결제 완료
												</c:if>
											</a>
										</td>
									
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
			<br>
			<div align="center">
				<div>
					<c:if test="${currentPage != 1 }">
						<a href="/mypage/${urlVal }.kh?page=${currentPage - 1 }">
							<button class="btn">이전</button>
						</a>
					</c:if>
					<c:forEach var="p" begin="${startNavi }" end="${endNavi }">
						<c:if test="${currentPage eq p }">
							<button class="btn" id="btn-b">${p }</button>
						</c:if>
						<c:if test="${currentPage ne p }">
							<a href="/mypage/${urlVal }.kh?page=${p }">
								<button class="btn">${p }</button>
							</a>
						</c:if>
					</c:forEach>
					<c:if test="${maxPage > currentPage }">
						<a href="/mypage/${urlVal }.kh?page=${currentPage + 1 }">
							<button class="btn">다음</button>
						</a>
					</c:if>
				</div>
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