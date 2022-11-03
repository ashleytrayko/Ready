<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<script src="/resources/js/jquery-3.6.1.min.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	<style>
		[id^=product] {
			border-bottom : 1px solid #dcdcdc;
		}
		.review-container {
			background-color : #E0E0E0;
		}
		.product {
			border-top : 1px solid white;
			
		}
		#container1 {
			width : 70%;
			float : left;
		}
		#container2 {
			margin : auto;
			width : 30%;
		}
		#product2 {
			display : flex;
		}
		.review-area{
			display : flex;
		}
		.review-text {
			width : 80%;
		}
		.review-btn {
			width : 20%;
		}
	</style>
	<jsp:include page="../main/header.jsp"></jsp:include>
	<link rel="stylesheet" href="/resources/css/main/mainHeader.css">
</head>
<body>
	<input type="hidden" id="bookNo" name="bookNo" value="${book.bookNo }">
	<input type="hidden" id="productPrice"  name="productPrice" value="${book.priceSales }">
    <div class="main-contents">
		<div class="col-md-3">여기는 사이드바</div>
		
		<div class="main-section">
			<div  id="product2">
		      	<div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250" id="container1">
		        	<div class="col-auto d-none d-lg-block">
						<img src=${book.imgPath } width="200" height="250">
		        	</div>
		        	<div class="col p-4 d-flex flex-column position-relative">
			        	<h3 class="mb-0" id="product1">${book.bookTitle }</h3>
			        	<div class="mb-1 text-muted">저자 : ${book.bookWriter } | 출판사 : ${book.publisher } | 발행일 : ${book.pubDate }</div><br>
			        	<p class="mb-auto">판매가 : <fmt:formatNumber type="number" value="${book.priceSales }" pattern="#,###"/>원</p>
			        	<p class="mb-auto">적립금 : <fmt:formatNumber type="number" value="${book.mileage }" pattern="#,###"/>원</p>
		        	</div>
		    	</div>
				<div id="container2">
					<div>주문수량</div>
					<input type="text" id="productCount" value="1">
					<br>
					<button type="button" class="btn btn-outline-secondary" onclick="order(${book.bookNo});">구매하기</button>
					<br>
					<br>
					<button type="button" class="btn btn-secondary" id="insertCart-btn">장바구니</button>
				</div>
				<br>
		    </div>
		    <br>
		    
			<div id="product3">
				<h3>이 책의 분류</h3>
				<p>${book.category }</p>
			</div>
			<div id="product4">
			<br>
				<h3>책 소개</h3>
				<p>${book.bookContents }</p>
			</div>
			<form action="/book/addReview.kh" method="post">
					<input type="hidden" id="bookNo" name="bookNo" value="${book.bookNo }">
				<br>
				<h3>독자서평 (${book.scoreAvg })</h3>
				<div class="review-container">
				<br>
					<label>평점  : </label>
					<select name="score">
						<option value="1">★☆☆☆☆</option>
						<option value="2">★★☆☆☆</option>
						<option value="3">★★★☆☆</option>
						<option value="4">★★★★☆</option>
						<option value="5">★★★★★</option>
					</select>
					<br><br>
					<h5>한줄평</h5>
					<div class="review-area">
						<textarea rows="3" cols="100" name="reviewContents" class="review-text"></textarea>
						<button type="submit" class="btn btn-secondary" class="review-btn">등록하기</button>
					</div>
				<br>
				<c:forEach items="${rList }" var="review">
					<div class="review-area">
						<div class="product review-text">
							<span>${review.userId }</span>
							<span>평점 ${review.score } / 5</span>
							<div>${review.reviewContents }</div>
							<div>${review.updateDate }</div>
							<br>
						</div>
						<div class="review-btn" align="center">
							<c:if test="${principal.username eq review.userId }">
								<button onclick="modifyView(this, '${review.reviewContents}', ${review.reviewNo });" class="btn btn-secondary">수정</button>
								<button onclick="removeReview('${review.reviewNo}');" class="btn btn-secondary">삭제</button>
							</c:if>
							<br>
						</div>
					</div>
				</c:forEach>
				</div>
			</form>
		</div>
		<div class="col-md-3">여기는 사이드바</div>
    </div>
	<footer>
		
	</footer>

	<script>
	
		function modifyView(obj, reviewContents, reviewNo) {
			console.log(obj);
			event.preventDefault();
			var sel = "";
			var $div = $("<div>");
			sel += "<select name='score'>"
			sel += "<option value='"+1+"'>★☆☆☆☆</option>"
			sel += "<option value='"+2+"'>★★☆☆☆</option>"
			sel += "<option value='"+3+"'>★★★☆☆</option>"
			sel += "<option value='"+4+"'>★★★★☆</option>"
			sel += "<option value='"+5+"'>★★★★★</option>"
			sel += "</select>"
			$div.html(sel);
			$div.append("<input type='text' size='50' value='"+reviewContents+"'>");
			$div.append("<button onclick='modifyReview(this,"+reviewNo+");'>수정</button>");
			$(obj).parent().parent().after($div);
		}
	
		function removeReview(reviewNo) {
			event.preventDefault();
			if(confirm("정말 삭제하시겠습니까?")) {
				var $delForm = $("<form>");
					$delForm.attr("action", "/book/removeReview.kh");
					$delForm.attr("method", "post");
					$delForm.append("<input type='hidden' name='reviewNo' value='"+reviewNo+"'>");
					$delForm.append("<input type='hidden' name='bookNo' value='"+bookNo+"'>");
					$delForm.appendTo("body");
					$delForm.submit();
			}
		}
		
		$("#insertCart-btn").click(function(){
			      
			var bookNo = $("#bookNo").val();
			var productPrice = $("#productPrice").val();
			var productCount = $("#productCount").val();
			      
			$.ajax({
				url : "/cart/insert.ready",
				type : "POST",
				data : {
					bookNo : bookNo,
					productPrice : productPrice,
					productCount : productCount
				},
				success : function(data) {
					alert("장바구니 담기 성공");
				},
				error : function() {
					alert("장바구니 담기 실패");
				}
			});
		})
		
		
		
		function order(bookNo) {
	         var productCount = $("#productCount").val();
	         location.href="/order/directOrderView?bookNo="+bookNo+"&productCount="+productCount;
	      }

	</script>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>