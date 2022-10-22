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
<div class="container">
	<form method="post" action="/join">
		<div class="form-group">
			<label for="userId">Id:</label> 
			<input type="text" class="form-control" placeholder="Enter ID" id="userId" name="userId">
		</div>
		<div class="form-group">
			<label for="userPassword">Password:</label> 
			<input type="password" class="form-control" placeholder="Enter Password" id="userPassword" name="userPassword">
		</div>
		<!-- <div class="form-group">
			<label for="userPassword">Password - check:</label> 
			<input type="password" class="form-control" placeholder="Enter password" id="userPassword" name="userPassword">
		</div> -->
		<div class="form-group">
			<label for="userName">Name:</label> 
			<input type="text" class="form-control" placeholder="Enter Name" id="userName" name="userName">
		</div>
		<div class="form-group">
			<label for="userEmail">Email:</label> 
			<input type="email" class="form-control" placeholder="Enter Email" id="userEmail" name="userEmail">
		</div>
		<div class="form-group">
			<label for="userPostcode">Postcode:</label> 
			<input type="text" class="form-control" placeholder="Enter Postcode" id="userPostcode" name="userPostcode">
		</div>
		<div class="form-group">
			<label for="userAddress">Address:</label> 
			<input type="text" class="form-control" placeholder="Enter Address" id="userAddress" name="userAddress">
		</div>
		<div class="form-group">
			<label for="userDetailAddress">Detail:</label> 
			<input type="text" class="form-control" placeholder="Enter Detail" id="userDetailAddress" name="userDetailAddress">
		</div>
		<div class="form-group">
			<label for="userPhone">Phone:</label> 
			<input type="text" class="form-control" placeholder="Enter Phone" id="userPhone" name="userPhone">
		</div>
		<div class="form-group">
			<label for="userNickname">Nickname:</label> 
			<input type="text" class="form-control" placeholder="Enter Nickname" id="userNickname" name="userNickname">
		</div>
		<div class="form-group">
			<label for="userBirthday">Birthday:</label> 
			<input type="date" class="form-control" placeholder="Enter Nickname" id="userBirthday" name="userBirthday">
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
	</div>
</body>
</html>