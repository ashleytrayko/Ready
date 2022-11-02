<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <p class="order-info-p">수령인</p>
                    </td>
                    <td>
                        <p class="order-info-p">일용자</p>
                    </td>
                </tr>
                <tr>
                    <td class="buyer-info-td">
                        <p class="order-info-p">주문번호</p>
                    </td>
                    <td>
                        <p class="order-info-p">202200000000</p>
                    </td>
                </tr>
                <tr>
                    <td class="addr-info-td">
                        <p class="order-info-p">배송지 정보</p>
                    </td>
                    <td>
                        <p class="order-info-p">00000 (우편번호)</p>
                    </td>
                </tr>
                <tr>
                    <td class="addr-info-td">
                    </td>
                    <td>
                        <p class="order-info-addr-p">서울시 중구 남대문로 120 대일빌딩 (도로명 주소)</p>
                    </td>
                </tr>
                <tr>
                    <td class="addr-info-td">
                    </td>
                    <td>
                        <p class="order-info-addr-p">3F F강의실 (상세 주소)</p>
                    </td>
                </tr>
                <tr>
                    <td class="buyer-info-td">
                        <p class="order-info-p">결제 방법</p>
                    </td>
                    <td>
                        <p class="order-info-p">신용카드</p>
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
                                    <td colspan="2">이름</td>
                                    <td>수량</td>
                                    <td>정가</td>
                                    <td>할인가</td>
                                    <td>적립금</td>
                                </tr>
                            </thead>
                            <c:forEach items="${orderList }"var="orderList" varStatus="i" >
                            ${orderList.orderNo }
                            <tbody>
                              <tr class="acd-tr">
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
                          </c:forEach>
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
                    <td>3권</td>
                    <td class="orderinfo-table-body">30,600원</td>
                    <td class="orderinfo-table-body">0원</td>
                    <td class="orderinfo-table-body"><p class="total-price">30,600원</p></td>
                    <td>1700원</td>
                </tbody>
            </table>
        </div>
        <div id="order-btn">
            <button class="btn btn-secondary btm-btn">메인으로</button>
            <button class="btn btn-primary btm-btn">주문 내역으로</button>
        </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>