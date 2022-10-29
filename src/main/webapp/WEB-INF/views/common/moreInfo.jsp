<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>	
<%@ include file="../main/header.jsp" %>
<sec:authorize access="isAuthenticated()">
   <sec:authentication property="principal" var="principal" />
</sec:authorize>
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

<div class="card container col-md-4">
	<form method="post" action="/join">
		<input type="hidden" value="${principal.user.userId }" id="userId" name="userId">
		<input type="hidden" value="${principal.user.userPassword }" id="userPassword" name="userPassword">
		<input type="hidden" value="${principal.user.userName }" id="userName" name="userName">
		<input type="hidden" value="${principal.user.userEmail }" id="userEmail" name="userEmail">
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
		<button type="submit" class="btn btn-primary" id="submit">회원가입</button>
	</form>
	</div>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script>
	
	
	let userEmailAuth = "";
	
	$("#email_auth").click(function(){
		const userEmail = $("#userEmail").val();
		
		if(userEmail === '' ){
			alert("이메일을 입력해주세요.");
			return false;
		}
		
		$.ajax({
			type : "POST",
			url : "/emailCheck",
			data : {userEmail : userEmail},
			success : function(data){
				if(data == 'exist'){
					$(".error.mail").css("display","block");
					return false;
				}else{
					$(".ok.mail").css("display","block");
					userEmailAuth = data;
				}
			},
			error : function(data){
				alert('메일 발송에 실패했습니다.')
			}
		});
	});
	
	// 메일 인증번호 확인 -> 정규식 추가
	$("#userEmailCheck").keyup(function(e){
		let checkMailAuth = e.target.value;
		if(checkMailAuth !== ""){
			$(".ok.mailCheck").css("display","none");
			$(".error.mailCheck").css("display","none");
			if(checkMailAuth !== userEmailAuth){
				$(".error.mailCheck").css("display","block");
			}else if(checkMailAuth === userEmailAuth){
				$(".ok.mailCheck").css("display","block");
			}
		}else{
			$(".ok.mailCheck").css("display","none");
			$(".error.mailCheck").css("display","none");
		}
	
	});
	
	// 패스워드 확인 -> 정규식 추가
	$("#userPasswordCheck").keyup(function(e){
		let checkPwd = e.target.value;
		const pwd = $("#userPassword").val();
		if(checkPwd !== ""){
			$(".ok.pwd").css("display","none");
			$(".error.pwd").css("display","none");
			if(checkPwd !== pwd){
				$(".error.pwd").css("display","block");
			}else if(checkPwd === pwd){
				$(".ok.pwd").css("display","block");
			}
		}else{
			$(".ok.pwd").css("display","none");
			$(".error.pwd").css("display","none");
		}
	
	});
	
	// 아이디 중복확인 -> 완료 , 정규식 추가
	$("#userId").keyup(function(e){
		let checkId = e.target.value;
		if(checkId !== ""){
			$(".ok.id").css("display","none");
			$(".erro.idr").css("display","none");
			$.ajax({
				url : "/checkId",
				data : {
					"userId" : checkId
				},
				type : "get",
				success : function(result){
					if(result == "itsOk"){
						$(".ok.id").css("display","block");
					}else{
						$(".error.id").css("display","block");
					}
				},
				error : function(){
					alert("서버 통신 에러!");
				}
			})
		}else{
			$(".ok.id").css("display","none");
			$(".error.id").css("display",'none');
		}
	})
	
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