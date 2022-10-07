<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%@include file="../header.jsp"%>
	<div class="webbox">
		<h3>비밀번호 찾기</h3>
		아이디 : <input type="text" id="mid">
		이메일 : <input type="text" id="memail">
		<div id="fpwbox"></div>
		<button type="button" onclick="fpw()">비밀번호찾기</button>
	</div>
	
	<script src="../JS/member/test.js"></script>
	
</body>
</html>
