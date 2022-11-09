<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공용jsp틀</title>
<!-- 타이틀 밑에 아래 css링크 추가해줄것 -->
<link rel="stylesheet" href="/resources/css/main/mainHeader.css">
</head>
<body>
	<jsp:include page="../../admin/adminHeader.jsp"></jsp:include>
	<div class="main-contents">
		<div class="main-sidebar">
			<jsp:include page="../../admin/adminSideBar.jsp"></jsp:include>
		</div>
		<div class="main-section">
			<!-- 이 안에서 작업! 여기가 본문-->
			<h1>배너 관리</h1>
			<div>
				<h5>1번 배너</h5>
					<div style="border: 1px solid black; height: 100px">
					<c:choose>
						<c:when test="${bannerList[0].bannerFrom eq 1 }">
							<img id="preview1" src="/resources/images/banner/${bannerList[0].bannerRename}" style="width:100%; height:100%"/>
						</c:when>
						<c:when test="${bannerList[1].bannerFrom eq 1 }">
							<img id="preview1" src="/resources/images/banner/${bannerList[1].bannerRename}" style="width:100%; height:100%"/>
						</c:when>
						<c:when test="${bannerList[2].bannerFrom eq 1 }">
							<img id="preview1" src="/resources/images/banner/${bannerList[2].bannerRename}" style="width:100%; height:100%"/>
						</c:when>
						<c:otherwise>
							<img id="preview1">
						</c:otherwise>
					</c:choose>
					
					</div>
				<form method="post" action="/admin/registerBanner" encType="multipart/form-data">
					<input type="file" name="bannerImage"  onchange="readFile(this,1);">
					<input type="hidden" name="bannerFrom" value="1">
					<button type="submit">배너 등록</button>
					<button type="button" onclick="removeBanner(1);">배너 삭제</button>
				</form>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
			</div>

			<div>
				<h5>2번 배너</h5>
					<div style="border: 1px solid black; height: 100px">
					<c:choose>
						<c:when test="${bannerList[0].bannerFrom eq 2 }">
							<img id="preview2" src="/resources/images/banner/${bannerList[0].bannerRename}" style="width:100%; height:100%"/>
						</c:when>
						<c:when test="${bannerList[1].bannerFrom eq 2 }">
							<img id="preview2" src="/resources/images/banner/${bannerList[1].bannerRename}" style="width:100%; height:100%"/>
						</c:when>
						<c:when test="${bannerList[2].bannerFrom eq 2 }">
							<img id="preview2" src="/resources/images/banner/${bannerList[2].bannerRename}" style="width:100%; height:100%"/>
						</c:when>
						<c:otherwise>
							<img id="preview2">
						</c:otherwise>
					</c:choose>
					</div>
				<form method="post" action="/admin/registerBanner" encType="multipart/form-data">
					<input type="file" name="bannerImage"  onchange="readFile(this,2);">
					<input type="hidden" name="bannerFrom" value="2">
					<button type="submit">배너 등록</button>
					<button type="button" onclick="removeBanner(2);">배너 삭제</button>
				</form>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
			</div>

			<div>
				<h5>3번 배너</h5>
					<div style="border: 1px solid black; height: 100px">
					<c:choose>
						<c:when test="${bannerList[0].bannerFrom eq 3 }">
							<img id="preview3" src="/resources/images/banner/${bannerList[0].bannerRename}" style="width:100%; height:100%"/>
						</c:when>
						<c:when test="${bannerList[1].bannerFrom eq 3 }">
							<img id="preview3" src="/resources/images/banner/${bannerList[1].bannerRename}" style="width:100%; height:100%"/>
						</c:when>
						<c:when test="${bannerList[2].bannerFrom eq 3 }">
							<img id="preview3" src="/resources/images/banner/${bannerList[2].bannerRename}" style="width:100%; height:100%"/>
						</c:when>
						<c:otherwise>
							<img id="preview3">
						</c:otherwise>
					</c:choose>
					</div>
				<form method="post" action="/admin/registerBanner" encType="multipart/form-data">
					<input type="file" name="bannerImage"  onchange="readFile(this,3);">
					<input type="hidden" name="bannerFrom" value="3">
					<button type="submit">배너 등록</button>
					<button type="button" onclick="removeBanner(3);">배너 삭제</button>
				</form>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
			</div>
		</div>
		<div class="main-sidebar">여기는 사이드바</div>
	</div>
	<footer> </footer>
	<script>
	function readFile(input,from){
  		if(input.files && input.files[0]){
  			var reader = new FileReader();
  			reader.onload = function(e){
  				document.getElementById('preview'+from).src = e.target.result;
  			};
  			reader.readAsDataURL(input.files[0]);
  		}else{
  			document.getElementById('preview'+from).src = "";
  		}
  	}
	
	function removeBanner(bannerFrom){
		location.href = "/admin/removeBanner?bannerFrom="+bannerFrom;
	}
	
	
	</script>
</body>
</html>