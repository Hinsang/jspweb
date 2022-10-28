<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<link href="/jspweb/css/main.css" rel="stylesheet">

</head>
<body>

	<%@include file="header.jsp"%>
	
	<!-- 대문 [ 이미지 슬라이드 - 캐러셀 ] -->
	<div id="carouselExampleControls" class="carousel slide carousel-fade" data-bs-ride="carousel" data-bs-interval="1000">
																<!-- carousel-fade : 덮어씌우기  / data-bs-interval : 자동반복 -->
	  <div class="carousel-inner">
	    <div class="carousel-item active">
	      <img src="/jspweb/img/mainimg1.jpg" class="d-block w-100" alt="...">
	    </div>
	    <div class="carousel-item">
	      <img src="/jspweb/img/mainimg2.jpg" class="d-block w-100" alt="...">
	    </div>
	    <div class="carousel-item">
	      <img src="/jspweb/img/mainimg3.jpg" class="d-block w-100" alt="...">
	    </div>
	  </div>
	  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
	    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	    <span class="visually-hidden">Previous</span>
	  </button>
	  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
	    <span class="carousel-control-next-icon" aria-hidden="true"></span>
	    <span class="visually-hidden">Next</span>
	  </button>
	</div>
	
	<!-- 광고/이벤트 -->
	
	<!-- 제품 출력 -->
	<div class="container"> <!-- 전체 박스권 -->
	
		<h6 class="box_title">CATEGORY BEST</h6>
			
		<div class="itemlist">	<!-- 일정구역 -->
		
		
			<div class="item">	<!-- 1개의 제품 -->
				<a href="#">
					<img src="/jspweb/img/p1.gif">
				</a>
				
				<div class="item_info">	<!-- 제품 정보 -->
					<div class="item_title">트렌디한 크롭 기장의 덤불안감 카라넥 스웨이드 무스탕</div> <!-- 제품명 -->
					
					<div class="item_size">[FREE]</div>
					
					<div class="item_price">200,000원</div> <!-- 원가 -->
					<div> <!-- 할인된 가격, 할인율 -->
						<span class="item_sale">20,000원</span>
						<span class="item_discount">90%</span>
					</div>
					<div class="item_review">찜수 540 리뷰수 412</div> <!-- 리뷰 -->
				</div>
				<div>	<!-- 배지 구역 -->
					<span class="badge rounded-pill text-bg-warning">주문폭주</span>
					<span class="badge rounded-pill text-bg-danger">1+1</span>			
				</div>
			</div>			
			
		</div>
		
	</div>

	<script type="text/javascript" src="/jspweb/JS/index.js"></script>

</body>
</html>























