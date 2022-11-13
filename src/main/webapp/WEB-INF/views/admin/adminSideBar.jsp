<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/resources/css/main/adminSideBar.css" rel="stylesheet">
</head>
<body>
	<a href="/admin">
		<img src="/resources/images/ready_black_04.png" width="250" height="180">
	</a>
			<div class="flex-shrink-0 p-3 bg-white" style="width: 280px;">
    			<ul class="list-unstyled ps-0">
	      			<li class="mb-1">
	        			<a href="/admin/admin-notice">
		        			<button class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed" data-bs-toggle="collapse" data-bs-target="#home-collapse" aria-expanded="true">
		          				공지사항
		        			</button>
	        			</a>
	      			</li>
		      		<li class="mb-1">
		      			<a href="/admin/admin-banner">
		        		<button class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed" data-bs-toggle="collapse" data-bs-target="#dashboard-collapse" aria-expanded="false">
		          			배너관리
		        		</button>
		        		</a>
		     	 	</li>
		      		<li class="mb-1">
		      		<a href="/admin/admin-report">
				        <button class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed" data-bs-toggle="collapse" data-bs-target="#orders-collapse" aria-expanded="false">
				          신고관리
				        </button>
				        </a>
		      		</li>
		      		<li class="mb-1">
		      		<a href="/admin/admin-product">
	        			<button class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed" data-bs-toggle="collapse" data-bs-target="#home-collapse" aria-expanded="true">
	          				상품관리
	        			</button>
	        			</a>
	      			</li>
	      			<li class="mb-1">
	      			<a href="/admin/admin-qna">
	        			<button class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed" data-bs-toggle="collapse" data-bs-target="#home-collapse" aria-expanded="true">
	          				Q&A관리
	        			</button>
	        			</a>
	      			</li>
    			</ul>
  			</div>
</body>
</html>