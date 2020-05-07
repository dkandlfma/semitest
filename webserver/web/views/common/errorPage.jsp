<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String message = (String)request.getAttribute("msg");
	
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div{
		height:150px;
		width:150px;
		background:yellow;
	}
</style>
</head>
<body>
	<!-- 에러 페이지 맞나? -->
	<h1 align = "center"><%= message%></h1>
	<div onclick="goHome();">메인으로 돌아가기</div>
	
	<script>
		function goHome(){
			location.href="index.jsp";
		}
	</script>
	
	
	
	
	
</body>
</html>