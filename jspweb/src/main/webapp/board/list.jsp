<%@page import="model.dao.BoardDao"%>
<%@page import="model.dao.MemberDao"%>
<%@page import="model.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<!-- 부트스트랩 css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

</head>
<body>
	<%@include file="../header.jsp" %>
	<div class="webbox">
		<a href="write.jsp"> 글쓰기 </a>
		<!-- JSP로 테이블 표시   [ 서블릿,js 제외한 ] -->
<%-- 		<table>
			<tr>
				<th> 번호 </th> <th> 제목 </th> <th> 작성자 </th>
			</tr>
			<%  // 스크립트 태그 : html에 java 작성할수 있는 공간
			
			ArrayList<BoardDto> list 
				= BoardDao.getInstance().getlist();
			
			for( int i = 0 ; i<list.size() ; i++ ){
			%>
				<tr>
					<td> <%= list.get(i).getBno() %></td>
					<td> <%= list.get(i).getBtitle() %></td>
					<td> <%= list.get(i).getMno() %></td>
				</tr>
			<% 
			}			// <%= 표현식(호출) 
			%>
		</table> --%>
		
		<!-- JS로 테이블 표시    [ HTML(JSP) --- JS ---- 서블릿 --- DAO ] -->
		<table class="btalbe table">
			<tr>
				<th> 번호 </th> <th> 제목 </th> <th>작성자</th> 
				<th> 작성일 </th> <th> 조회수 </th>
			</tr>
		</table>
		
		<div class="pagebox">
		
		</div>
		
		
		
	</div>
	
	<!-- 부트스트랩 js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	
	<script type="text/javascript" src="../JS/board/list.js"></script>


</body>
</html>
