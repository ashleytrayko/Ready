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
                	<input type="hidden" name="bookNo" id="id-bookNo"value="${bookData.bookNo }">
                    <tr>
                        <td>
                            <img class="product-img" src="${bookData.imgPath }">
                        </td>
                        <td>
                            <c:choose>
                            	<c:when test="${fn:length(bookData.bookTitle ) gt 20 }">
                            	<c:out value="${fn:substring(bookData.bookTitle, 0, 19) }...">
                            	</c:out></c:when>
                            	<c:otherwise>
                            	<c:out value="${bookData.bookTitle }">
                            	</c:out></c:otherwise>
<%--                             <p id="bookTitle" style="margin-bottom: 10%;">${cartList.book.bookTitle }</p> --%>
                            </c:choose>
                        </td>
                        <td><fmt:formatNumber type="number" pattern="###,###,###" value="${bookData.priceSales}"/>원</td>
                        <td><fmt:formatNumber type="number" pattern="###,###,###" value="${bookData.priceSales * 0.99}"/>원</td>
                        <td><input type="text" name='productCount' id="id-productCount" value="${productCount }"  style="border:0 solid black; width:30px;"></td>
                        <td><fmt:formatNumber type="number" pattern="###,###,###" value="${(bookData.priceSales * productCount) * 0.99}"/>원</td>
                        <td><fmt:formatNumber type="number" pattern="###,###,###" value="${bookData.mileage * productCount }"/>원</td>
                    </tr>
                    <c:set var="priceSum" value="${priceSum + (bookData.priceSales * productCount) }"/>
                    <c:set var="productSum" value="${productSum + productCount }"/>
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
                        <input class="form-control form-control-sm name-phone" id="buyerName" type="text" value="${userInfoList.userName }" style="width:130px">
                    </td>
                </tr>
                <tr>
                    <td class="buyer-info-td">
                        <p>연락처</p>
                    </td>
                    <td>
                        <input class="form-control form-control-sm name-phone" id="buyerPhone" type="text" placeholder="01000000000" value="${userInfoList.userPhone }" style="width:130px">
                    </td>
                </tr>
                <tr>
                    <td class="buyer-info-td">
                        <p>E-mail</p>
                    </td>
                    <td>
                        <input class="form-control form-control-sm Email" type="text" id="buyerEmail" placeholder="khuser01@iei.or.kr" style="width:200px" value="${userInfoList.userEmail }">
                    </td>
                </tr>
                <tr>
                    <td class="addr-info-td">
                        <p style="vertical-align :middle; margin-top : 0px; margin-bottom : 0px;">주소</p>
                    </td>
                    <td class="addr-info-td" style="width : 400px;">
                    	<div class="div-floatLeft">
                        	<input class="form-control form-control-sm Addr1" id="buyerZoneCode" type="text" value="${userInfoList.userPostcode }" placeholder="우편번호" style="width:90px;">
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
                        <input class="form-control form-control-sm detail-Addr" id="buyerRoadAddr" type="text" value="${userInfoList.userAddress }" placeholder="도로명 주소" style="width: 400px;">
                    </td>
                </tr>
                <tr>
                    <td class="addr-info-td">
                        <p></p>
                    </td>
                    <td colspan="2" class="addr-td">
                        <input class="form-control form-control-sm detail-Addr" id="buyerDetailAddr" type="text" value="${userInfoList.userDetailAddress }" placeholder="상세 주소" style="width: 400px;">
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
                        	<input class="form-control form-control-sm name-phone" id="reciverName" type="text" placeholder="일용자" value="" style="width:130px">
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
                        <input class="form-control form-control-sm name-phone" id="reciverPhone" type="text" placeholder="01000000000" value="" style="width:130px">
                    </td>
                </tr>
                <tr>
                    <td class="buyer-info-td">
                        <p>E-mail</p>
                    </td>
                    <td>
                        <input class="form-control form-control-sm Email" id="reciverEmail" type="text" placeholder="khuser01@iei.or.kr" style="width:200px" value="">
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
			  <input class="form-check-input" type="radio" name="paymentmethod" value="card" id="flexRadioDefault1">
			  	<label class="form-check-label" for="flexRadioDefault1">
			    	신용카드
			  	</label>
			</div><br>
			<div class="form-check">
			  <input class="form-check-input" type="radio" name="paymentmethod" value="kakaopay" id="flexRadioDefault2" checked>
			  	<label class="form-check-label" for="flexRadioDefault2">
			    	카카오 페이
			  	</label>
			</div><br>
			<div class="form-check">
			  <input class="form-check-input" type="radio" name="paymentmethod" value="trans" id="flexRadioDefault2" checked>
			  	<label class="form-check-label" for="flexRadioDefault2">
			    	실시간 계좌 이체
			  	</label>
			</div><br>
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
                    <td id="productSum">총 <c:out value="${productSum }"/>권</td>
                    <td class="orderinfo-table-body"><fmt:formatNumber type="number" pattern="###,###,###" value="${priceSum }"/>원</td>
                    <td class="orderinfo-table-body">0원</td>
					<td class="orderinfo-table-body"><p class="total-price" id="info-total-price"><fmt:formatNumber type="number" pattern="###,###,###" value="${priceSum * 0.99}"/>원</p></td>
					<td><fmt:formatNumber type="number" pattern="###,###,###" value="${priceSum * 0.05}"/>원</td>
                </tbody>
            </table>
        </div>
        <div id="order-btn">
            <button class="btn btn-secondary btm-btn" onclick="history.back();">이전 페이지</button>
            <button class="btn btn-primary btm-btn" onclick="requestPay(`${priceSum * 0.99}` , `${bookData.bookTitle}` , `${productSum}`);">결제하기</button>
            ${priceSum * 0.99}										
        </div>
        
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	
	var IMP = window.IMP;
	IMP.init('imp45674133');

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
    
    
    function requestPay(price, title, totalCount) {
    	
    	const pricefloor = Math.floor(price);
    	const buyerName = $("#buyerPhone").val();
    	const buyerPhone = $("#buyerPhone").val();
    	const buyerEmail = $("#buyerEmail").val();
    	const paymethod = $('input:radio[name=paymentmethod]:checked').val();
    	
    	const bookNo = $("id-bookNo").val();
    	const productCount = $("id-productCount").val();
 	    
        IMP.request_pay({ // param
            pg: "html5_inicis",
            pay_method: paymethod,
            merchant_uid: "",
            name: title,
            amount: pricefloor,
            buyer_email: buyerEmail,
            buyer_name: buyerName,
            buyer_tel: buyerPhone,
            custom_data: {
            	bookNo : bookNo,
            	productCount : productCount,
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
						bookNo : rsp.custom_data.bookNo,
						productCount : rsp.custom_data.productCount,
						totalPrice : rsp.paid_amount,
						paymethod : rsp.pay_method,
						reciverName : rsp.custom_data.reciverName,
						reciverPhone : rsp.custom_data.reciverPhone,
						reciverEmail : rsp.custom_data.reciverEmail,
		            	reciverZoneCode : rsp.custom_data.reciverZoneCode,
		            	reciverRoadAddr : rsp.custom_data.reciverRoadAddr,
		            	reciverDetailAddr : rsp.custom_data.reciverDetailAddr
					},
					success : function(data){
						console.log(data);
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