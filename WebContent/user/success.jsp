<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- css -->
<link rel="stylesheet" href="../css/w3.css">
<link rel="stylesheet" href="../css/common.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<!-- javascript -->
<script type="text/javascript" src="<%=application.getContextPath()%>/js/join.js"></script>
<title>join</title>
</head>
<body class="w3-light-grey">
<div class="w3-content" style="max-width:1400px">
  <div class="w3-container">
    <div class="w3-container w3-white w3-padding-large" style="width: 500px; height:600px; margin:16px auto;">
    	<h3>축하합니다. 회원가입 완료되었습니다.</h3>
    	<hr>
    	<p><label>ID : </label><%=request.getParameter("id") %></p>
    	<p><label>EMAIL : <%=request.getParameter("email") %></label></p>
    	<a class="w3-text-blue" href="<%=application.getContextPath()%>/index.jsp">홈으로 가기</a>
    </div>
  </div>
<jsp:include page="../modules/footer.jsp" />
</div>
</body>
</html>