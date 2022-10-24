<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container" style="margin-top: 10%">
<div class="container col-lg-5">
	<h2>Read'y 비밀번호 찾기 </h2>
	<h4>가입할때 입력하셨던 정보를 확인할게요</h4>
</div>
	<div class="card container col-lg-5 mt-5 p-5">
		<form method="post" action="/forget-password">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<div class="form-group">
				<input type="text" class="form-control" placeholder="회원님의 아이디를 입력해주세요." id="userId" name="userId">
			</div>
			<div class="form-group">
				<input type="email" class="form-control" placeholder="가입시 등록하신 이메일을 입력해주세요." id="userEmail"name="userEmail">
			</div>
			<button type="submit" class="btn btn-primary col-lg">비밀번호 찾기</button>
		</form>
	</div>
	</div>
</body>
</html>