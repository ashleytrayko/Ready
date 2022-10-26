<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>책메이트 : 장바구니</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link href="../resources/css/cart_order/cart.css" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/main/mainHeader.css">
    <script src="../resources/js/jquery-3.6.1.min.js"></script>
    <script src="../resources/js/checkbox.js"></script>
</head>
<body>
      <jsp:include page="../main/header.jsp"></jsp:include>
        <div id="cart-title">
            <h1 id="cart-text">SHOPPING CART</h1>
            <img src="../resources/images/cart_order/c-step01.png" >
        </div>
    <br><br>
        <div class="cart-data-list">
          <table class="table table-hover">
		 	<c:if test="${!empty cartList }">
                <thead>
                    <tr>
                        <th colspan="6"><h5 id="cart-h5">장바구니 상품</h5></th>
                        <th class="product-delbtn"><button id="del-btn" class="btn btn-secondary">선택상품 삭제</button></th>
                    </tr>
                </thead>
                        <tbody class="cartbody">
                            <tr>
                                <td>
                                    <input class="form-check-input cbx_chkAll" type="checkbox" id="flexCheckDefault">
                                </td>
                                <td>상품정보</td>
                                <td>정가</td>
                                <td>할인가</td>
                                <td>수량</td>
                                <td>합계</td>
                                <td>예상 적립금</td>
                            </tr>
                        </tbody>
                <tbody class="cartbody">
                	<c:set var="priceSum" value="0"/>
                	<c:set var="productSum" value="0"/>
                    <c:forEach items="${cartList }" var="cartList" varStatus="i">
                    <tr>
                        <td>
                            <input class="form-check-input" type="checkbox" value="${cartList.cartNo }" id="flexCheckDefault" name="chBox" data-cartNo="${cartList.cartNo}">
                        </td>
                        <td>
                            <img class="product-img" src="${cartList.book.imgPath }">
                            <br>
                            <c:choose>
                            	<c:when test="${fn:length(cartList.book.bookTitle) gt 20 }">
                            	<c:out value="${fn:substring(cartList.book.bookTitle, 0, 19) }...">
                            	</c:out></c:when>
                            	<c:otherwise>
                            	<c:out value="${cartList.book.bookTitle }">
                            	</c:out></c:otherwise>
<%--                             <p id="bookTitle" style="margin-bottom: 10%;">${cartList.book.bookTitle }</p> --%>
                            </c:choose>
                        </td>
                        <td><fmt:formatNumber type="number" pattern="###,###,###" value="${cartList.productPrice}"/>원</td>
                        <td><fmt:formatNumber type="number" pattern="###,###,###" value="${cartList.productPrice * 0.99}"/>원</td>
                        <td>
                            <input class="form-control form-control-sm countControl" id="countControl" type="text" placeholder="수량"
                            aria-label=".form-control-sm example" value="${cartList.productCount }">
                            <button id="quantity-btn" class="btn btn-secondary quantity-btn" data-cartNo="${cartList.cartNo }">변경</button>
                        </td>
                        <td><fmt:formatNumber type="number" pattern="###,###,###" value="${(cartList.productPrice * cartList.productCount) * 0.99}"/>원</td>
                        <td><fmt:formatNumber type="number" pattern="###,###,###" value="${cartList.book.mileage * cartList.productCount }"/>원</td>
                    </tr>
                    <c:set var="priceSum" value="${priceSum + (cartList.productPrice * cartList.productCount) }"/>
                    <c:set var="productSum" value="${productSum + cartList.productCount }"/>
                   </c:forEach>
                </tbody>
            </c:if>
            <c:if test="${empty cartList }">
               <tr>
                  <td>장바구니에 상품이 없습니다.</td>
               </tr>
            </c:if>
            </table>
        </div>
        <div class="cart-data-list">
            <table id="order-Info"> 
                <thead>
                    <tr id="">
                        <th id="cartinfo-table-left">주문 수량</th>
                        <th class="cartinfo-table-header">주문 금액 합계</th>
                        <th class="cartinfo-table-header">배송비</th>
                        <th class="cartinfo-table-header"><p class="total-price">총 금액 합계</p></th>
                        <th id="cartinfo-table-right">예상 적립금</th>
                    </tr>
                </thead>
                <tbody>
                    <td>총 <c:out value="${productSum }"/>권</td>
                    <td class="cartinfo-table-body"><fmt:formatNumber type="number" pattern="###,###,###" value="${priceSum }"/>원</td>
                    <td class="cartinfo-table-body">0원</td>
                    <td class="cartinfo-table-body"><p class="total-price"><fmt:formatNumber type="number" pattern="###,###,###" value="${priceSum * 0.99}"/>원</p></td>
                    <td><fmt:formatNumber type="number" pattern="###,###,###" value="${priceSum * 0.05}"/>원</td>
                </tbody>
            </table>
        </div>
        <div id="cart-btn1">
            <button class="btn btn-secondary">쇼핑 계속하기</button>
            <button class="btn btn-primary" onclick="location.href='/order/orderView.ready';">상품 주문하기</button>
        </div>
    <footer>
		
	</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<script>

	$("#del-btn").click(function(){
		var confirm_val = confirm("정말 삭제하시겠습니까?");
		  
		if(confirm_val) {

	    	var checkArr = [];
	   
	    	$("input[name='chBox']:checked").each(function(i){
	    	    checkArr.push($(this).attr("data-cartNo"));
	 		});

		  	$.ajax({
			  	url : "/cart/delete.ready",
			    type : "post",
			    data : { 
			    	checkArr : checkArr
			    },
			    success : function(){
			    	location.href = "/cart/cartView.ready";
			    },
			    error : function(){
			    	console.log('error');
			    }
		  	});
	   } 
	});
	
	$(".quantity-btn").click(function(){
		
		var cartNo = $(this).attr("data-cartNo");
		var productCount = $(this).prev().val();
		
		console.log(cartNo);
		console.log(productCount);
		
		$.ajax({
			url : "/cart/modifyCount.ready",
			type : "post",
			data : {
	            cartNo : cartNo,
	            productCount : productCount
			},
			success : function(){
				location.href = "/cart/cartView.ready";
			},
			error : function(){
		    	console.log('error');
		    }
		});
	});
	
</script>
</body>
</html>