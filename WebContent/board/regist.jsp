<%@ page contentType="text/html; charset=UTF-8"%>
<%
String id = null;

Cookie[] cookies = request.getCookies();
String url = "";
if (cookies != null) {
  for (Cookie cookie : cookies) {
    if ("id".equals(cookie.getName())) {
      id = cookie.getValue();
    }
  }
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<%=application.getContextPath() %>/css/w3.css">
<link rel="stylesheet" href="<%=application.getContextPath() %>/css/common.css">
<link rel="stylesheet" href="<%=application.getContextPath() %>/css/board.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<title>index</title>
</head>
<body class="w3-light-grey">
<div class="w3-content" style="max-width:1400px">

<jsp:include page="../modules/nav.jsp" />
<jsp:include page="../modules/header.jsp" />

<div class="w3-container">
  <!-- Blog entry -->
  <div class="w3-card-4 w3-margin w3-white w3-animate-zoom">
    <form class="w3-container w3-card-4" action="<%=application.getContextPath()%>/board/regist.do" method="post">
      <input type="hidden" name="id" value="<%=id%>">
      <h2 class="w3-text-red">게시글 작성</h2>
      <hr>
      <p>      
        <label class="w3-text-red"><b>글제목</b></label>
        <input class="w3-input w3-border" name="subject" type="text">
      </p>
      <p>      
        <label class="w3-text-red"><b>작성자</b></label>
        <input class="w3-input w3-border" name="writer" type="text">
      </p>
      <p>
        <label class="w3-text-red"><b>내용</b></label>
        <textarea name="content" class="board-regist-ta" rows="10" cols="100" style="resize:none;"></textarea>
      </p>
       <p class="w3-cell">      
        <label class="w3-text-red"><b>비밀번호</b></label>
        <input class="w3-input w3-border" name="passwd" type="password">
      </p>
      <p>      
        <button class="w3-btn w3-red">등록하기</button>
      </p>
    </form>
  </div>
</div>

<jsp:include page="../modules/footer.jsp" />

</div>
</body>
</html>