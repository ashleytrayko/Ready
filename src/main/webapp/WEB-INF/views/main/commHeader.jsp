<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>


<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>nav</title>
    <link href='//spoqa.github.io/spoqa-han-sans/css/SpoqaHanSansNeo.css' rel='stylesheet' type='text/css'>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
      crossorigin="anonymous"
    />
    <script src="https://kit.fontawesome.com/41472d2b7a.js" crossorigin="anonymous"></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
      crossorigin="anonymous"
    ></script>
    <style>
    
    * { 
	font-family: 'Spoqa Han Sans Neo', 'sans-serif';
}

      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      .b-example-divider {
        height: 3rem;
        background-color: rgba(0, 0, 0, 0.1);
        border: solid rgba(0, 0, 0, 0.15);
        border-width: 1px 0;
        box-shadow: inset 0 0.5em 1.5em rgba(0, 0, 0, 0.1),
          inset 0 0.125em 0.5em rgba(0, 0, 0, 0.15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -0.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }
      .center {
        margin: auto;
      }
      .search {
        width: 700px;
      }

      
    </style>
  </head>
  <body>
    <nav class="py-2 bg-light border-bottom">
      <div class="container d-flex flex-wrap">
        <ul class="nav me-auto"></ul>
        <c:choose>
			<c:when test="${empty principal }">
        		<ul class="nav">
		        	<li class="nav-item">
		            <a href="/login" class="nav-link link-dark px-2">로그인</a>
		         	</li>
		          	<li class="nav-item">
		            <a href="/join" class="nav-link link-dark px-2">회원가입</a>
	          		</li>
        		</ul>
        	</c:when>
			<c:otherwise>
				<ul class="nav">
					<li class="nav-item"><a href="/logout"
						class="nav-link link-dark px-2">로그아웃</a></li>
				</ul>
			</c:otherwise>
		</c:choose>
      </div>
    </nav>
    <header class="py-3 border-bottom header-nav">
      <div class="container d-flex flex-wrap justify-content-center">
        <a
          href="/comm/list.kh"
          class="d-flex mb-3 mb-lg-0 me-lg-auto text-dark text-decoration-none"
        >
          <span class="fs-4 center">
            <img src="../resources/images/READY-LOGO1.png" height="60px" width="100px" />
          </span>
        </a>
        <form
          class="col-12 search mb-3 mb-lg-auto me-lg-auto center"
          role="search"
        >
          <input
            type="hidden"
            class="form-control"
            placeholder="도서 제목이나 작가명을 검색해주세요."
            aria-label="Search"
          />
        </form>
        <a
          href="/"
          class="d-flex mb-3 mb-lg-0 me-lg-3 text-dark text-decoration-none"
        >
          <span class="center">
            <i class="fa-solid fa-store fa-xl"></i>
            <p class="main-p">쇼핑몰</p>
          </span>
        </a>
        <a
          href="/user/mypage.kh"
          class="d-flex mb-3 mb-lg-0 me-lg-3 text-dark text-decoration-none"
        >
          <span class="center">
          	<i class="fa-solid fa-user fa-xl"></i>
            <p class="main-p">마이페이지</p>
          </span>
        </a>
        <a
          href="/que/faq01.kh"
          class="d-flex mb-3 mb-lg-0 me-lg-right text-dark text-decoration-none"
        >
          <span class="center">
            <i class="fa-solid fa-tty fa-xl"></i>
            <p class="main-p">고객센터</p>
          </span>
        </a>
      </div>
    </header>


