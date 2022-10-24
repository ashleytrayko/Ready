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
<title>게시글 상세보기</title>
<!-- 타이틀 밑에 아래 css링크 추가해줄것 -->
<link rel="stylesheet" href="/resources/css/main/mainHeader.css">
<link rel="stylesheet" href="/resources/css/comm/listView.css">
</head>
<body>
	<jsp:include page="../main/commHeader.jsp"></jsp:include>
    <div class="main-contents">
		<div class="main-sidebar">여기는 사이드바</div>
		<div class="main-section">
			<div class="list-div">
				<h2>게시판 상세글</h2>
				<table align="center" border="1">
					<tr>
						<td>제목</td>
						<td>${comm.commTitle }</td>
						<td>조회수</td>
						<td>${comm.cCount }</td>
					</tr>
					<tr>
						<td>작성자</td>
						<td>${comm.commWriter }</td>
						<td>작성일</td>
						<td>${comm.cCreateDate }</td>
					</tr>
					<tr>
						<td>내용</td>
						<td>${comm.commContents }</td>
					</tr>
					<tr>
						<td>추천수</td>
						<td>${comm.cLike }</td>
					</tr>
					<c:if test="${principal.username eq comm.commWriter }">
						<tr>
							<td colspan="2" align="center">
								<a href="/comm/modifyView.kh?boardNo=${comm.boardNo }&page=${page}">글 수정</a>
								<a href="#" onclick="commRemove(${page});">삭제하기</a>
							</td>
						</tr>
					</c:if>
					</table>
					<!-- 	댓글 등록 -->
					<form action="/comm/replyAdd.kh" method="post">
						<input type="hidden" name="page" value="${page }">
						<input type="hidden" name="boardNo" value="${comm.boardNo }">
						<table align="center" width="500" border="1">
							<tr>
								<td>
									<textarea rows="3" cols="55" name="commReplyContents"></textarea>
								</td>
								<td>
									<input type="submit" value="등록하기">
								</td>
							</tr>
						</table>
					</form>
					<!-- 	댓글 목록 -->
					<table align="center" width="500" border="1">
						<c:forEach items="${cRList }" var="commReply" >
							<tr>
								<td width="100">${commReply.commReplyWriter }</td>
								<td>${commReply.commReplyContents }</td>
								<td>${commReply.cUpdateDate }</td>
								<td><a href="#" onclick="modifyView(this, '${commReply.commReplyContents}', ${commReply.commReplyNo });">수정</a>
								<a href="#" onclick="removeReply(${commReply.commReplyNo});">삭제</a></td>
							</tr>
						</c:forEach>
					</table>
					<tr>
						<td><button onclick="location.href='/comm/list.kh'">리스트로</button></td>
					</tr>
				</table>
			</div>
		</div>
		<div class="main-sidebar">여기는 사이드바</div>
    </div>
	<footer>
		
	</footer>
	<script>
		function freeRemove(value) {
			event.preventDefault(); // 하이퍼링크 이동 방지
			if(confirm("게시물을 삭제하시겠습니까?")) {
				location.href="/comm/remove.kh?page="+value;
			}
		}
		function removeReply(commReplyNo) {
			event.preventDefault();
			if(confirm("정말 삭제하시겠습니까?")) {
				var $delForm = $("<form>");
				$delForm.attr("action", "/comm/removeReply.kh");
				$delForm.attr("method", "POST");
				$delForm.append("<input type='hidden' name='commReplyNo' value='"+commReplyNo+"'>");
				$delForm.appendTo("body");
				$delForm.submit();
			}
		}
		function modifyView(obj, cReplyContents, commReplyNo) {
			event.preventDefault();
			var $tr = $("<tr>");
			$tr.append("<td colspan='3'><input type='text' size='50' value='"+cReplyContents+"'></td>");
			$tr.append("<td><button onclick='modifyReply(this, "+commReplyNo+");'>수정</button></td>");
			$(obj).parent().parent().after($tr);
		}
		function modifyReply(obj, commReplyNo) {
			var inputTag = $(obj).parent().prev().children();
			var commReplyContents = inputTag.val(); //= $("#modifyInput").val();
			var $form =$("<form>");
			$form.attr("action", "/comm/modifyReply.kh");
			$form.attr("method", "post");
			$form.append("<input type='hidden' value='"+commReplyContents+"' name='commReplyContents'>");
			$form.append("<input type='hidden' value='"+commReplyNo+"' name='commReplyNo'>");
			$form.appendTo("body");
			$form.submit();
		}
		
	</script>
</body>
</html>