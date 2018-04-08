<%@ page contentType="text/html; charset=UTF-8"%>
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
    <div class="w3-container w3-card-4">
      <h2 class="w3-text-red">게시글 상세</h2>
      <hr>
      <p>      
        <label class="w3-text-red"><b>글제목</b></label></p>
        <div class="w3-input w3-border">안녕하세요3안녕하세요3안녕하세요3안녕하세요3안녕하세요3안녕하세요3안녕하세요3안녕하세요3안녕하세요3안녕하세요3안녕하세요3</div>
      <p>      
        <label class="w3-text-red"><b>작성자</b></label></p>
        <div class="w3-input w3-border">이대용3</div>
      <p>
        <label class="w3-text-red"><b>내용</b></label></p>
        <div class="w3-input w3-border">상세내용입니다.</div>
      <p>      
        <button class="w3-btn w3-red" onclick="JavaScript:location.href='list.jsp'">글목록</button>
        <button class="w3-btn w3-red">답글쓰기</button>
        <button class="w3-btn w3-red">글수정</button>
      </p>
    </div>
  </div>
</div>

<jsp:include page="../modules/footer.jsp" />

</div>
</body>
</html>