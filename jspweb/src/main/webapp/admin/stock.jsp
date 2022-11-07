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
		<h3>재고 관리</h3>
		<div class="row">
			<div class="col-md-4"> <!-- 부트스트랩 충돌나서 클래스 나눔 -->
				<select class="cselect form-select">
					<option>카테고리 선택</option>
				</select>
			</div>
			<div class="col-md-4">
				<select class="pselect form-select col-md-4">
					<option>제품명 선택</option>
				</select>
			</div>
		</div>
		
		<div class="row my-3"> <!-- my-3 위아래 바깥여백[마진] -->
			<div class="col-md-6">
				<h3>재고 등록</h3>
				<table class="table">
					<tr>
						<td style="width: 20%;">카테고리번호</td>
						<td class="rows"></td>
					</tr>
					<tr>
						<td style="width: 20%;">제품번호</td>
						<td class="rows"></td>
					</tr>
					<tr>
						<td style="width: 20%;">제품명</td>
						<td class="rows"></td>
					</tr>
					<tr>
						<td style="width: 20%;">사이즈</td>
						<td class="rows">
							<input type="text" class="psize form-control">
						</td>
					</tr>
					<tr>
						<td style="width: 20%;">색상</td>
						<td class="rows">
							<input type="text" class="pcolor form-control">
						</td>
					</tr>
					<tr>
						<td style="width: 20%;">재고</td>
						<td class="rows">
							<input type="text" class="pstock form-control">
						</td>
					</tr>
					<tr>
						<td colspan="2"><button type="button" class="form-control" onclick="setstock()">등록</button></td>
					</tr>
				</table>
			</div>
			
			<div class="col-md-6">
				<h3>재고 출력</h3>
				<table class="stock">
					
				</table>
			</div>
		</div>
		
	</div>
	
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="/jspweb/JS/admin/stock.js"></script>
	
</body>
</html>
