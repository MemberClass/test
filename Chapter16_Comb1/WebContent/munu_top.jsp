<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body, div, ul, li {
	margin: 0;
	padding: 0;
}

body {
	font-size: 12px;
	font-family: "맑은고딕", arial
}

ul {
	list-style: none;
}

a {
	color: #000;
	text-decoration: none;
}

.gnb {
	height: 36px;
	margin: auto;
	margin-top: 0;
}

.gnb>ul {
	text-align: center;
	height: 36px;
	background: #0099ff;
	padding: 0;
}

.gnb>ul>li {
	display: inline-block;
	width: 102px;
	height: 36px;
	margin-top: 0;
	position: relative;
}

.gnb>ul>li>a {
	display: block;
	width: 100%;
	height: 100%;
	font: bold 13px, 30px "맑은고딕", arial;
	text-align: center;
	color: #fff;
	background: #0099ff;
}

.gnb ul li a:hover {
	color: #000;
	background: #0099ff;
}

.gnb ul ul {
	display: none;
}

.gnb ul li:hover ul {
	display: block;
	/*width: 400px; height: 36px; position: absolute;left: 0; top: 30px*/
}

.gnb li li {
	width: 100px;
	height: 36px;
	background-color: $47a9f4;
	text-align: center;
	float: left;
}

.gnb li li a {
	display: block;
	width: 100%;
	height: 100%;
	font: bold 12 px /25 px "맑은고딕",arial;
	text-align: center;
	margin-top: 5px;
	color: #fff;
	background: #0099ff;
}

.gnb li li a:hover {
	color: #fff;
	background: #0099ff;
}
</style>
</head>
<body>
	<div class="gnb">
		<ul>
			<li><a href="#">쇼핑</a>
				<ul>
					<li><a href="${pageContext.request.contextPath}/dogList.dog">상품
							목록 보기</a></li>
					<li><a
						href="${pageContext.request.contextPath}/dogCartList.dog">장바구니
							보기</a></li>
					<li><a href="#">서브메뉴4</a></li>
				</ul>
			</li>
			<li><a href="#">회원관리</a>
				<ul>
					<li><a href="${pageContext.request.contextPath}/memberJoin.me">회원
							가입</a></li>
					<li><a
						href="${pageContext.request.contextPath}/memberListAction.me">회원목록
							보기</a></li>
					<li><a href="#">서브메뉴3</a></li>
				</ul></li>

			<li><a href="#">게시판</a>
				<ul>
					<li><a
						href="${pageContext.request.contextPath}/boardWriteForm.bo">게시판
							글쓰기</a></li>
					<li><a href="${pageContext.request.contextPath}s/boardList.bo">게시판
							목록 보기</a></li>
					<li><a href="#">서브메뉴3</a></li>
					<li><a href="#">서브메뉴4</a></li>
				</ul></li>
			<li><a href="#">주메뉴5</a>
				<ul>
					<li><a href="#">서브메뉴1</a></li>
					<li><a href="#">서브메뉴2</a></li>
					<li><a href="#">서브메뉴3</a></li>
					<li><a href="#">서브메뉴4</a></li>

				</ul></li>
			<li>
				<c:choose>
					<c:when test="${id eq null }">
						<a href="${pageContext.request.contextPath}/memberLogin.me">로그인</a>
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/memberLogout.me">로그아웃</a>
					</c:otherwise>
				</c:choose>
			</li>
		</ul>
	</div>
</body>
</html>