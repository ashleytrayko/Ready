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
    <title>책메이트 : 주문 완료</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href="../resources/css/cart_order/order.css" rel="stylesheet">
    <script src="../resources/js/jquery-3.6.1.min.js"></script>
</head>
<style>
</style>
<body>
    <body>
        <div id="order-title">
            <h1 id="order-text">ORDER COMPLETE</h1>
            <img src="../resources/images/cart_order/c-step03.png" >
        </div>
    <br><br>
        <div class="buyer-data-list">
            <table class="buyer-info buyer-info-title">
                <tr>
                    <th colspan="6">
                        <h5>주문 정보</h5>
                    </th>
                </tr>
            </table>
            <hr>
            <table class="buyer-info-table">
                <tr class="buyer-info-tr">
                     <td class="buyer-info-td">
                        <p class="order-info-p">주문번호</p>
                    </td>
                    <td>
                        <p class="order-info-p">${orderInfo.orderId }</p>
                    </td>
                </tr>
                <tr>
                    <td class="addr-info-td">
                        <p class="order-info-p">수취인</p>
                    </td>
                    <td>
                        <p class="order-info-p">${orderInfo.orderRName }</p>
                    </td>
                </tr>
                <tr>
                    <td class="addr-info-td">
                        <p class="order-info-p">연락처</p>
                    </td>
                    <td>
                        <p class="order-info-p">${orderInfo.orderRPhone }</p>
                    </td>
                </tr>
                <tr>
                    <td class="addr-info-td">
                    	<p class="order-info-p">배송지 정보</p>
                    </td>
                    <td>
                        <p class="order-info-addr-p">${orderInfo.orderAddress1 }  ${orderInfo.orderAddress2 }  ${orderInfo.orderAddress3 }</p>
                    </td>
                </tr>
                <tr>
                    <td class="addr-info-td">
                        <p class="order-info-p">결제 방법</p>
                    </td>
                    <td>
                        <p class="order-info-p"><input type="text" id="payMethod" value="${orderInfo.paymentMethod }" readonly style="border : 0px; text-align:left;"></p>
                        
                    </td>
                </tr>
            </table>
        </div>

        <div class="accordion accordion-flush order-data-list" id="accordionFlushExample">
            <div class="accordion-item">
              <h2 class="accordion-header" id="flush-headingOne">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
                  <h5>상품 정보</h5>
                </button>
                <hr>
              </h2>
              <div id="flush-collapseOne" class="accordion-collapse collapse" aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
                <div class="accordion-body">
                      <table class="table table-hover">
                            <thead>
                                <tr class="acd-tr">
                                    <td colspan="2">상품 정보</td>
                                    <td>정가</td>
                                    <td>할인가</td>
                                    <td>수량</td>
                                    <td>합계</td>
                                    <td>적립금</td>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${orderList }" var="orderList" varStatus="i">
                              <tr class="acd-tr">
                              	  <!-- 이미지 -->
                                  <td>
                                      <img class="product-img" src="${orderList.book.imgPath }">
                                  </td>
                                  <!-- 제목 -->
                                  <td>
                                      <c:choose>
                            		  	<c:when test="${fn:length(orderList.book.bookTitle) gt 20 }">
                            				<c:out value="${fn:substring(orderList.book.bookTitle, 0, 19) }..."/>
                            			</c:when>
                            			<c:otherwise>
                            				<c:out value="${orderList.book.bookTitle }"/>
										</c:otherwise>
<%--                             		<p id="bookTitle" style="margin-bottom: 10%;">${orderList.book.bookTitle }</p> --%>
                            		  </c:choose>
                                  </td>
                                  <!-- 정가 -->
                                  <td><fmt:formatNumber type="number" pattern="###,###,###" value="${orderList.book.priceSales}"/>원</td>
                                  <!-- 할인가 -->
                                  <td><fmt:formatNumber type="number" pattern="###,###,###" value="${orderList.productPrice}"/>원</td>
                                  <!-- 수량 -->
                                  <td>${orderList.productCount }</td>
                                  <!-- 할인가*수량 -->
                                  <td><fmt:formatNumber type="number" pattern="###,###,###" value="${orderList.productPrice * orderList.productCount}"/>원</td>
                                  <!-- 적립금*수량 -->
                        		  <td><fmt:formatNumber type="number" pattern="###,###,###" value="${orderList.book.mileage * orderList.productCount }"/>원</td>
                              </tr>
                            <c:set var="priceSum" value="${priceSum + (orderList.book.priceSales * orderList.productCount) }"/>
                    		<c:set var="productSum" value="${productSum + orderList.productCount }"/>
                    		<c:set var="salePriceSum" value="${salePriceSum + (orderList.productPrice * orderList.productCount) }"/>
                            <c:set var="mileageSum" value="${mileageSum + (orderList.book.mileage * orderList.productCount) }"/>
                          </c:forEach>
                          </tbody>
                      </table>
                  </div>
                </div>
              </div>
            </div>

        <div class="order-data-list">
            <table id="order-Info"> 
                <thead>
                    <tr id="">
                        <th id="orderinfo-table-left">주문 수량</th>
                        <th class="orderinfo-table-header">주문 금액 합계</th>
                        <th class="orderinfo-table-header">배송비</th>
                        <th class="orderinfo-table-header"><p class="total-price">총 금액 합계</p></th>
                        <th id="orderinfo-table-right">적립금</th>
                    </tr>
                </thead>
                <tbody>
                    <td>총 <c:out value="${productSum }"/>권</td>
                    <td class="orderinfo-table-body">
                    	<fmt:formatNumber type="number" pattern="###,###,###" value="${priceSum }"/>원
                    </td>
                    <td class="orderinfo-table-body">
                    	0원
                    </td>
                    <td class="orderinfo-table-body">
                    	<p class="total-price">
                    		<fmt:formatNumber type="number" pattern="###,###,###" value="${salePriceSum}"/>원
                    	</p>
                    </td>
                    <td>
                    	<fmt:formatNumber type="number" pattern="###,###,###" value="${mileageSum}"/>원
                    </td>
                </tbody>
            </table>
        </div>
        <div id="order-btn">
            <button class="btn btn-secondary btm-btn">메인으로</button>
            <button class="btn btn-primary btm-btn" onclick="history.go(-3);">계속 쇼핑하기</button>
        </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<script>

	var paymethod = $("#payMethod").val();
	
	if(paymethod == "card"){
		$("#payMethod").val("신용카드");
	} else if(paymethod == "kakaopay"){
		$("#payMethod").val("카카오 페이");
	} else if(paymethod == "trans"){
		$("#payMethod").val("실시간 계좌 이체");
	}

</script>
</body>
</html>