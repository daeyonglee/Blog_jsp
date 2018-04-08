<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<%=application.getContextPath()%>/css/w3.css">
<link rel="stylesheet" href="<%=application.getContextPath()%>/css/common.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<title>로그인</title>
</head>
<body class="w3-light-grey">
<div class="w3-content" style="max-width:1400px">
	<div class="w3-container" style="height:600px; margin-top: 100px;">
		<form class="w3-container w3-card-4" action="<%=application.getContextPath() %>/login.do" method="get" style="width:50%; margin:0 auto; background-color: white">
		  <div class="w3-left-align w3-text-black"><p>ID</p></div>
		  <p><input class="w3-input" type="text" name="id"></p>
		  <div class="w3-left-align w3-text-black"><p>PASSWORD</p></div>
		  <p><input class="w3-input" type="password" name="pwd"></p>
		  <p><button class="w3-button w3-border w3-hover-indigo w3-text-black" style="width:100%;">로그인</button></p>
		  <p class="w3-text-blue w3-hover-indigo" onclick="window.location.href='user/search.jsp'">아이디/비밀번호 찾기</p>
		  <p class="w3-text-blue w3-hover-indigo" onclick="window.location.href='user/join.jsp'">회원가입</p>
		</form>
	</div>
</div>
<jsp:include page="/modules/footer.jsp" />

</body>
</html>