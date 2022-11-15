<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 공지등록</title>
<link rel="icon" type="image/png"  href="/resources/images/favicon.ico"/>
<!-- 타이틀 밑에 아래 css링크 추가해줄것 -->
<link rel="stylesheet" href="/resources/css/main/mainHeader.css">
<link rel="stylesheet" href="/resources/css/que/queWriteForm.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- 서머노트를 위해 추가해야할 부분 -->
  <script src="/resources/js/summernote-lite.js"></script>
  <script src="/resources/js/lang/summernote-ko-KR.js"></script>
  <link rel="stylesheet" href="/resources/css/summernote-lite.css">
  <!--  -->

</head>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>
    <div class="main-contents">
		<div class="main-sidebar">
		
		</div>
		<div class="main-section">
		<h1 align="center">FAQ 등록</h1>
		<form action="/que/registerAdmin.kh" method="post" enctype="multipart/form-data">
			<table align="center" border="1">
				<tr>
					<td class="td">제목</td>
					<td colspan="2"><input type="text" class="qTitle" name="queTitle"></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="queWriter" value="${principal.user.userNickname }" readonly class="qTitle"></td>
					<input type="hidden" name="queId" value="${principal.user.userId }" readonly class="qTitle">
					<td align="right" id="select-td">
						<div class="input-group">
							<select name="qCategory" class="input-group-text" id="inputGroup-sizing-sm" required>
								<option disabled value="" selected>문의유형</option>
								<option value="user" <c:if test="${searchCondition eq 'user' }">selected</c:if>>회원정보</option>
								<option value="item" <c:if test="${searchCondition eq 'item' }">selected</c:if>>상품관련</option>
								<option value="delivery" <c:if test="${searchCondition eq 'delivery' }">selected</c:if>>배송관련</option>
								<option value="order" <c:if test="${searchCondition eq 'order' }">selected</c:if>>교환/환불</option>
								<option value="etc" <c:if test="${searchCondition eq 'etc' }">selected</c:if>>기타문의</option>
							</select>
						</div>
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td colspan="2">
						<textarea class="summernote" name="queContents"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="3" align="right">
						<button type="button" onclick="goList();">취소</button>
						<button>등록</button>
					</td>
				</tr>
			</table>
		</form>
		
		
		
		</div>
		<div class="main-sidebar"></div>
    </div>
	<footer>
		
	</footer>
	<script>
		$('.summernote').summernote({
			  height: 150,
			  width: 600,
			  lang: "ko-KR"
		});
		function goList() {
			location.href="/que/faq01.kh";
		}
	</script>
</body>
</html>