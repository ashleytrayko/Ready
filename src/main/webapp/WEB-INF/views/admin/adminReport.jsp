<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ include file="../main/header.jsp"%>

<div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style="width: 280px;">
	<a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none"> <span class="fs-4">Admin Page</span>
	</a>
	<hr>
	<ul class="nav nav-pills flex-column mb-auto">
		<li class="nav-item">
		<a href="/admin" class="nav-link active" aria-current="page"> Admin Home </a></li>
		<li><a href="/admin/admin-notice" class="nav-link text-white"> 공지사항 </a></li>
		<li><a href="/admin/admin-banner" class="nav-link text-white"> 배너관리  </a></li>
		<li><a href="/admin/admin-report" class="nav-link text-white"> 신고관리  </a></li>
		<li><a href="/admin/admin-product" class="nav-link text-white"> 상품관리  </a></li>
		<li><a href="/admin/admin-order" class="nav-link text-white"> 주문관리  </a></li>
		<li><a href="/admin/admin-qna" class="nav-link text-white"> Q&A관리  </a></li>
	</ul>
	<hr>
	<div class="dropdown">
		<a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false"> <img
			src="https://github.com/mdo.png" alt="" width="32" height="32" class="rounded-circle me-2"> <strong>Admin</strong>
		</a>
		<ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
			<li><a class="dropdown-item" href="#">New project...</a></li>
			<li><a class="dropdown-item" href="#">Settings</a></li>
			<li><a class="dropdown-item" href="#">Profile</a></li>
			<li><hr class="dropdown-divider"></li>
			<li><a class="dropdown-item" href="#">Sign out</a></li>
		</ul>
	</div>
</div>
</body>
</html>