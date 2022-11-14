<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="../resources/css/admin/button.css"/>
<link href='//spoqa.github.io/spoqa-han-sans/css/SpoqaHanSansNeo.css' rel='stylesheet' type='text/css'>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<style>
* { 
	font-family: 'Spoqa Han Sans Neo', 'sans-serif';
}

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
	<div class="card container col-lg-5 mt-5 p-5">
		<form method="post" action="/login">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<img src="../resources/images/READY-LOGO1.png" height="80px" style="margin: auto; display: block;">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="아이디" id="userId" name="userId">
			</div>
			<div class="form-group">
				<input type="password" class="form-control" placeholder="패스워드" id="userPassword" name="userPassword">
				<span class="guide error" id="capslock">CapsLock이 켜져 있습니다.</span>
			</div>
			<div class="form-group form-check">
				<label class="form-check-label"> 
				<input class="form-check-input" type="checkbox" name="remember-me" value="True"> Remember me
				</label>
			</div>
			<div class="btn-section1">
				<button type="submit" class="btn col-lg">로그인</button>
			</div>
		</form>
		<hr>
		<ul class="nav d-flex justify-content-center">
			<li class="nav-item"><a class="nav-link" href="/forget-id">아이디 찾기</a></li>
			<li class="nav-item"><a class="nav-link" href="/forget-password">비밀번호 찾기 </a></li>
			<li class="nav-item"><a class="nav-link" href="/join">회원가입</a></li>
		</ul>
		<hr>
		<ul class="nav d-flex justify-content-center">
			<li class="nav-item" >
				<a class="nav-link" href="/oauth2/authorization/google">
					<div style="width:60px; height:60px;">
						<img class="img-fluid" src="../resources/images/social/google.png" style="width:100%; height:100%; border-radius: 50%">
					</div>
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="/oauth2/authorization/naver">
					<div style="width:60px; height:60px;">
						<img class="img-fluid" src="../resources/images/social/naver.png" style="width:100%; height:100%; border-radius: 50%">
					</div>
				</a>
			</li>
			<li class="nav-item">
				<div style="width:92px; height:92px;">
					<a class="nav-link" href="/oauth2/authorization/kakao">
						<img class="img-fluid" src="../resources/images/social/Kakao.jpg" style="width:100%; height:100%;  border-radius: 50%">
					</a>
				</div>
			</li>
		</ul>
	</div>
	</div>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script>
		
	
		// 패스워드 입력필드
		const input = document.getElementById("userPassword");
		
		// 텍스트 필드
		const text = document.getElementById("capslock");

		input.addEventListener("keyup", function(event) {

		  if (event.getModifierState("CapsLock")) {
	  	  	text.style.display = "block";
		  } else {
			text.style.display = "none"
		  }
		});
	</script>
</body>
</html>