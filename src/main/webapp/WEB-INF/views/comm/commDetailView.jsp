<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/png"  href="/resources/images/favicon.ico"/>
<title>게시글 상세 페이지</title>
<!-- 타이틀 밑에 아래 css링크 추가해줄것 -->
<link rel="stylesheet" href="/resources/css/main/mainHeader.css">
<link rel="stylesheet" href="/resources/css/comm/listView.css">
<link rel="stylesheet" href="/resources/css/comm/commForm.css">
<link rel="stylesheet" href="/resources/css/que/faqList.css">
<script src="/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
	<jsp:include page="../main/commHeader.jsp"></jsp:include>
    <div class="main-contents">
		<div class="main-sidebar"></div>
		<div class="main-section">
			<div class="list-div">
				<h2 class="list-title">게시글 상세</h2>
				<table align="center" border="1" class="table-style">
					<tr class="detail-comm">
						<!-- <td>제목</td> -->
						<td colspan="4" class="th-left detail-title">${comm.commTitle }</td>
						<!-- <td>작성일</td> -->
						<%-- <td>${comm.cCreateDate }</td> --%>
					</tr>
					<tr class="detail-comm">
						<!-- <td>작성자</td> -->
						<td colspan="3" class="th-left detail-writer" width="80%">${comm.commWriter }</td>
						<!-- <td>조회</td> -->
						<td width="20%">${comm.cCreateDate }&nbsp;&nbsp;&nbsp;조회&nbsp;&nbsp;${comm.cCount }</td>
					</tr>
					<tr>
						<td class="detail-content" colspan="4" align="left">${comm.commContents }</td>
					</tr>
					<tr>
						<td colspan="4">추천수 : ${comm.cLike }&nbsp;&nbsp;<img id="likeBtn" class="thumbs-img" src="../resources/images/thumbs-up.png"></td>
						<%-- <td>${comm.cLike }</td> --%>
					</tr>
					<!-- <tr>
						<td colspan="4"><img id="likeBtn" class="thumbs-img" src="../resources/images/thumbs-up.png"></td>
					</tr> -->
					<c:if test="${principal.user.userId eq comm.commId }">
						<tr>
							<td colspan="4" align="center">
								<button class="rvs-sig-btn" onclick="commRemove(${page});">삭제</button>
								<button class="sig-btn" onclick="location.href='/comm/modifyView.kh?boardNo=${comm.boardNo }&page=${page}'">수정</button>
							</td>
						</tr>
					</c:if>
					<tr>
						<td colspan="4" align="right" class="detail-content-bot">
							<a class="a-button" href="/comm/list.kh?page=${page}">리스트</a>
							<%-- <button onclick="reportBoard();">신고</button>
							<a href="#" onclick="commRemove(${page});">삭제하기</a> --%>
							<a class="a-button report-btn" href="#" onclick="reportBoard(${page});">신고</a>
						</td>
					</tr>
				</table>
					<!-- 	댓글 등록 -->
					<table align="center" class="detail-repl">
						<tr>
							<td align="left" id="rWriter">${principal.user.userNickname }</td>	
							<!-- 댓글등록을 닉네임으로 하기 위해 id에 rWriter 부여 -->
						</tr>
							<thead>
								<tr>
									<!-- 댓글 갯수 -->
									<td colspan="4"><b id="rCount"></b></td>
								</tr>
							</thead>
						<tr>
							<td>
								<textarea align="left" rows="3" cols="100" name="rContents" id="rContents"></textarea>
							</td>
							<td align="center">
								<button id="rSubmit" class="sig-btn">등록</button>
							</td>
						</tr>
					</table>
					<!-- 	댓글 목록 -->
					<table align="center" class="detail-repl" id="rtb">
						
							<tbody>
							</tbody>
					</table>
			</div>
		</div>
		<div class="main-sidebar"></div>
    </div>
	<footer>
		
	</footer>
	<script>
		getReplyList();		// 함수 바로 실행하도록 호출
		function getReplyList() {
			// detailView가 동작하면 바로 동작하게끔 ajax 바로 써줌
			var boardNo = "${comm.boardNo }";
			var userId = "${principal.user.userNickname}"
			var page;
			$.ajax({
				url : "/comm/replyList.kh",
				data : {"boardNo" : boardNo},	// 어느 게시판 댓글인지 알아야 하기 때문에 boardNo를 받아옴
				type : "get",
				success : function(cRList) {
					var $tableBody = $("#rtb tbody");		//rtb의 후손 선택자 tbody선택
					$tableBody.html("");	// 내용 초기화 후 append()
					$("#rCount").text("댓글 (" + cRList.length + ")");	// 댓글 갯수 동적으로 표시
					if(cRList != null) {
						console.log(cRList);
						for(var i in cRList) {
							var $tr = $("<tr class='th-line th-left'>");
							var $rWriter = $("<td width='13%'>").text(cRList[i].rWriter);	// text로 하면 태그작동x, html로 하면 태그작동o
							var $rContents = $("<td width='55%'>").text(cRList[i].rContents);
							var $rCreateDate = $("<td width='13%' align='center'>").text(cRList[i].rCreateDate);
/* 							var $btnArea = $("<td width='80'>").append("<button href='javascript:void(0);' id='rCo1' onclick='commentView1(this,\""+cRList[i].rContents+"\","+cRList[i].cReplyNo+")'>답글</button>"); */
							var $btnArea = "";
							if(userId == cRList[i].rWriter) {
								$btnArea = $("<td width='19%' align='center'>")
												.append("<button href='javascript:void(0);' class='rvs-sig-btn' onclick='removeReplyAjax("+cRList[i].cReplyNo+")'>삭제</button>")
											 	.append("<button href='javascript:void(0);' class='btn-click sig-btn' onclick='modifyView(this,\""+cRList[i].rContents+"\","+cRList[i].cReplyNo+",1,"+boardNo+"); this.onclick = null;'>수정</button> ");
												/* .append("<button href='javascript:void(0);' id='rCo' onclick='commentView(this,\""+cRList[i].cReplyNo+")'>답글</button>"); */
											 	/* 대댓글 .append("<button href='javascript:void(0);' id='rCo2' onclick='commentView2(this,\""+cRList[i].rContents+"\","+cRList[i].cReplyNo+")'>답글</button> "); */
							}
							$tr.append($rWriter); // <tr><td width='100'>khuser01</td></tr>
							$tr.append($rContents); // <tr><td width='100'>khuser01</td><td>댓글내용</td></tr>
							$tr.append($rCreateDate);
							$tr.append($btnArea);
							$tableBody.append($tr); 	// 후손으로 넣기 위해 append태그 사용
							$btnArea = "";				// btnArea를 비워줘야 이전의 내용을 끌고오지않음
							// <tbody><tr><td></td><td></td>...</tr></tbody>
						}
					}
				},
				error : function() {
					// console.log("서버 요청 실패");
					alert("ajax 통신 실패! 관리자에게 문의하세요!!");
				}
			});
		}
		
		function removeReplyAjax(cReplyNo) {
			if(confirm("정말 삭제하시겠습니까?")) {
				$.ajax({
					url : "/comm/replyDelete.kh",
					data : { "cReplyNo" : cReplyNo },
					type : "get",
					success : function(data) {
						if(data == "success") {
							getReplyList();
						} else{
							alert("댓글 삭제 실패!");
						}
					},
					error : function() {
						alert("ajax 통신 오류! 관리자에게 문의해주세요!");
					}
				});
			}
		}
		
	
		$("#rSubmit").on("click", function() {
			var boardNo = "${comm.boardNo}";		// 자바 스크립트에서 사용하는 el 아래는 html에서 사용하는 el.
			var rContents = $("#rContents").val();		// textarea나 input이면 val쓰면 됨. 아닐 시 html.
			var rWriter = $("#rWriter").text();		// 댓글 작성자에 댓글 입력할 때 나오는 댓글입력자 값을 넣어줌
			$.ajax({
				url : "/comm/replyAdd.kh",
				data : { 
					"boardNo"	: boardNo,
					"rContents" : rContents,
					"rWriter" : rWriter
				},
				type : "post",		// replyContents가 길어질 수 있어서 잘림방지를 위해 post로 함
				success : function(result) {
					if(result == "success") {
						alert("댓글 등록 성공!");
						// DOM조작, 함수호출 등.. 가능
						$("#rContents").val("");	// 작성 후 내용 초기화
						getReplyList();	// 댓글 리스트 출력
					}else {
						alert("댓글 등록 실패!");
					}
				},
				error : function() {
					alert("서버 요청 실패!");
				}
			});
		});
	
	
		function commRemove(value) {
			event.preventDefault(); // 하이퍼링크 이동 방지
			if(confirm("게시물을 삭제하시겠습니까?")) {
				location.href="/comm/remove.kh?page="+value;
			}
		}
		function modifyView(obj, rContents, cReplyNo, page, boardNo) {
			event.preventDefault();
			var $tr = $("<tr class='tr-line tr-left'>");
			$tr.append("<td width='13%'></td>");
			$tr.append("<td width='55%'><input type='text' size='50' value='"+rContents+"'></td>");
			$tr.append("<td width='13%' align='left' class='th-left'><button class='sig-btn' onclick='modifyReply(this, "+cReplyNo+", "+page+", "+boardNo+");'>수정</button></td>");
			$tr.append("<td width='19%' align='left' class='th-left'></td>");
			$(obj).parent().parent().after($tr);
			$('.btn-click').off('click');
		}
		function modifyReply(obj, cReplyNo, page, boardNo) {
			var inputTag = $(obj).parent().prev().children();
			console.log(inputTag.val());
			var rContents = inputTag.val();
			var $form =$("<form>");
			$form.attr("action", "/comm/replyModify.kh");
			$form.attr("method", "post");
			$form.append("<input type='hidden' value='"+rContents+"' name='rContents'>");
			$form.append("<input type='hidden' value='"+cReplyNo+"' name='cReplyNo'>");
			$form.append("<input type='hidden' value='"+page+"' name='page'>");
			$form.append("<input type='hidden' value='"+boardNo+"' name='boardNo'>");
			console.log($form[0]);
			$form.appendTo("body");
			$form.submit();
		}
		
		function reportBoard(value) {
			event.preventDefault(); // 하이퍼링크 이동 방지
			if(confirm("게시물을 신고하시겠습니까?")) {
				location.href="/comm/report.kh?page="+value;
			}
		}
		
		$("#likeBtn").on("click", function() {
			var boardNo = "${comm.boardNo}";
			var commId = "${principal.user.userId}";
			$.ajax({
				url : "/like/likeUp.kh",
				datatype : "json",
				type : "post",
				data : {
					"boardNo"	: boardNo,
					"commId" 	: commId 
				},
				success : function(likeCheck) {
					if(likeCheck == 0) {
						alert("추천완료");
						location.reload();
					}
					else if(likeCheck == 1) {
						alert("추천취소");
						location.reload();
					}
				},
 				error : function() {
					alert("통신 에러");
				} 
					
			});
		}); 
		
		
		/* function commentView(obj, cReplyNo) {
			event.preventDefault();
			var $tr = $("<tr>");
			$tr.append("<td colspan='3'><input type='text' size='50'></td>");
			$tr.append("<td><button onclick='modifyReply(this, "+cReplyNo+");'>등록</button></td>");
			$(obj).parent().parent().after($tr);
			const target = document.getElementById('rCo2');
	        target.disabled = true;
		} 대댓글
		 */
	</script>
</body>
</html>