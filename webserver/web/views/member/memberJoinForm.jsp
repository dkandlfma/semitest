<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
   .outer{
      width:600px;
      height:500px;
      background:black;
      color:white;
      margin-left:auto;
      margin-right:auto;
      margin-top:50px;
   }
   
   .outer label, .outer td{
      color:white;
   }
   
   input{
      margin-top:2px;
   }
   
   #idCheck, #goMain, #joinBtn {
      background:orangered;
      border-radius:5px;
      width:80px;
      height:25px;
      text-align:center;
   }
   
   #idCheck:hover, #joinBtn:hover, #goMain:hover {
      cursor:pointer;
   }
   td {
      text-align:right;
   }
   #joinBtn {
      background:yellowgreen;
   }
   #joinBtn, #goMain {
      display:inline-block;
   }

</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<div class="outer">
		<br>
		<h2 align="center">회원가입</h2>
		<form id="joinForm"  action="<%=request.getContextPath()%>/insert.me" method="post">
			<table>
				<tr>
					<td width="200px">* 아이디</td>
					<td><input type="text" name="userId" required></td>
					<td width="200px"><div id="idCheck">중복확인</div></td>
				</tr>
				<tr>
					<td>* 비밀번호</td>
					<td><input type="password" name="userPwd" required></td>
					
				</tr>
				<tr>
					<td>* 비밀번호 확인</td>
					<td><input type="password" name="userPwd2" required></td>
					<td><label id="pwdResult"></label></td>
				</tr>
				<tr>
					<td>* 이름</td>
					<td><input type="text" name="userName" required></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td>
						<input type="tel" name="phone" placeholder="(-없이)01012341234">
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email"></td>
					<td><td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address"></td>
					<td><td>
					
				</tr>
				<tr>
					<td>관심분야</td>
					<td>
						<input type="checkbox" id="sports" name="interest" value="운동" >
						<label for="sports">운동</label>
						<input type="checkbox" id="climbing" name="interest" value="등산" >
						<label for="climbing">등산</label>
						<input type="checkbox" id="fishing" name="interest" value="낚시" >
						<label for="fishing">낚시</label>
						<input type="checkbox" id="cooking" name="interest" value="요리" >
						<label for="cooking">요리</label>
						<input type="checkbox" id="game" name="interest" value="게임" >
						<label for="game">게임</label>
						<input type="checkbox" id="etc" name="interest" value="기타" >
						<label for="etc">기타</label>
					</td>
					<td></td>
				</tr>
			</table>
			<br>
			
			<div class="btns" align="center">
				<div id="goMain" onclick="goMain();">메인으로</div>
				<div id="joinBtn" onclick="insertMember();">가입하기</div>
			</div>
		</form>
	</div>
	
	<script>
		function goMain(){
		location.href="<%=request.getContextPath()%>/index.jsp";
		}
		function insertMember(){
			$("#joinForm").submit();
		}
	</script>
	
</body>
</html>