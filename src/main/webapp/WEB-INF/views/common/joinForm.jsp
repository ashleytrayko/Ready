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
			<label for="id">Id:</label> 
			<input type="text" class="form-control" placeholder="Enter id" id="id" name="id">
		</div>
		<div class="form-group">
			<label for="password">Password:</label> 
			<input type="password" class="form-control" placeholder="Enter password" id="password" name="password">
		</div>
		<div class="form-group">
			<label for="password">Name:</label> 
			<input type="text" class="form-control" placeholder="Enter name" id="name" name="name">
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
	</div>
</body>
</html>