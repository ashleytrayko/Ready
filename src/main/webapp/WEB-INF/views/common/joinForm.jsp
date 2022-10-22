<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>	
<%@ include file="../main/header.jsp" %>

<div class="card container col-md-4">
	<form method="post" action="/join">
		<div class="form-group">
			<label for="userId">아이디</label> 
			<input type="text" class="form-control" placeholder="?자 이내, 특수문자 ㄴ" id="userId" name="userId">
		</div>
		<div class="form-group">
			<label for="userPassword">패스워드 </label> 
			<input type="password" class="form-control" placeholder="Enter Password" id="userPassword" name="userPassword">
		</div>
		<div class="form-group">
			<label for="userPassword">패스워드 확인 </label> 
			<input type="password" class="form-control" placeholder="Enter password" id="userPasswordCheck">
		</div>
		<div class="form-group">
			<label for="userName">성명 </label> 
			<input type="text" class="form-control" placeholder="Enter Name" id="userName" name="userName">
		</div>
		<div class="form-group">
			<label for="userEmail">이메일 </label> 
			<input type="email" class="form-control" placeholder="Enter Email" id="userEmail" name="userEmail">
		</div>
			<label for="userPostcode">우편번호 </label> 
		<div class="input-group col-md-5">
			<input type="text" class="form-control" placeholder="Enter Postcode" id="userPostcode" name="userPostcode">
			
			<button type="button" class="btn btn-outline-secondary" onclick="addrSearch()">주소검색</button>
		</div>
		<div class="form-group">
			<label for="userAddress">주소 </label> 
			<input type="text" class="form-control" placeholder="Enter Address" id="userAddress" name="userAddress">
		</div>
		<div class="form-group">
			<label for="userDetailAddress">상세주소 </label> 
			<input type="text" class="form-control" placeholder="Enter Detail" id="userDetailAddress" name="userDetailAddress">
		</div>
		<div class="form-group">
			<label for="userPhone">전화번호 </label> 
			<input type="text" class="form-control" placeholder="Enter Phone" id="userPhone" name="userPhone">
		</div>
		<div class="form-group">
			<label for="userNickname">닉네임 </label> 
			<input type="text" class="form-control" placeholder="Enter Nickname" id="userNickname" name="userNickname">
		</div>
		<div class="form-group">
			<label for="userBirthday">생일 </label> 
			<input type="date" class="form-control" placeholder="Enter Nickname" id="userBirthday" name="userBirthday">
		</div>
		<button type="submit" class="btn btn-primary">회원가입</button>
	</form>
	</div>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
    function addrSearch(){
        new daum.Postcode({
            oncomplete: function(data) {
               document.querySelector('#userPostcode').value = data.zonecode;
               document.querySelector('#userAddress').value = data.roadAddress;

               document.querySelector("#userDetailAddress").focus();
           }
        }).open();

    }
	</script>
</body>
</html>