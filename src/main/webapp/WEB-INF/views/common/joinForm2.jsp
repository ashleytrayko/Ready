<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>	
<%@ include file="../main/header.jsp" %>

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
	<form method="post" action="/joinTest">
		<div class="form-group">
			<label for="userId">아이디</label> 
			<input type="text" class="form-control" placeholder="4~20자 이내, 한글, 특수문자(-, _)외 사용불가" id="userId" name="userId">
			<span class="guide ok id">이 아이디는 사용 가능합니다.</span> 
			<span class="guide error id" id="idCheck">이 아이디는 사용 할 수 없습니다.</span>
			<span class="guide error reg" id="regIdCheck">사용 할 수 없는 문자가 포함되었습니다.</span>
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
			<span class="guide error pwdCheck" id="pwdCheck">패스워드가 일치하지 않습니다.</span>
		</div>
		<div class="form-group">
			<label for="userName">성명 </label> 
			<input type="text" class="form-control" placeholder="이름을 입력해주세요" id="userName" name="userName">
			<span class="guide error name" id="nameCheck">사용 할 수 없는 문자가 포함되었습니다.</span>
		</div>
					<label for="userEmail">이메일 </label> 
		<div class="input-group col-md-5">
			<input type="email" class="form-control" placeholder="이메일을 입력해주세요" id="userEmail" name="userEmail">
			<button type="button" class="btn btn-outline-secondary" id="email_auth">이메일 인증</button>
		</div>
			<span class="guide ok mail">인증번호가 발송되었습니다. 이메일을 확인해주세요.</span> 
			<span class="guide error mail" id="mailFail">이미 등록된 이메일입니다.</span>
		<div class="form-group">
			<label for="userEmail">인증번호 확인</label> 
			<input type="text" class="form-control" placeholder="확인 코드 입력" name="userEmailCheck" id="userEmailCheck">
			<span class="guide ok mailCheck">인증번호가 일치합니다.</span> 
			<span class="guide error mailCheck" id="mailCheck">인증번호가 일치하지 않습니다.</span>
		</div>
			<label for="userPostcode">우편번호 </label> 
		<div class="input-group col-md-5">
			<input type="text" class="form-control" placeholder="주소를 검색해주세요" id="userPostcode" name="userPostcode">
			<button type="button" class="btn btn-outline-secondary" onclick="addrSearch()">주소검색</button>
		</div>
		<div class="form-group">
			<label for="userAddress">주소 </label> 
			<input type="text" class="form-control" placeholder="자동 입력 됩니다" id="userAddress" name="userAddress">
		</div>
		<div class="form-group">
			<label for="userDetailAddress">상세주소 </label> 
			<input type="text" class="form-control" placeholder="상세주소를 입력해주세요" id="userDetailAddress" name="userDetailAddress">
		</div>
		<div class="form-group">
			<label for="userPhone">전화번호 </label> 
			<input type="text" class="form-control" placeholder="-없이 숫자만 입력해주세요" id="userPhone" name="userPhone">
			<span class="guide error phone" id="phoneCheck">사용 할 수 없는 문자가 포함되었습니다.</span>
		</div>
		<div class="form-group">
			<label for="userNickname">닉네임 </label> 
			<input type="text" class="form-control" placeholder="닉네임을 입력해주세요" id="userNickname" name="userNickname">
			<span class="guide ok nicknameCheck">사용가능한 닉네임입니다.</span> 
			<span class="guide error nicknameCheck" id="nicknameCheck">이미 닉네임이 사용중입니다.</span>
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
	
	$("#submit").on("click",function(){
		const userId = $("#userId").val();
		const userPassword = $("#userPassword").val();
		const userPasswordCheck = $("#userPasswordCheck").val();
		const userName = $('#userName').val();
		const userEmail = $("#userEmail").val();
		const userEmailCheck = $("#userEmailCheck").val();
		const userPostcode = $("#userPostcode").val();
		const userAddress = $("#userAddress").val();
		const userDetailAddress = $("#userDetailAddress").val();
		const userPhone = $("#userPhone").val();
		const userNickname = $("#userNickname").val();
		const userBirthday = $("#userBirthday").val();
		
		if(userId === ''){
			console.log("아이디 입력해주세요");
			return false;
		}else if(userPassword === ''){
			console.log("비밀번호 입력해주세요");
			return false;
		}else if(userPasswordCheck === ''){
			console.log("비밀번호 확인 해주세요");
			return false;
		}else if(userName === ''){
			console.log("이름 입력 해주세요");
			return false;
		}else if(userEmail === ''){
			console.log("이메일 입력 해주세요");
			return false;
		}else if(userEmailCheck === ''){
			console.log("메일 확인 문자 입력 해주세요");
			return false;
		}else if(userPostcode === '' || userAddress === '' || userDetailAddress === ''){
			console.log("주소 입력 해주세요");
			return false;
		}else if(userPhone === ''){
			console.log("전화번호 입력 해주세요");
			return false;
		}else if(userNickname === ''){
			console.log("닉네임 입력 해주세요");
			return false;
		}else if(userBirthday === ''){
			console.log("생일 입력 해주세요");
			return false;
		}else if($("#idCheck").css("display","block")){
			console.log('사용불가 아이디')
			return false;
		}
		return true;
	});
	
	// 전화번호 확인 -> 정규식 추가
	$("#userPhone").keyup(function(e){
		let inputPhone = e.target.value;
		const regPhone = RegExp(/^[0-9]{10,11}+$/);
		if(inputPhone !== ""){
			$(".error.phone").css("display","none");
			if(!regPhone.test(inputPhone)){
				$(".error.phone").css("display","block");
			}
		}else{
			$(".error.phone").css("display","none");
		}
	
	});
	
	
	// 인증메일 발송
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
	
	// 이름 확인 -> 정규식 추가
	$("#userName").keyup(function(e){
		let inputName = e.target.value;
		const regName = RegExp(/^[가-힣a-zA-Z]+$/);
		if(inputName !== ""){
			$(".error.name").css("display","none");
			if(!regName.test(inputName)){
				$(".error.name").css("display","block");
			}
		}else{
			$(".error.name").css("display","none");
		}
	
	});
	
	// 패스워드 확인 -> 정규식 추가
	$("#userPassword").keyup(function(e){
		let inputPwd = e.target.value;
		const regPwd = RegExp(/(?=.*\d)(?=.*[a-zA-ZS]).{8,}/);
		if(inputPwd !== ""){
			$(".ok.pwd").css("display","none");
			$(".error.pwd").css("display","none");
			if(!regPwd.test(inputPwd)){
				$(".error.pwd").css("display","block");
			}else{
				$(".ok.pwd").css("display","block");
			}
		}else{
			$(".ok.pwd").css("display","none");
			$(".error.pwd").css("display","none");
		}
	
	});
	
	// 패스워드 확인 -> 정규식 추가
	$("#userPasswordCheck").keyup(function(e){
		let checkPwd = e.target.value;
		const pwd = $("#userPassword").val();
		if(checkPwd !== ""){
			$(".ok.pwdCheck").css("display","none");
			$(".error.pwdCheck").css("display","none");
			if(checkPwd !== pwd){
				$(".error.pwdCheck").css("display","block");
			}else if(checkPwd === pwd){
				$(".ok.pwdCheck").css("display","block");
			}
		}else{
			$(".ok.pwdCheck").css("display","none");
			$(".error.pwdCheck").css("display","none");
		}
	
	});
	
	// 아이디 중복확인 -> 완료 , 정규식 추가
	$("#userId").keyup(function(e){
		let checkId = e.target.value;
		const reg_id = RegExp(/^[a-zA-Z0-9_-]{4,20}$/);
		if(checkId !== ""){
			$(".ok.id").css("display","none");
			$(".error.id").css("display","none");
			$(".error.reg").css("display","none");
			if(reg_id.test(checkId)){
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
							$(".ok.id").css("display","none");
							$(".error.id").css("display","block");
						}
					},
					error : function(){
						alert("서버 통신 에러!");
					}
				});	
			}else{
				$(".error.reg").css("display",'block');
			}
		}else if(checkId === "") {
			$(".ok.id").css("display","none");
			$(".error.id").css("display",'none');
			$(".error.reg").css("display","none");
		}
	});
	
	// 닉네임 중복확인 -> 완료 , 정규식 추가
	$("#userNickname").keyup(function(e){
		let checkNickname = e.target.value;
		if(checkNickname !== ""){
			$(".ok.nicknameCheck").css("display","none");
			$(".error.nicknameCheck").css("display","none");
			$.ajax({
				url : "/checkNickname",
				data : {
					"userNickname" : checkNickname
				},
				type : "get",
				success : function(result){
					if(result == "itsOk"){
						$(".ok.nicknameCheck").css("display","block");
					}else{
						$(".error.nicknameCheck").css("display","block");
					}
				},
				error : function(){
					alert("서버 통신 에러!");
				}
			})
		}else{
			$(".ok.nicknameCheck").css("display","none");
			$(".error.nicknameCheck").css("display",'none');
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