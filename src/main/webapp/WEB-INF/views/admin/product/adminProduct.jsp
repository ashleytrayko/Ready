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
			<div class="container col-lg-8"> 
			<!-- 이 안에서 작업! 여기가 본문-->
			<h1>상품 관리</h1>
			<table class="table table-hover">
				<thead>
					<tr>
						<th></th>
						<th>상품번호</th>
						<th>책 제목</th>
						<th>저자</th>
						<th>출판사</th>
						<th>수정</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${bookList }" var="bookList" varStatus="i">
					<tr>
						<td><input type="checkbox"></td>
						<td>${bookList.bookNo }</td>
						<td>
						<a href="/book/detailView.kh?bookNo=${bookList.bookNo }">
						${bookList.bookTitle }
						</a>
						</td>
						<td>${bookList.bookWriter }</td>
						<td>${bookList.publisher }</td>
						<td><button type="button" onclick="modifyNotice(${noticeList.noticeNumber})">수정하기</button></td>
					</tr>
					</c:forEach>
					<tr align="center">
						<td colspan="6">
						<form class="col-12 search mb-3 mb-lg-auto me-lg-auto center"
							role="search" action="/admin/searchProduct" method="get">
							<div class="input-group">
								<select name="searchCondition" class="input-group-text" id="inputGroup-sizing-sm">
									<option value="all" <c:if test="${searchCondition eq 'all' }">selected</c:if>>전체</option>
									<option value="writer" <c:if test="${searchCondition eq 'writer' }">selected</c:if>>작가</option>
									<option value="title" <c:if test="${searchCondition eq 'title' }">selected</c:if>>제목</option>
									<option value="contents" <c:if test="${searchCondition eq 'contents' }">selected</c:if>>내용</option>
								</select>
								<input type="search" class="form-control" name="searchValue" value="${searchValue }"
									placeholder="도서 검색" aria-label="Search" />
							</div>
						</form>
						</td>
					</tr>
					<tr align="center" height="20">
			            <td colspan="6">
			                <c:if test="${currentPage != 1}">
			                    <a href="/admin/${urlVal }?page=${currentPage - 1 }">
			                    <button class="btn btn-outline-dark">이전</button>
			                    </a>
			                </c:if>
			                <c:if test="${currentPage == 1}">
			                    <button class="btn btn-outline-dark disabled">이전</button>
			                </c:if>
			                <c:forEach var="p" begin = "${startNavi }" end="${endNavi }">
			                    <c:if test="${currentPage eq p }">
			                       <button class="btn btn-dark">${p}</button>  
			                    </c:if>
			                    <c:if test="${currentPage ne p }">
			                        <a href = "/admin/${urlVal }?page=${p }&searchCondition=${searchCondition }&searchValue=${searchValue }">
			                        <button class="btn btn-outline-dark">${p}</button>
			                        </a>
			                    </c:if>
			                </c:forEach>
			            	<c:if test = "${currentPage < maxPage }">
			                	<a href = "/admin/${urlVal}?page=${currentPage + 1}">
			                	<button class="btn btn-outline-dark">
			                		다음
			                	</button>
			                	</a>
			            	</c:if>
			            	<c:if test = "${currentPage == maxPage }">
			                	<button class="btn btn-outline-dark disalbed">
			                		다음
			                	</button>
			            	</c:if>
			            </td>
		        	</tr>
				</tbody>
			</table>
			        
			<button onclick="newBook();">상품 등록</button>
			<button>상품 삭제</button>


			</div>
		</div>
		
	<footer> </footer>
	<script>
	function newBook(){
		location.href = "/admin/admin-productForm";
	}
	</script>
</body>
</html>