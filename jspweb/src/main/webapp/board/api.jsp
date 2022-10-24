<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 

	<%@include file="../header.jsp" %>
	
	<div class="container"> <!-- b:container  -->
	
		<!-- 3. 9월 전국 아파트 실거래가 테이블 -->
		<table class="table">
			<tr>
				<th> 시군구 </th> 
				<th> 번지 / 본번 / 부번 </th>
				<th> 단지명 </th>
				<th> 전용면적 </th>
				<th> 계약년월 </th>
				<th> 계약일 </th>
				<th> 계약금액(만원) </th>
				<th> 층 </th>
				<th> 건축년도 </th>
				<th> 도로명 </th>
				<th> 해제사유발생일 </th>
				<th> 거래유형 </th>
				<th> 중개사소재지 </th>
			</tr>
		</table>
	
		<!-- 1. 지도를 표시할 div 입니다 -->
		<div id="map" style="width:100%;height:350px;"></div>
		
		<!-- 2. 약국 상세 정보 div 입니다. -->
		<div class="detailbox">
			
		</div>
		
		<div class="row">  <!-- b: row  -->
			<div class="col-sm-3">  <!-- b: col-sm-3 [3/12] -->
				<input type="text" class="form-control addrinput">
			</div>
			<div class="col-sm-1">  <!-- b: col-sm-1 [1/12] -->
			<button type="button" class="btn" onclick="addrsearch()">검색</button>
			</div>
		</div>
		
		<table class="table apitable1"> <!-- b:table -->
			
		</table>
	</div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fa6e36e65b5bb7c8362ed76350e8a79d&libraries=services"></script>
	<script type="text/javascript" src="../JS/board/api.js"></script>
	
	
</body>
</html>
