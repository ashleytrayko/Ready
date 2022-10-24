<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	<style>
		[id^=product] {
			border-bottom : 1px solid #dcdcdc;
		}
	</style>
	<jsp:include page="../main/header.jsp"></jsp:include>

</head>
<body>
	<input type="hidden" id="bookNo" value="${book.bookNo }">
	<input type="hidden" id="productPrice"  value="${book.priceSales }">
	${principal }
    <div class="main-contents">
		<div class="col-md-3">여기는 사이드바</div>
		
		<div class="main-section">
			<div class="col-md-6" id="product2">
		      	<div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250">
		        	<div class="col-auto d-none d-lg-block">
						<img src=${book.imgPath } width="200" height="250">
		        	</div>
		        	<div class="col p-4 d-flex flex-column position-relative">
			        	
			        	<h3 class="mb-0" id="product1">${book.bookTitle }</h3>
			        	<div class="mb-1 text-muted">저자 : ${book.bookWriter } | 출판사 : ${book.publisher } | 발행일 : ${book.pubDate }</div><br>
			        	<p class="mb-auto">판매가 ${book.priceSales }원</p>
			        	<input type="text" id="productCount" value="1">
			        	<p class="mb-auto">적립금 ${book.mileage }원</p>
		        	</div>
		    	</div>
				<div class="col-md-6">
				<br>
					<button type="button" class="btn btn-outline-secondary">구매하기</button>
					<br>
					<br>
					<button type="button" class="btn btn-secondary" id="insertCart-btn">장바구니</button>
				</div>
				<br>
		    </div>
			<div class="col-md-6" id="product3">
			<br>
				<h3>이 책의 분류</h3>
				<p>${book.category }</p>
			</div>
			<div class="col-md-6" id="product4">
			<br>
				<h3>책 소개</h3>
				<p>${book.bookContents }</p>
			</div>
			<form action="/book/addReview.kh" method="post">
				<div class="col-md-6" >
				<br>
					<h3>독자서평</h3>
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
					<textarea rows="3" cols="100" name="reviewContents"></textarea>
					<button type="submit" class="btn btn-secondary">등록하기</button>
				</div>
			</form>
		</div>
		<div class="col-md-3">여기는 사이드바</div>
    </div>
	<footer>
		
	</footer>


	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>