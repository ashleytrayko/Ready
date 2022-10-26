<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/resources/css/main/mypageSideBar.css" rel="stylesheet">
</head>
<body>
	<a href="/user/mypage.kh">
		<img src="/resources/images/ready_black_04.png" width="250" height="180">
	</a>
			<div class="flex-shrink-0 p-3 bg-white" style="width: 280px;">
    			<ul class="list-unstyled ps-0">
	      			<li class="mb-1">
	        			<button class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed" data-bs-toggle="collapse" data-bs-target="#home-collapse" aria-expanded="true">
	          				내 정보
	        			</button>
		        		<div class="collapse show" id="home-collapse">
		          			<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
		            			<li><a href="/mypage/survey.kh" class="link-dark d-inline-flex text-decoration-none rounded">설문조사</a></li>
		            			<li><a href="#" class="link-dark d-inline-flex text-decoration-none rounded">회원정보</a></li>
		            			<li><a href="#" class="link-dark d-inline-flex text-decoration-none rounded">회원탈퇴</a></li>
		          			</ul>
		        		</div>
	      			</li>
		      		<li class="mb-1">
		        		<button class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed" data-bs-toggle="collapse" data-bs-target="#dashboard-collapse" aria-expanded="false">
		          			나의 활동
		        		</button>
		        		<div class="collapse" id="dashboard-collapse">
		          			<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
					            <li><a href="#" class="link-dark d-inline-flex text-decoration-none rounded">주문 내역</a></li>
					            <li><a href="#" class="link-dark d-inline-flex text-decoration-none rounded">내가 쓴 글</a></li>
					            <li><a href="#" class="link-dark d-inline-flex text-decoration-none rounded">내 후기</a></li>
					            <li><a href="#" class="link-dark d-inline-flex text-decoration-none rounded">내 댓글</a></li>
							</ul>
		        		</div>
		     	 	</li>
		      		<li class="mb-1">
				        <button class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed" data-bs-toggle="collapse" data-bs-target="#orders-collapse" aria-expanded="false">
				          1:1 문의
				        </button>
		        		<div class="collapse" id="orders-collapse">
		          			<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
		            			<li><a href="#" class="link-dark d-inline-flex text-decoration-none rounded">내 문의글</a></li>
		            			<li><a href="#" class="link-dark d-inline-flex text-decoration-none rounded">문의글 작성</a></li>
		          			</ul>
		        		</div>
		      		</li>
		      		<li class="border-top my-3"></li>
		      		<li class="mb-1">
		        		<button class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed" data-bs-toggle="collapse" data-bs-target="#account-collapse" aria-expanded="false">
		          			Account
		        		</button>
		        		<div class="collapse" id="account-collapse">
		          			<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
		            			<li><a href="#" class="link-dark d-inline-flex text-decoration-none rounded">New...</a></li>
		            			<li><a href="#" class="link-dark d-inline-flex text-decoration-none rounded">Profile</a></li>
		            			<li><a href="#" class="link-dark d-inline-flex text-decoration-none rounded">Settings</a></li>
		            			<li><a href="#" class="link-dark d-inline-flex text-decoration-none rounded">Sign out</a></li>
		          			</ul>
		        		</div>
		      		</li>
    			</ul>
  			</div>
</body>
</html>