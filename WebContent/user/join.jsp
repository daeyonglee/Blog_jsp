<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../css/w3.css">
<link rel="stylesheet" href="..//css/common.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<title>join</title>
</head>
<body class="w3-light-grey">
<div class="w3-content" style="max-width:1400px">
  <div class="w3-container">
    <div class="w3-container w3-white w3-padding-large" style="width: 500px; margin:16px auto;">
      <div class="w3-panel w3-blue">
        <h2>회원가입</h2>
      </div>
      <hr>
      <form class="w3-container">
        <p>
        <label>ID</label>
        <input class="w3-input" type="text"></p>
        <p>
        <label>PASSWORD</label>
        <input class="w3-input" type="password"></p>
        <p>
        <label>NAME</label>
        <input class="w3-input" type="text"></p>
        <p>
        <label>EMAIL </label>
        <input class="w3-input" type="email"></p>
        <p>
        <input class="w3-btn w3-block w3-red" type="submit" value="가입하기"></p>
      </form>
    </div>
  </div>
<jsp:include page="../modules/footer.jsp" />
</div>
</body>
</html>