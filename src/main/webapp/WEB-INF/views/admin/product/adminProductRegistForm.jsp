<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공용jsp틀</title>
<!-- 타이틀 밑에 아래 css링크 추가해줄것 -->
<link rel="stylesheet" href="/resources/css/main/mainHeader.css">
</head>
<body>
	<jsp:include page="../../admin/adminHeader.jsp"></jsp:include>
	<div class="main-contents">
		<div class="main-sidebar">
						<jsp:include page="../../admin/adminSideBar.jsp"></jsp:include>
		</div>
		<div class="main-section">
			<!-- 이 안에서 작업! 여기가 본문-->
			<h1>공지사항 작성</h1>
			<form method="post" action="/admin/registerProduct">
				<div class="form-group">
					<label for="bookTitle">도서명</label> 
					<input type="text"
						class="form-control" placeholder="?자 이내, 특수문자 ㄴ" id="bookTitle"
						name="bookTitle"> 
				</div>
				<div class="form-group">
					<label for="bookWriter">저자 </label> 
					<input type="text"
						class="form-control" placeholder="Enter bookWriter"
						id="bookWriter" name="bookWriter">
				</div>
				<div class="form-group">
					<label for="pubDate">발매일 </label> <input type="text"
						class="form-control" placeholder="Enter pubDate"
						id="pubDate">
				</div>
				<div class="form-group">
					<label for="category">카테고리 </label> 
					<input type="text"
						class="form-control" placeholder="Enter category" id="category"
						name="category">
				</div>
				<div class="form-group">
					<label for="bookContents">도서 내용 </label> 
					<input type="text"
						class="form-control" placeholder="Enter bookContents" id="bookContents"
						name="bookContents">
				</div>
				<div class="form-group">
					<label for="ISBN">ISBN </label> 
					<input type="text"
						class="form-control" placeholder="Enter ISBN" id="ISBN"
						name="ISBN">
				</div>
				<div class="form-group">
					<label for="priceSales">판매가 </label> <input type="text"
						class="form-control" placeholder="Enter priceSales"
						id="priceSales" name="priceSales">
				</div>
				<div class="form-group">
					<label for="mileage">마일리지 </label>
					 <input type="text"
						class="form-control" placeholder="Enter mileage" id="mileage"
						name="mileage">
				</div>
				<div class="form-group">
					<label for="publisher">출판사 </label>
					 <input type="text"
						class="form-control" placeholder="Enter publisher"
						id="publisher" name="publisher">
				</div>
				<div class="form-group">
					<label for="userNickname">도서 이미지 </label> <input type="file"
						class="form-control" id="bookImage" name="bookImage" onchange="readFile(this);">
				</div>
				<div>
					<img id="preview"/>
				</div>
				<button type="submit">도서 등록</button>
				<button type="button" onclick="history.back();">뒤로가기</button>
			</form>
		</div>
		<div class="main-sidebar">여기는 사이드바</div>
	</div>
	<footer> </footer>
<script>
function readFile(input){
		if(input.files && input.files[0]){
			var reader = new FileReader();
			reader.onload = function(e){
				document.getElementById('preview').src = e.target.result;
			};
			reader.readAsDataURL(input.files[0]);
		}else{
			document.getElementById('preview').src = "";
		}
	}
</script>
</body>
</html>