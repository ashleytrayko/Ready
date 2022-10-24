<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
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
<div class="container" style="margin-top: 10%">
	<div class="container col-lg-5 mb-5">
		<h2>Read'y 로그인</h2>
		<h4>로그인해서 나에게 맞는 책을 추천받으세요.</h4>
	</div>
	<div class="card container col-lg-5 mt-5">
		<form method="post" action="/login">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<div class="form-group">
				<label for="userId">id:</label> <input type="text" class="form-control" placeholder="Enter id" id="userId" name="userId">
			</div>
			<div class="form-group">
				<label for="userPassword">Password:</label> <input type="password" class="form-control" placeholder="Enter password" id="userPassword" name="userPassword">
				<span class="error pwd">CapsLock이 켜져 있습니다.</span>
			</div>
			<div class="form-group form-check">
				<label class="form-check-label"> <input class="form-check-input" type="checkbox"> Remember me
				</label>
			</div>
			<button type="submit" class="btn btn-primary col-lg">로그인</button>
		</form>
		<hr>
		<ul class="nav d-flex justify-content-center">
			<li class="nav-item"><a class="nav-link" href="/forget-id">아이디 찾기</a></li>
			<li class="nav-item"><a class="nav-link" href="/forget-password">비밀번호 찾기 </a></li>
			<li class="nav-item"><a class="nav-link" href="/join">회원가입</a></li>
		</ul>
	</div>
	</div>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script>
		$("#userPassword").on("focus",function(e){
			if(e.getModifierState("CapsLock")){
				$(".error pwd").css("display","block");
			}
		})
	</script>
</body>
</html>