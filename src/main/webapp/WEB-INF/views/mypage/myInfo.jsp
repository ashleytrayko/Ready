<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<jsp:include page="../main/header.jsp"></jsp:include>
	<link rel="stylesheet" href="/resources/css/main/mainHeader.css">
	
	<style>
		span.guide {
			display: none;
			font-size: 12px;
			top: 12px;
			right: 10px;
		}

		span.ok {
			color: green;
		}

		span.error {
			color: red;
		}
	</style>
</head>
<body>
	<div class="main-contents">
		<div class="col-md-3">
      		<jsp:include page="../main/mypageSideBar.jsp"></jsp:include>
		</div>
		<div class="main-section">
			<h3>${principal.user.userName}의 회원정보</h3>
			<div class="card container col-md-6">
				<form method="post" action="/mypage/modifyUser.kh">
					<div class="form-group">
						<label for="userId">아이디</label> 
						<input type="text" class="form-control" id="userId" name="userId" value="${principal.user.userId }" readonly>
					</div>
					<div class="form-group">
						<label for="userPassword">패스워드 </label> 
						<input type="password" class="form-control" placeholder="문자, 숫자 1개 이상 포함, 8자리 이상" id="userPassword" name="userPassword">
						<span class="guide ok pwd">사용가능한 패스워드입니다.</span> 
						<span class="guide error pwd" id="pwdCheck">규칙에 맞게 패스워드를 설정해주세요.</span>
					</div>
					<div class="form-group">
						<label for="userPassword">패스워드 확인 </label> 
						<input type="password" class="form-control" placeholder="비밀번호 재입력" id="userPasswordCheck">
						<span class="guide ok pwdCheck">패스워드가 일치합니다.</span> 
						<span class="guide error pwdCheck" id="pwdCheckCheck">패스워드가 일치하지 않습니다.</span>
					</div>
					<div class="form-group">
						<label for="userName">성명 </label> 
						<input type="text" class="form-control" id="userName" name="userName" value="${principal.user.userName }" readonly>
					</div>
					<label for="userEmail">이메일 </label> 
					<div class="input-group col-md-5">
						<input type="email" class="form-control" id="userEmail" name="userEmail" value="${principal.user.userEmail }" readonly>
					</div>
					<label for="userPostcode">우편번호 </label> 
					<div class="input-group col-md-5">
						<input type="text" class="form-control"  id="userPostcode" name="userPostcode" value="${principal.user.userPostcode }">
						<button type="button" class="btn btn-outline-secondary" onclick="addrSearch()">주소검색</button>
					</div>
					<div class="form-group">
						<label for="userAddress">주소 </label> 
						<input type="text" class="form-control" id="userAddress" name="userAddress" value="${principal.user.userAddress }">
					</div>
					<div class="form-group">
						<label for="userDetailAddress">상세주소 </label> 
						<input type="text" class="form-control" id="userDetailAddress" name="userDetailAddress" value="${principal.user.userDetailAddress }">
					</div>
					<div class="form-group">
						<label for="userPhone">전화번호 </label> 
						<input type="text" class="form-control" id="userPhone" name="userPhone" value="${principal.user.userPhone }">
						<span class="guide error phone" id="phoneCheck">사용 할 수 없는 문자가 포함되었습니다.</span>
					</div>
					<div class="form-group">
						<label for="userNickname">닉네임 </label> 
						<input type="text" class="form-control" id="userNickname" name="userNickname" value="${principal.user.userNickname }">
						<span class="guide ok nicknameCheck">사용가능한 닉네임입니다.</span> 
						<span class="guide error nicknameCheck" id="nicknameCheck">이미 닉네임이 사용중입니다.</span>
						<span class="guide error regNickname" id="regNickname">사용할 수 없는 단어가 포함되어 있습니다.</span>
					</div>
					<button type="submit" class="btn btn-primary col-md-12 mt-3" id="submit">회원정보 수정</button>
				</form>
			</div>
		</div>
		<div class="col-md=3">sideBar
		</div>
	</div>
</body>
</html>