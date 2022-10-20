<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>책메이트 : 주문하기</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link href="../resources/css/cart_order/order.css" rel="stylesheet">
    <script src="../resources/js/jquery-3.6.1.min.js"></script>
</head>
<style>
</style>
<body>
    <body>
        <div id="order-title">
            <h1 id="order-text">ORDER</h1>
            <img src="../resources/images/cart_order/c-step02.png" >
        </div>
    <br><br>
        <div class="order-data-list">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th colspan="6"><h5>주문할 상품</h5></th>
                    </tr>
                </thead>
                        <tbody>
                            <tr>
                                <td colspan="2">상품정보</td>
                                <td>수량</td>
                                <td>정가</td>
                                <td>할인가</td>
                                <td>예상 적립금</td>
                            </tr>
                        </tbody>
                <tbody>
                    <tr>
                        <td>
                            <img class="product-img" src="#">
                        </td>
                        <td>
                            <p class="product-title">PRODUCT TITLE</p>
                        </td>
                        <td>1</td>
                        <td>12,000원</td>
                        <td>10,800원</td>
                        <td>600원</td>
                    </tr>
                </tbody>
                <tbody>
                    <tr>
                        <td>
                            <img class="product-img" src="#">
                        </td>
                        <td>
                            <p class="product-title">PRODUCT TITLE2</p>
                        </td>
                        <td>2</td>
                        <td>22,000원</td>
                        <td>19,800원</td>
                        <td>1100원</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="buyer-data-list">
            <table class="buyer-info buyer-info-title">
                <tr>
                    <th colspan="6">
                        <h5>구매자 정보</h5>
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
                        <input class="form-control form-control-sm name-phone" type="text" placeholder="일용자">
                    </td>
                    <td id="infocopy-btn-td">
                    </td>
                </tr>
                <tr>
                    <td class="buyer-info-td">
                        <p>연락처</p>
                    </td>
                    <td>
                        <input class="form-control form-control-sm name-phone" type="text" placeholder="01000000000">
                    </td>
                </tr>
                <tr>
                    <td class="buyer-info-td">
                        <p>E-mail</p>
                    </td>
                    <td>
                        <input class="form-control form-control-sm Email-Addr" type="text" placeholder="khuser01@iei.or.kr">
                    </td>
                </tr>
            </table>
        </div>

        <div class="buyer-data-list">
            <table class="buyer-info buyer-info-title">
                <tr>
                    <th colspan="6">
                        <h5>배송지 정보</h5>
                    </th>
                </tr>
            </table>
            <hr>
            <table class="buyer-info-table">
                <tr class="buyer-info-tr">
                    <td class="buyer-info-td">
                        <p>이름</p>
                    </td>
                    <td id="name-td">
                        <input class="form-control form-control-sm name-phone" type="text" placeholder="일용자">
                    </td>
                    <td id="infocopy-btn-td">
                        <button class="btn btn-secondary infocopy-btn">구매자정보 복사</button>
                    </td>
                </tr>
                <tr>
                    <td class="buyer-info-td">
                        <p>연락처</p>
                    </td>
                    <td>
                        <input class="form-control form-control-sm name-phone" type="text" placeholder="01000000000">
                    </td>
                </tr>
                <tr>
                    <td class="buyer-info-td">
                        <p>E-mail</p>
                    </td>
                    <td>
                        <input class="form-control form-control-sm Email-Addr" type="text" placeholder="khuser01@iei.or.kr">
                    </td>
                </tr>
                <tr><td style="height: 10px;"></td></tr>
                <tr>
                    <td class="addr-info-td">
                        <p>주소</p>
                    </td>
                    <td class="addr-info-td">
                        <input class="form-control form-control-sm Email-Addr" id="zoneCode" type="text" placeholder="00000 (우편번호)">
                    </td>
                    <td id="searchAddr-btn-td">
                        <button class="btn btn-secondary searchAddr-btn" onclick="addrSearch();">우편번호 검색</button>
                    </td>
                </tr>
                <tr>
                    <td class="addr-info-td">
                        <p></p>
                    </td>
                    <td colspan="2">
                        <input class="form-control form-control-sm detail-Addr" id="roadAddr" type="text" placeholder="서울시 중구 남대문로 120 대일빌딩 (도로명 or 지번 주소)">
                    </td>
                </tr>
                <tr>
                    <td class="addr-info-td">
                        <p></p>
                    </td>
                    <td colspan="2" class="addr-td">
                        <input class="form-control form-control-sm detail-Addr" id="detailAddr" type="text" placeholder="3F F강의실 (상세 주소)">
                    </td>
                </tr>
            
            </table>
            
        </div>

        <div class="order-data-list">
            <table id="order-Info"> 
                <thead>
                    <tr id="">
                        <th id="orderinfo-table-left">주문 수량</th>
                        <th class="orderinfo-table-header">주문 금액 합계</th>
                        <th class="orderinfo-table-header">배송비</th>
                        <th class="orderinfo-table-header"><p class="total-price">총 금액 합계</p></th>
                        <th id="orderinfo-table-right">예상 적립금</th>
                    </tr>
                </thead>
                <tbody>
                    <td>3권</td>
                    <td class="orderinfo-table-body">30,600원</td>
                    <td class="orderinfo-table-body">0원</td>
                    <td class="orderinfo-table-body"><p class="total-price">30,600원</p></td>
                    <td>1700원</td>
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
</script>
</body>
</html>