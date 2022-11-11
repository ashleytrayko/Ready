<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>설문조사 페이지</title>
	<style>
		.tb-section {
			width : 50%;
			margin-left : 8%;
		}
	</style>
	
	<jsp:include page="../main/header.jsp"></jsp:include>
	<link rel="stylesheet" href="/resources/css/main/mainHeader.css">
</head>
<body>
	<div class="main-contents">
		<div class="col-md-3">
      		<jsp:include page="../main/mypageSideBar.jsp"></jsp:include>
		</div>
		<div class="main-section">
			<h3>설문조사 현황</h3>
			<br><br><br><br>
			<div class="tb-section">
				<c:if test = "${!empty survey}">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th class="table-info">성별</th>
								<th class="table-info">연애여부</th>
								<th class="table-info">취미</th>
								<th class="table-info">목적</th>
								<th class="table-info">선호 작가</th>
								<th class="table-info">등록일</th>
							</tr>
						</thead>
							<tbody>
								<tr>
									<td>${survey.answerGender }</td>
									<td>${survey.answerLove }</td>
									<td>${survey.answerHobby }</td>
									<td>${survey.answerReason }</td>
									<td>${survey.answerWriter }</td>
									<td>${survey.updateDate }</td>
								</tr>
							</tbody>
					</table>
						<br><br><br>
						<div>
							<button type="button" class="btn btn-outline-secondary" onclick="modifySurvey()">수정하기</button>
						</div>
					</c:if>
					<c:if test= "${empty survey }">
						<h5>등록된 설문지가 없습니다.</h5>
						<div align="center">
							<button type="button" class="btn btn-outline-secondary" onclick="registSurvey()">등록하기</button>
						</div>
					</c:if>
			</div>
		</div>
		<div class="col-md=3">
		</div>
	</div>
	<div class="main-footer">
		<jsp:include page="../main/footer.jsp"></jsp:include>
	</div>
	
	<script>
		function registSurvey() {
			location.href="/mypage/survey.kh";
		}
		function modifySurvey() {
			location.href="/mypage/modifyForm.kh";
		}
	</script>
</body>
</html>