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
    <title>책메이트 : 주문하기</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/main/mainHeader.css">
    <link href="../resources/css/cart_order/order.css" rel="stylesheet">
    <script src="../resources/js/jquery-3.6.1.min.js"></script>
</head>
<style>
</style>
<body>
<jsp:include page="../main/header.jsp"></jsp:include>
     <div id="order-title">
         <h1 id="order-text">ORDER</h1>
         <img src="../resources/images/cart_order/c-step02.png" >
     </div>
    <br><br>
        <div class="order-data-list">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th colspan="7"><h5 style="font-weight : bold;">주문할 상품</h5></th>
                    </tr>
                </thead>
                        <tbody class="cartbody">
                            <tr>
                                <td colspan="2">상품정보</td>
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
                            <img class="product-img" src="${cartList.book.imgPath }">
                        </td>
                        <td>
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
                        <td>${cartList.productCount }</td>
                        <td><fmt:formatNumber type="number" pattern="###,###,###" value="${(cartList.productPrice * cartList.productCount) * 0.99}"/>원</td>
                        <td><fmt:formatNumber type="number" pattern="###,###,###" value="${cartList.book.mileage * cartList.productCount }"/>원</td>
                    </tr>
                    <c:set var="priceSum" value="${priceSum + (cartList.productPrice * cartList.productCount) }"/>
                    <c:set var="productSum" value="${productSum + cartList.productCount }"/>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="buyer-data-list">
            <table class="buyer-info buyer-info-title">
                <tr>
                    <th colspan="6">
                        <h5 style="font-weight : bold;">구매자 정보</h5>
                    </th>
                </tr>
            </table>
            <hr>
            <table class="buyer-info-table">
                <tr class="buyer-info-tr">
                    <td class="buyer-info-td">
                        <p>이름</p>
                    </td>
                    <td>
                        <input class="form-control form-control-sm name-phone" type="text" placeholder="일용자" value="${userInfoList.userName }" style="width:130px">
                    </td>
                </tr>
                <tr>
                    <td class="buyer-info-td">
                        <p>연락처</p>
                    </td>
                    <td>
                        <input class="form-control form-control-sm name-phone" type="text" placeholder="01000000000" value="${userInfoList.userPhone }" style="width:130px">
                    </td>
                </tr>
                <tr>
                    <td class="buyer-info-td">
                        <p>E-mail</p>
                    </td>
                    <td>
                        <input class="form-control form-control-sm Email" type="text" placeholder="khuser01@iei.or.kr" style="width:200px" value="${userInfoList.userEmail }">
                    </td>
                </tr>
                <tr>
                    <td class="addr-info-td">
                        <p style="vertical-align :middle; margin-top : 0px; margin-bottom : 0px;">주소</p>
                    </td>
                    <td class="addr-info-td" style="width : 400px;">
                    	<div class="div-floatLeft">
                        	<input class="form-control form-control-sm Addr1" id="zoneCode" type="text" value="${userInfoList.userPostcode }" placeholder="00000 (우편번호)" style="width:90px;">
                        </div>
                        <div class="div-floatLeft">
                        	<button class="btn btn-secondary searchAddr-btn" onclick="addrSearch();" style="font-size :12px;">우편번호 검색</button>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="addr-info-td">
                        <p></p>
                    </td>
                    <td colspan="2">
                        <input class="form-control form-control-sm detail-Addr" id="roadAddr" type="text" value="${userInfoList.userAddress }" placeholder="서울시 중구 남대문로 120 대일빌딩 (도로명 or 지번 주소)" style="width: 400px;">
                    </td>
                </tr>
                <tr>
                    <td class="addr-info-td">
                        <p></p>
                    </td>
                    <td colspan="2" class="addr-td">
                        <input class="form-control form-control-sm detail-Addr" id="detailAddr" type="text" value="${userInfoList.userDetailAddress }" placeholder="3F F강의실 (상세 주소)" style="width: 400px;">
                    </td>
                </tr>
            </table>
        </div>

        <div class="buyer-data-list">
           <table class="buyer-info buyer-info-title">
              <tr>
                 <th colspan="6">
                     <h5 style="font-weight : bold;">배송지 정보</h5>
                 </th>
              </tr>
           </table>
           <hr>
           <table class="buyer-info-table">
                <tr class="buyer-info-tr">
                    <td class="buyer-info-td">
                        <p>이름</p>
                    </td>
                    <td>
                    	<div class="div-floatLeft">
                        	<input class="form-control form-control-sm name-phone" type="text" placeholder="일용자" value="${userInfoList.userName }" style="width:130px">
                    	</div>
                    	<div class="div-floatLeft">
                        	<button class="btn btn-secondary" id="infocopy-btn">구매자정보 복사</button>
                    	</div>
                    </td>
                </tr>
                <tr>
                    <td class="buyer-info-td">
                        <p>연락처</p>
                    </td>
                    <td>
                        <input class="form-control form-control-sm name-phone" type="text" placeholder="01000000000" value="${userInfoList.userPhone }" style="width:130px">
                    </td>
                </tr>
                <tr>
                    <td class="buyer-info-td">
                        <p>E-mail</p>
                    </td>
                    <td>
                        <input class="form-control form-control-sm Email" type="text" placeholder="khuser01@iei.or.kr" style="width:200px" value="${userInfoList.userEmail }">
                    </td>
                </tr>
                <tr>
                    <td class="addr-info-td">
                        <p style="vertical-align :middle; margin-top : 0px; margin-bottom : 0px;">주소</p>
                    </td>
                    <td class="addr-info-td" style="width : 400px;">
                    	<div class="div-PostCode">
                        	<input class="form-control form-control-sm Addr1" id="zoneCode" type="text" value="${userInfoList.userPostcode }" placeholder="00000 (우편번호)" style="width:90px;">
                        </div>
                        <div class="div-PostCode">
                        	<button class="btn btn-secondary searchAddr-btn" onclick="addrSearch();" style="font-size :12px;">우편번호 검색</button>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="addr-info-td">
                        <p></p>
                    </td>
                    <td colspan="2">
                        <input class="form-control form-control-sm detail-Addr" id="roadAddr" type="text" value="${userInfoList.userAddress }" placeholder="서울시 중구 남대문로 120 대일빌딩 (도로명 or 지번 주소)" style="width: 400px;">
                    </td>
                </tr>
                <tr>
                    <td class="addr-info-td">
                        <p></p>
                    </td>
                    <td colspan="2" class="addr-td">
                        <input class="form-control form-control-sm detail-Addr" id="detailAddr" type="text" value="${userInfoList.userDetailAddress }" placeholder="3F F강의실 (상세 주소)" style="width: 400px;">
                    </td>
                </tr>
            </table>
        </div>

        <div class="order-data-list">
            <table id="order-Info"> 
                <thead>
                    <tr>
                        <th id="orderinfo-table-left">주문 수량</th>
                        <th class="orderinfo-table-header">주문 금액 합계</th>
                        <th class="orderinfo-table-header">배송비</th>
                        <th class="orderinfo-table-header"><p class="total-price">총 금액 합계</p></th>
                        <th id="orderinfo-table-right">예상 적립금</th>
                    </tr>
                </thead>
                <tbody>
                    <td>총 <c:out value="${productSum }"/>권</td>
                    <td class="cartinfo-table-body"><fmt:formatNumber type="number" pattern="###,###,###" value="${priceSum }"/>원</td>
                    <td class="orderinfo-table-body">0원</td>
					<td class="cartinfo-table-body"><p class="total-price"><fmt:formatNumber type="number" pattern="###,###,###" value="${priceSum * 0.99}"/>원</p></td>
					<td><fmt:formatNumber type="number" pattern="###,###,###" value="${priceSum * 0.05}"/>원</td>
                </tbody>
            </table>
        </div>
        <div id="order-btn">
            <button class="btn btn-secondary btm-btn">이전 페이지</button>
            <button class="btn btn-primary btm-btn">결제하기</button>
        </div>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function addrSearch(){
        new daum.Postcode({
            oncomplete: function(data) {
               document.querySelector('#zoneCode').value = data.zonecode;
               document.querySelector('#roadAddr').value = data.roadAddress;

               document.querySelector("#detailAddr").focus();
           }
        }).open();
    }
    
    function copyInfo(){
    	
    }
</script>
</body>
</html>