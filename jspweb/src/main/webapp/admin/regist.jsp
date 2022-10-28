<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h3> 제품 등록 </h3>
		<form>
			제품명 : <input type="text" name="pname"> <br>
			설명 : <textarea rows="" cols="" name="pcomment"></textarea> <br>
			가격 : <input type="text" name="pprice"> <br>
			할인율 : <input type="text" name="pdiscount"> <br>
			카테고리 : <button type="button" onclick="pcategoryview()">카테고리추가</button> <br>
				<span class="pcategoryaddbox">
					
				</span>
				
				<div class="pcategorybox">
					<input type="radio" name="pcno">
					<input type="radio" name="pcno">
				</div>
				
				상태 :
				<div class="pcategorybox">
					판매중<input type="radio" name="pactive" value="1">
					미판매<input type="radio" name="pactive" value="2">
				</div>
				
			상품대표이미지 : <input type="file" id="pimg" name="pimg"> <br>
			<button type="reset">취소</button> <button type="button" onclick="regist()">등록</button>
		</form>
		
		<div>
			<img alt="" src="" id="pimgpre">
		</div>
		
	</div>
	
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="../JS/admin/regist.js"></script>
	
</body>
</html>
