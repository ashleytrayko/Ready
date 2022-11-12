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
    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
    <script src="../resources/js/jquery-3.6.1.min.js"></script>
</head>
<style>
</style>
<body>
<jsp:include page="../main/header.jsp"></jsp:include>
     <input type="hidden" name="bookNo" id="id-bookNo" value="${bookData.bookNo }">
     <c:set var="salePrice" value="${(bookData.priceSales * discountRate)-((bookData.priceSales *discountRate)%10)}"/>
     <input type="hidden" name="productPrice" id="id-productPrice" value="${salePrice}">
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
                                <td>예상 마일리지</td>
                            </tr>
                        </tbody>
                <tbody class="cartbody">
                	<c:set var="priceSum" value="0"/>
                	<c:set var="productSum" value="0"/>
                    <tr>
                        <td>
                            <img class="product-img" src="${bookData.imgPath }">
                        </td>
                        <td>
                            <c:choose>
                            	<c:when test="${fn:length(bookData.bookTitle) gt 20 }">
                            	<c:out value="${fn:substring(bookData.bookTitle, 0, 19) }...">
                            	</c:out></c:when>
                            	<c:otherwise>
                            	<c:out value="${bookData.bookTitle }">
                            	</c:out></c:otherwise>
<%--                             <p id="bookTitle" style="margin-bottom: 10%;">${cartList.book.bookTitle }</p> --%>
                            </c:choose>
                        </td>
                        <!-- 정가 -->
                        <td><fmt:formatNumber type="number" pattern="###,###,###" value="${bookData.priceSales}"/>원</td>
                        <!-- 할인가 -->
                        <td><fmt:formatNumber type="number" pattern="###,###,###" value="${salePrice}"/>원</td>
                        <!-- 수량 -->
                        <td><input type="text" name='productCount' id="id-productCount" value="${productCount }"  style="border:0 solid black; width:30px;" readonly></td>
                        <!-- 할인가*수량 -->
                        <td><fmt:formatNumber type="number" pattern="###,###,###" value="${salePrice * productCount}"/>원</td>
                        <!-- 마일리지*수량 -->
                        <td><fmt:formatNumber type="number" pattern="###,###,###" value="${bookData.mileage * productCount }"/>원</td>
                    </tr>
					<c:set var="priceSum" value="${priceSum + (bookData.priceSales * productCount) }"/>
                    <c:set var="productSum" value="${productSum + productCount }"/>
                    <c:set var="salePriceSum" value="${salePriceSum + (salePrice * productCount)}"/>
                    <c:set var="onlysalePriceSum" value="${salePriceSum}"/>
                    <c:set var="mileageSum" value="${mileageSum + (bookData.mileage * productCount) }"/>
                    <c:if test="${priceSum < 10000}">
                    	<c:set var="salePriceSum" value="${salePriceSum + 2500}"/>
                    </c:if>
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
                        <input class="form-control form-control-sm name-phone" id="buyerName" type="text" value="${userInfo.userName }" style="width:130px">
                    </td>
                </tr>
                <tr>
                    <td class="buyer-info-td">
                        <p>연락처</p>
                    </td>
                    <td>
                        <input class="form-control form-control-sm name-phone" id="buyerPhone" type="text" value="${userInfo.userPhone }" style="width:130px">
                    </td>
                </tr>
                <tr>
                    <td class="buyer-info-td">
                        <p>E-mail</p>
                    </td>
                    <td>
                        <input class="form-control form-control-sm Email" type="text" id="buyerEmail" style="width:200px" value="${userInfo.userEmail }">
                    </td>
                </tr>
                <tr>
                    <td class="addr-info-td">
                        <p style="vertical-align :middle; margin-top : 0px; margin-bottom : 0px;">주소</p>
                    </td>
                    <td class="addr-info-td" style="width : 400px;">
                    	<div class="div-floatLeft">
                        	<input class="form-control form-control-sm Addr1" id="buyerZoneCode" type="text" value="${userInfo.userPostcode }" style="width:90px;">
                        </div>
                        <div class="div-floatLeft">
                        	<button class="btn btn-secondary searchAddr-btn" onclick="byuerAddrSearch();" style="font-size :12px;">우편번호 검색</button>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="addr-info-td">
                        <p></p>
                    </td>
                    <td colspan="2">
                        <input class="form-control form-control-sm detail-Addr" id="buyerRoadAddr" type="text" value="${userInfo.userAddress }" placeholder="도로명 주소" style="width: 400px;">
                    </td>
                </tr>
                <tr>
                    <td class="addr-info-td">
                        <p></p>
                    </td>
                    <td colspan="2" class="addr-td">
                        <input class="form-control form-control-sm detail-Addr" id="buyerDetailAddr" type="text" value="${userInfo.userDetailAddress }" placeholder="상세 주소" style="width: 400px;">
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
                        	<input class="form-control form-control-sm name-phone" id="reciverName" type="text" placeholder="이름" value="" style="width:130px">
                    	</div>
                    	<div class="div-floatLeft">
                        	<button class="btn btn-secondary" id="infocopy-btn" onclick="copyInfo();">구매자정보 복사</button>
                    	</div>
                    </td>
                </tr>
                <tr>
                    <td class="buyer-info-td">
                        <p>연락처</p>
                    </td>
                    <td>
                        <input class="form-control form-control-sm name-phone" id="reciverPhone" type="text" placeholder="전화번호" value="" style="width:130px">
                    </td>
                </tr>
                <tr>
                    <td class="buyer-info-td">
                        <p>E-mail</p>
                    </td>
                    <td>
                        <input class="form-control form-control-sm Email" id="reciverEmail" type="text" placeholder="이메일" style="width:200px" value="">
                    </td>
                </tr>
                <tr>
                    <td class="addr-info-td">
                        <p style="vertical-align :middle; margin-top : 0px; margin-bottom : 0px;">주소</p>
                    </td>
                    <td class="addr-info-td" style="width : 400px;">
                    	<div class="div-floatLeft">
                        	<input class="form-control form-control-sm Addr1" id="reciverZoneCode" type="text" value="" placeholder="우편번호" style="width:90px;">
                        </div>
                        <div class="div-floatLeft">
                        	<button class="btn btn-secondary searchAddr-btn" onclick="reciverAddrSearch();" style="font-size :12px;">우편번호 검색</button>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="addr-info-td">
                        <p></p>
                    </td>
                    <td colspan="2">
                        <input class="form-control form-control-sm detail-Addr" id="reciverRoadAddr" type="text" value="" placeholder="도로명 주소" style="width: 400px;">
                    </td>
                </tr>
                <tr>
                    <td class="addr-info-td">
                        <p></p>
                    </td>
                    <td colspan="2" class="addr-td">
                        <input class="form-control form-control-sm detail-Addr" id="reciverDetailAddr" type="text" value="" placeholder="상세 주소" style="width: 400px;">
                    </td>
                </tr>
            </table>
        </div>
        <div class="order-data-list">
        <h5 style="font-weight : bold;">결제 정보 확인</h5>
        <hr>
            <table id="order-Info"> 
                <thead>
                    <tr>
                        <th id="orderinfo-table-left">주문 수량</th>
                        <th class="orderinfo-table-header">주문 금액 합계</th>
                        <th class="orderinfo-table-header">
                        	<div id="div-delivery" style="text-align : center;">
                        		<p class="arrow_box" style="margin-bottom:0px;">
                        			배송비 <img src="../resources/images/cart_order/guide_icon.png" style="width:20px; height:20px; margin-bottom:4px;" >
                        		<span class="deliveryGuide-span">
                        			상품 총 가격이 만원 이상일 시 배송비가 무료입니다!
                        		</span>
                        		</p>
                        	</div>
                        </th>
                        <th class="orderinfo-table-header"><p class="total-price">총 결제 금액</p></th>
                        <th id="orderinfo-table-right">예상 마일리지</th>
                    </tr>
                </thead>
                <tbody>
                    <td id="productSum">총 <c:out value="${productSum }"/>권</td>
                    <td class="orderinfo-table-body"><fmt:formatNumber type="number" pattern="###,###,###" value="${priceSum }"/>원</td>
                    <td class="orderinfo-table-body"><input readonly type="text" id="id-delivery-fee" style="border:0px; width:50px;" value="<fmt:formatNumber type="number" pattern="###,###,###" value="0"/>">원</td>
					<td class="orderinfo-table-body"><input readonly type="text" class="total-price" id="id-total-price" style="border:0px; width:100px;" value="<fmt:formatNumber type="number" pattern="###,###,###" value="${salePriceSum}"/>">원</td>
					<td><fmt:formatNumber type="number" pattern="###,###,###" value="${mileageSum}"/>P</td>
                </tbody>
            </table>
            <div style="text-align:right;">
            	<p>현재 보유한 마일리지 : <input type="text" value="${userInfo.userReserves }" id="currentMileage" style="border:0px; width:100px;" readonly>P</p>
            	마일리지 : <input type="text" value="0" id="useMileage" style="width:100px;">P <button onclick="useMileage(${salePriceSum } ,${onlysalePriceSum });">사용</button>
        	</div>
        </div>
        <div class="buyer-data-list">
        	<table class="buyer-info buyer-info-title">
              <tr>
                 <th colspan="6">
                     <h5 style="font-weight : bold;">결제 방법</h5>
                 </th>
              </tr>
           </table>
           <hr><br><br>
	        <div class="form-check">
			  <input class="form-check-input" type="radio" name="paymentmethod" value="card" id="flexRadioDefault1" checked>
			  	<label class="form-check-label" for="flexRadioDefault1">
			    	신용카드
			  	</label>
			</div><br>
			<div class="form-check">
			  <input class="form-check-input" type="radio" name="paymentmethod" value="kakaopay" id="flexRadioDefault2">
			  	<label class="form-check-label" for="flexRadioDefault2">
			    	카카오 페이
			  	</label>
			</div><br>
			<div class="form-check">
			  <input class="form-check-input" type="radio" name="paymentmethod" value="trans" id="flexRadioDefault2">
			  	<label class="form-check-label" for="flexRadioDefault2">
			    	실시간 계좌 이체
			  	</label>
			</div><br>
		</div>
        <div id="order-btn">
            <button class="btn btn-secondary btm-btn" onclick="history.back();">이전 페이지</button>
            <button class="btn btn-primary btm-btn" onclick="requestPay(`${salePriceSum}` , `${bookData.bookTitle}` , `${productSum}`, `${mileageSum }`);">결제하기</button>								
        </div>
        
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	window.onload = function(){
		var bookPrice = ${priceSum};
		if(bookPrice < 10000) {
			$("#id-delivery-fee").attr("value", "2,500");
		}
	}
	

    function byuerAddrSearch(){
        new daum.Postcode({
            oncomplete: function(data) { 
               document.querySelector('#buyerZoneCode').value = data.zonecode;
               document.querySelector('#buyerRoadAddr').value = data.roadAddress;
               document.querySelector("#buyerDetailAddr").focus();
           }
        }).open();
    }
    
    function reciverAddrSearch(){
        new daum.Postcode({
            oncomplete: function(data) {
               document.querySelector('#reciverZoneCode').value = data.zonecode;
               document.querySelector('#reciverRoadAddr').value = data.roadAddress;
               document.querySelector("#reciverDetailAddr").focus();
           }
        }).open();
    }
    
    function copyInfo(){
    	const buyerName = $("#buyerName").val();
    	$("#reciverName").attr('value',buyerName);
    	
    	const buyerPhone = $("#buyerPhone").val();
    	$("#reciverPhone").attr('value', buyerPhone);
    	
    	const buyerEmail = $("#buyerEmail").val();
    	$("#reciverEmail").attr('value', buyerEmail);
    	
    	const buyerZoneCode = $("#buyerZoneCode").val();
    	$("#reciverZoneCode").attr('value',buyerZoneCode);
    	
    	const buyerRoadAddr = $("#buyerRoadAddr").val();
    	$("#reciverRoadAddr").attr('value',buyerRoadAddr);
    	
    	const buyerDetailAddr = $("#buyerDetailAddr").val();
    	$("#reciverDetailAddr").attr('value',buyerDetailAddr);
    }
    
	function useMileage(salePriceSum, onlysalePriceSum){
    	
		var inputMileage = $("#useMileage");
    	var currentMileage = +$("#currentMileage").val();
    	var useMileage = +$("#useMileage").val();
    	var pacSalePriceSum = salePriceSum;
    	var onlySalePriceSum = onlysalePriceSum;
		var num_check= /^[0-9]+$/;
		
    	if(currentMileage < useMileage) {
    		alert("현재 보유한 마일리지가 부족합니다!");
    		inputMileage.focus();
    		return false;
    	} else if(useMileage > onlySalePriceSum) {
    		alert("사용 마일리지는 최소 결제 금액을 넘을 수 없습니다!");
    		inputMileage.focus();
    		return false;
    	} else if(!num_check.test(useMileage)){
    		alert ("숫자만 입력할 수 있습니다.");
			inputMileage.focus();
			return false;
    	} else {
    		var calPrice = pacSalePriceSum - useMileage;
    		var caledPrice = calPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		
    		$("#id-total-price").attr("value", caledPrice);
    	}
    }
    
	var IMP = window.IMP;
	IMP.init('imp45674133');
	
    function requestPay(priceSum, title, totalCount, mileageSum) {
    	
    	const orderId = (new Date().getFullYear())+""+(new Date().getMonth()+1) +(new Date().getDate())+new Date().getTime();
    	const totalPrice = Math.floor(priceSum);
    	const buyerName = $("#buyerPhone").val();
    	const buyerPhone = $("#buyerPhone").val();
    	const buyerEmail = $("#buyerEmail").val();
    	const paymethod = $('input:radio[name=paymentmethod]:checked').val();
    	
    	const bookNo = $("#id-bookNo").val();
    	const productCount = $("#id-productCount").val();
    	const productPrice = Math.floor($("#id-productPrice").val());
    	
     	var useMileage = +$("#useMileage").val();
    	var calPrice = totalPrice - useMileage;

        IMP.request_pay({ // param
            pg: "html5_inicis",
            pay_method: paymethod,
            merchant_uid: orderId,
            name: title + " 총 " + totalCount + "권",
            amount: calPrice,
            buyer_email: buyerEmail,
            buyer_name: buyerName,
            buyer_tel: buyerPhone,
            custom_data: {
            	bookNo : bookNo,
            	productCount : productCount,
            	productPrice : productPrice,
            	mileageSum : mileageSum,
            	useMileage : useMileage,
            	totalPrice : totalPrice,
            	orderId : orderId,
            	reciverName : $("#reciverName").val(),
            	reciverPhone : $("#reciverPhone").val(),
            	reciverEmail : $("#reciverEmail").val(),
            	reciverZoneCode : $("#reciverZoneCode").val(),
            	reciverRoadAddr : $("#reciverRoadAddr").val(),
            	reciverDetailAddr : $("#reciverDetailAddr").val()
            }
        }, function (rsp) { // callback
            if (rsp.success) {
        	console.log("response Data : ", rsp.custom_data);
				$.ajax({
					url :"/order/insertDirectOrder",
					type : "POST",
					data : {
						imp_uid: rsp.imp_uid,
						orderId : rsp.custom_data.orderId,
						bookNo : rsp.custom_data.bookNo,
						productCount : rsp.custom_data.productCount,
						productPrice : rsp.custom_data.productPrice,
						mileageSum : rsp.custom_data.mileageSum,
						totalPrice : rsp.paid_amount,
						paymethod : rsp.pay_method,
						reciverName : rsp.custom_data.reciverName,
						reciverPhone : rsp.custom_data.reciverPhone,
						reciverEmail : rsp.custom_data.reciverEmail,
		            	reciverZoneCode : rsp.custom_data.reciverZoneCode,
		            	reciverRoadAddr : rsp.custom_data.reciverRoadAddr,
		            	reciverDetailAddr : rsp.custom_data.reciverDetailAddr,
		            	useMileage : rsp.custom_data.useMileage,
		            	totalPrice : rsp.custom_data.totalPrice
					},
					success : function(orderId){
						location.href="/order/orderDetailView?orderId="+orderId;
					},
					error : function(){
						alert("fail");
					}
				})
            } else {
				alert("결제가 실패하였습니다. 에러내용 : " + rsp.error_msg);
            }
        });
    }
</script>
</body>
</html>