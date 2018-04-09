<%@ page contentType="text/html; charset=UTF-8" isErrorPage="true"%>
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
    <div class="w3-container w3-white w3-padding-large" style="width: 500px; margin:16px auto;">
    	<p>내부적으로 오류가 발생하였습니다. 다시한번 시도해 주시길 바랍니다.</p>
    	<p>error : <%=exception.getMessage() %></p>
    </div>
  </div>
<jsp:include page="../modules/footer.jsp" />
</div>
</body>
</html>