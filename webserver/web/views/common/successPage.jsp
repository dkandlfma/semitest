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
	<div><%=message %></div>
	<button onclick="goHome();">돌아가기</button>
	<script>
		function goHome(){
			location.href="<%=request.getContextPath()%>/index.jsp";
		}
		</script>
</body>
</html>