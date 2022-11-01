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
	<jsp:include page="../main/header.jsp"></jsp:include>
	<link rel="stylesheet" href="/resources/css/main/mainHeader.css">
</head>
<body>
	<div class="main-contents">
		<div class="col-md-3">
      		<jsp:include page="../main/mypageSideBar.jsp"></jsp:include>
		</div>
		<div class="main-section">
			<table class="table table-hover">
				<tr>
					<th>성별</th>
					<th>연애여부</th>
					<th>취미</th>
					<th>목적</th>
					<th>선호 작가</th>
					<th>등록일</th>
				</tr>
				<c:if test = "${!empty survey}">
					<tr>
						<td>${survey.answerGender }</td>
						<td>${survey.answerLove }</td>
						<td>${survey.answerHobby }</td>
						<td>${survey.answerReason }</td>
						<td>${survey.answerWriter }</td>
						<td>${survey.updateDate }</td>
					</tr>
					<tr>
						<td colspan="6" align="center">
							<button type="button" class="btn btn-outline-secondary" onclick="modifySurvey()">수정하기</button>
						</td>
					</tr>
				</c:if>
				<c:if test= "${empty survey }">
						<td colspan="6" align="center">등록된 설문지가 없습니다.</td>
					<tr>
						<td colspan="6" align="center">
							<button type="button" class="btn btn-outline-secondary" onclick="registSurvey()">등록하기</button>
						</td>
					</tr>
				</c:if>
			</table>
		</div>
		<div class="col-md=3">sideBar
		</div>
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