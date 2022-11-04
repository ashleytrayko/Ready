<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<!-- 타이틀 밑에 아래 css링크 추가해줄것 -->
<link rel="stylesheet" href="/resources/css/main/mainHeader.css">
<link rel="stylesheet" href="/resources/css/que/faqList.css">
<link rel="stylesheet" href="/resources/css/que/faqTest.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>
    <div class="main-contents">
		<div class="main-sidebar">여기는 사이드바</div>
		<div class="main-section">
		<!-- 이 안에서 작업! 여기가 본문-->
			
			
			<h1 align="center">고객센터 FAQ</h1>
			<section id="wrapper">
			<div class="container">
				<div class="category-box">
						<div class="faq-category" colspan="2">회원정보</div>
						<div class="faq-category" colspan="2">배송관련</div>
						<div class="faq-category" colspan="2">상품관련</div>
						<div class="faq-category" colspan="2">교환/환불</div>
				</div>
			   <ul class="accordion">
				<c:if test="${!empty qList }">
					<c:forEach items="${qList }" var="question" varStatus="i">
			      <li class="item">
			         <h2 class="accordionTitle">${question.queTitle } <span class="accIcon"></span></h2>
			         <div class="text">${question.queContents }</div>
			      </li>
					</c:forEach>
				</c:if>
			      <!-- <li class="item">
			         <h2 class="accordionTitle">Paris <span class="accIcon"></span></h2>
			         <div class="text">Paris is the capital and most populous city of France, with an area of 105 square kilometres (41 square miles) and a population of 2,206,488. Since the 17th century, Paris has been one of Europe's major centres of finance, commerce, fashion, science, and the arts.</div>
			      </li>
			      <li class="item">
			         <h2 class="accordionTitle">Barcelona <span class="accIcon"></span></h2>
			         <div class="text">Barcelona is a city in Spain. It is the capital and largest city of Catalonia, as well as the second most populous municipality of Spain. With a population of 1.6 million within city limits, its urban area extends to numerous neighbouring municipalities within the Province of Barcelona and is home to around 4.8 million people.</div>
			      </li>
			      <li class="item">
			         <h2 class="accordionTitle">Milan <span class="accIcon"></span></h2>
			         <div class="text">Milan is a city in northern Italy, capital of Lombardy, and the second-most populous city in Italy after Rome, with the city proper having a population of 1,372,810 while its metropolitan area has a population of 3,242,820.</div>
			      </li> -->
			   </ul>
				<button onclick="location.href='/que/myList.kh'">내 문의글</button>
				<button onclick="location.href='/que/viewWrite.kh'">글쓰기</button>
			</div>
			</section>
		</div>
		<div class="main-sidebar">여기는 사이드바</div>
    </div>
	<footer>
		
	</footer>
	<script>
	var accordionBtn = document.querySelectorAll('.accordionTitle');
	var allTexts = document.querySelectorAll('.text');
	var accIcon = document.querySelectorAll('.accIcon');

	// event listener
	accordionBtn.forEach(function (el) {
	    el.addEventListener('click', toggleAccordion)
	});

	// function
	function toggleAccordion(el) {
	   var targetText = el.currentTarget.nextElementSibling.classList;
	   var targetAccIcon = el.currentTarget.children[0];
	   var target = el.currentTarget;
	   
	   if (targetText.contains('show')) {
	       targetText.remove('show');
	       targetAccIcon.classList.remove('anime');
	       target.classList.remove('accordionTitleActive');
	   } 
	   else {
	      accordionBtn.forEach(function (el) {
	         el.classList.remove('accordionTitleActive');
	         
	         allTexts.forEach(function (el) {
	            el.classList.remove('show');
	         })
	         
	         accIcon.forEach(function (el) {
	          el.classList.remove('anime');
	         }) 
	         
	      })
	      
	         targetText.add('show');
	         target.classList.add('accordionTitleActive');
	         targetAccIcon.classList.add('anime');
	   }  
	}
	</script>
</body>
</html>