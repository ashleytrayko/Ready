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
<title>설문조사 페이지</title>
	<style>
		.gender-img {
			height : 150px;
			width : 150px;
			border-rauius : 100%;
		}
		.half-area {
			width : 50%;
			float : left;
		}
		.tripple-area {
			width : 33%;
			float : left;
		}
	</style>

	<jsp:include page="../main/header.jsp"></jsp:include>
	<link rel="stylesheet" href="/resources/css/main/mainHeader.css">
</head>
<body>
	 <div class="main-contents">
		<div class="col-md-3">
			<jsp:include page="../main/mypageSideBar.jsp"></jsp:include>
		</div>
		
		<div class="main-section">
			<h1>Read'y 설문조사</h1>
			<br><br><br><br><br><br><br>
			<form action="#" method="POST">
			<div>
				<h3>회원님의 성별을 알려주세요</h3><br><br>
				<div class="half-area" align="center">
					<label>
						<img class="gender-img" src="../resources/images/survey/boy_img.png"><br>
						<input type="radio" name="gender" value="남">남자
					</label>
				</div>
				<div class="half-area" align="center">
					<label>
						<img class="gender-img" src="../resources/images/survey/girl_img.png"><br>
						<input type="radio" name="gender" value="여">여자
					</label>
				</div>
				<br><br><br><br><br><br><br><br><br><br><br>
			</div>
			<div>
				<h3>연애중이시거나 결혼을 하셨나요?</h3><br><br>
				<div class="half-area" align="center">
					<label>
						<img class="gender-img" src="../resources/images/survey/solo_img.png">
						<br><input type="radio" name="love" value="solo">솔로
					</label>
				</div>
				<div class="half-area" align="center">
					<label>
						<img class="gender-img" src="../resources/images/survey/couple_img.png">
						<br><input type="radio" name="love" value="couple">연애중
					</label>
				</div><br><br><br><br><br><br><br><br><br>
				<div class="half-area" align="center">
					<label>
						<img class="gender-img" src="../resources/images/survey/married_img.png">
						<br><input type="radio" name="love" value="married">결혼
					</label>
				</div>
				<div class="half-area" align="center">
					<label>
						<img class="gender-img" src="../resources/images/survey/family_img.png">
						<br><input type="radio" name="love" value="family">자녀있음
					</label>
				</div>
				<br><br><br><br><br><br><br><br><br><br><br>
			</div>
			<div>
				<h3>취미가 무엇인가요?</h3><br><br>
				<div class="tripple-area" align="center">
					<label>
						<img class="gender-img" src="../resources/images/survey/hobby_art.png">
						<br><input type="radio" name="hobby" value="art">미술
					</label>
				</div>
				<div class="tripple-area" align="center">
					<label>
						<img class="gender-img" src="../resources/images/survey/hobby_beauty.png">
						<br><input type="radio" name="hobby" value="beauty">뷰티
					</label>
				</div>
				<div class="tripple-area" align="center">
					<label>
						<img class="gender-img" src="../resources/images/survey/hobby_camping.png">
						<br><input type="radio" name="hobby" value="camping">캠핑
					</label>
				</div><br><br><br><br><br><br><br><br><br>
				<div class="tripple-area" align="center">
					<label>
						<img class="gender-img" src="../resources/images/survey/hobby_cook.png">
						<br><input type="radio" name="hobby" value="cook">요리
					</label>
				</div>
				<div class="tripple-area" align="center">
					<label>
						<img class="gender-img" src="../resources/images/survey/hobby_driving.png">
						<br><input type="radio" name="hobby" value="drive">운전
					</label>
				</div>
				<div class="tripple-area" align="center">
					<label>
						<img class="gender-img" src="../resources/images/survey/hobby_game.png">
						<br><input type="radio" name="hobby" value="game">게임
					</label>
				</div><br><br><br><br><br><br><br><br><br>
				<div class="tripple-area" align="center">
					<label>
						<img class="gender-img" src="../resources/images/survey/hobby_movie.png">
						<br><input type="radio" name="hobby" value="movie">영화
					</label>
				</div>
				<div class="tripple-area" align="center">
					<label>
						<img class="gender-img" src="../resources/images/survey/hobby_music.png">
						<br><input type="radio" name="hobby" value="music">음악
					</label>
				</div>
				<div class="tripple-area" align="center">
					<label>
						<img class="gender-img" src="../resources/images/survey/hobby_picture.png">
						<br><input type="radio" name="hobby" value="picture">사진
					</label>
				</div><br><br><br><br><br><br><br><br><br>
				<div class="tripple-area" align="center">
					<label>
						<img class="gender-img" src="../resources/images/survey/hobby_shopping.png">
						<br><input type="radio" name="hobby" value="shopping">쇼핑
					</label>
				</div><br><br><br><br><br><br><br><br><br>
			</div>
			<div>
				<h3>아직 질문 미정</h3>
			</div>
			<div>
				<h3>좋아하는 저자가 있나요?</h3>
			</div>
			</form>
		</div>
		
		<div class="col-md-3">여기는 사이드바</div>
	</div>
</body>
</html>