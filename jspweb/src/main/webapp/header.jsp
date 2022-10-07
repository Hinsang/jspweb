<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="/jspweb/css/header.css">
	<!-- header는 모든경로에서 쓰이므로 절대경로를 넣는다. -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
	
</head>
<body>
	
	<div class="webbox">
	
		<div class="hd_top">
			<div>
				<span class="hd_title">
					<a href="/jspweb/index.jsp">
						Ezen Shop
					</a>
				</span>
			</div>
			
			<ul class="hd_sub">
				<li><a href="/jspweb/member/login.jsp">로그인</a></li>
				<li><a href="/jspweb/member/signup.jsp">회원가입</a></li>
				<li><a href="#">마이쇼핑</a></li>
				<li><a href="#">고객센터</a></li>
			</ul>
		</div>
		
		<div>
		
			<ul class="hd_menu">
				<li><a href="#">BIG SIZE!</a></li>
				<li><a href="#">1+1 이벤트</a></li>
				<li><a href="#">아우터</a></li>
				<li><a href="#">상의</a></li>
				<li><a href="#">바지</a></li>
				<li><a href="#">슈즈</a></li>
				<li><a href="#">악세사리</a></li>
				<li><a href="#">BEST</a></li>
				<li><a href="#">트레이닝</a></li>
				<li><a href="#">50%할인</a></li>
				<li><a href="#">MUSLE-FIT</a></li>
				<li class="searchbox">
					<span>
						<input>
						<i class="fas fa-search"></i>
					</span>
					<i class="fas fa-shopping-cart"></i>
				</li>
			</ul>
			
		</div>
		
	</div>
	
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
</body>
</html>
