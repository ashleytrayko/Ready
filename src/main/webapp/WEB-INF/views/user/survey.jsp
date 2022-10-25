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
		<div class="col-md-3">여기는 사이드바</div>
		
		<div class="main-section">
			<h1>Read'y 설문조사</h1>
			<br><br><br><br><br><br><br>
			<form action="#" method="POST">
			<div>
				<h3>회원님의 성별을 알려주세요</h3><br><br>
				<div class="half-area" align="center">
					<img class="gender-img" src="../resources/images/survey/boy_img.png">
					<div>남자</div>
				</div>
				<div class="half-area" align="center">
					<img class="gender-img" src="../resources/images/survey/girl_img.png">
					<div>여자</div>
				</div>
				<br><br><br><br><br><br><br><br><br><br><br>
			</div>
			<div>
				<h3>연애중이시거나 결혼을 하셨나요?</h3><br><br>
				<div class="half-area" align="center">
					<img class="gender-img" src="../resources/images/survey/solo_img.png">
					<div>솔로</div>
				</div>
				<div class="half-area" align="center">
					<img class="gender-img" src="../resources/images/survey/couple_img.png">
					<div>연애중</div>
				</div><br><br><br><br><br><br><br><br><br>
				<div class="half-area" align="center">
					<img class="gender-img" src="../resources/images/survey/married_img.png">
					<div>결혼</div>
				</div>
				<div class="half-area" align="center">
					<img class="gender-img" src="../resources/images/survey/family_img.png">
					<div>자녀 있음</div>
				</div>
				<br><br><br><br><br><br><br><br><br><br><br>
			</div>
			<div>
				<h3>취미가 무엇인가요?</h3><br><br>
				<div class="tripple-area" align="center">
					<img class="gender-img" src="../resources/images/survey/hobby_art.png">
					<div>그림</div>
				</div>
				<div class="tripple-area" align="center">
					<img class="gender-img" src="../resources/images/survey/hobby_beauty.png">
					<div>뷰티</div>
				</div>
				<div class="tripple-area" align="center">
					<img class="gender-img" src="../resources/images/survey/hobby_camping.png">
					<div>캠핑</div>
				</div><br><br><br><br><br><br><br><br><br>
				<div class="tripple-area" align="center">
					<img class="gender-img" src="../resources/images/survey/hobby_cook.png">
					<div>요리</div>
				</div>
				<div class="tripple-area" align="center">
					<img class="gender-img" src="../resources/images/survey/hobby_driving.png">
					<div>운전</div>	
				</div>
				<div class="tripple-area" align="center">
					<img class="gender-img" src="../resources/images/survey/hobby_game.png">
					<div>게임</div>
				</div><br><br><br><br><br><br><br><br><br>
				<div class="tripple-area" align="center">
					<img class="gender-img" src="../resources/images/survey/hobby_movie.png">
					<div>영화</div>
				</div>
				<div class="tripple-area" align="center">
					<img class="gender-img" src="../resources/images/survey/hobby_music.png">
					<div>음악</div>
				</div>
				<div class="tripple-area" align="center">
					<img class="gender-img" src="../resources/images/survey/hobby_picture.png">
					<div>사진</div>
				</div><br><br><br><br><br><br><br><br><br>
				<div class="tripple-area" align="center">
					<img class="gender-img" src="../resources/images/survey/hobby_shopping.png">
					<div>쇼핑</div>
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