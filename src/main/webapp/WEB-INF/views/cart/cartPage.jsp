<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>책메이트 : 장바구니</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link href="/cart.css" rel="stylesheet">
</head>
<style>
    #cart-title{
        text-align : center;
    }

    #cart-text{
        font-weight: bold;
        padding: 100px;
    }

    h5 {
        font-weight : bold;
    }
    td{
        text-align : center;
        vertical-align :middle;
    }

    .cart-data-list{
        width : 1400px;
        padding-top: 100px;
	    padding-left : 250px;
        padding-right : 250px;
	    margin : 0 auto;
    }
    #cartbody{
        text-align : center;
        vertical-align :middle;
    }
    .form-control{
        width: 50px;
        height: 30px;
    }
    #order-Info{
        width : 900px;
        height: 100px;
        border-top: solid 3px #e2c9a6;
        border-bottom: solid 3px #e2c9a6;
        text-align : center;
    }
    #cart-btn{
        padding: 150px;
        text-align : center;
    }
    .cartinfo-table-header{
        height : 60px;
        background-color: lightgray;
        border: 1px solid #e2c9a6;
    }
    .cartinfo-table-body{
        height : 100px;
        border: 1px solid #e2c9a6;
    }
    #cartinfo-table-left{
        background-color: lightgray;
        border-bottom: 1px solid #e2c9a6;
    }
    #cartinfo-table-right{
        background-color: lightgray;
        border-bottom: 1px solid #e2c9a6;
    }
    .product-delbtn{
        text-align : right;
    }
    .quantity-btn{
        width: 40px;
        height: 25px;
        font-size :10px;
    }
    .del-btn{
        width: 100px;
        height: 35px;
        font-size :15px;
    }
    button {
      display: inline-flex;
      flex-direction: column;
      align-items: center;
      justify-content: flex-start;
      white-space : nowrap;
    }
    .product-img{
        margin-top: 5%;
        margin-bottom: 10%;
        width : 80px;
        height : 80px;
    }
    .total-price{
        margin: auto 0;
        color: red;
    }
    .product-title{
        margin : auto 0;
        text-align : left;
    }

</style>
<body>
    <body>
        <div id="cart-title">
            <h1 id="cart-text">SHOPPING CART</h1>
            <img src="/c-step01.png" >
        </div>
    <br><br>
        <div class="cart-data-list">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th colspan="5"><h5>장바구니 상품</h5></th>
                        <th class="product-delbtn"><button class="btn btn-secondary del-btn">선택상품 삭제</button></th>
                    </tr>
                </thead>
                <!-- <c:if test="${!empty cartList }">
                    <c:forEach items="${cartList }" var="cartList" varStatus="i"> -->
                        <tbody id="cartbody">
                            <tr>
                                <td>
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                </td>
                                <td>상품정보</td>
                                <td>수량</td>
                                <td>정가</td>
                                <td>할인가</td>
                                <td>예상 적립금</td>
                            </tr>
                        </tbody>
                    <!-- </c:forEach>
                </c:if>
                <c:if test="${empty cartList }">
                    <tr>
                        <td>장바구니에 상품이 없습니다.</td>
                    </tr>
                </c:if> -->
                <tbody id="cartbody">
                    <tr>
                        <td>
                            <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                        </td>
                        <td>
                            <img class="product-img" src="#">
                            <p style="margin-bottom: 10%;">PRODUCT TITLE</p>
                        </td>
                        <td>
                            <input style="text-align:center; margin: 0 auto;" class="form-control form-control-sm" type="text" placeholder="수량" aria-label=".form-control-sm example">
                            <button class="btn btn-secondary quantity-btn">변경</button>
                        </td>
                        <td>12,000원</td>
                        <td>10,800원</td>
                        <td>600원</td>
                    </tr>
                </tbody>
                <tbody id="cartbody">
                    <tr>
                        <td>
                            <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                        </td>
                        <td>
                            <img class="product-img" src="#">
                            <p style="margin-bottom: 10%;">PRODUCT TITLE2</p>
                        </td>
                        <td>
                            <input style="text-align:center; margin: 0 auto;" class="form-control form-control-sm" type="text" placeholder="수량" aria-label=".form-control-sm example">
                            <button class="btn btn-secondary quantity-btn">변경</button>
                        </td>
                        <td>22,000원</td>
                        <td>19,800원</td>
                        <td>1100원</td>
                    </tr>
                </tbody>
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
                    <td>3권</td>
                    <td class="cartinfo-table-body">30,600원</td>
                    <td class="cartinfo-table-body"><h5>0</h5>원</td>
                    <td class="cartinfo-table-body"><p class="total-price">30,600원</p></td>
                    <td>1700원</td>
                </tbody>
            </table>
        </div>
        <div id="cart-btn">
            <button class="btn btn-secondary">쇼핑 계속하기</button>
            <button class="btn btn-primary">상품 주문하기</button>
        </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>