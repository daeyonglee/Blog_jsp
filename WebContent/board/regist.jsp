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
    <form class="w3-container w3-card-4" action="/action_page.php">
      <h2 class="w3-text-red">게시글 작성</h2>
      <hr>
      <p>      
        <label class="w3-text-red"><b>글제목</b></label>
        <input class="w3-input w3-border" name="first" type="text">
      </p>
      <p>      
        <label class="w3-text-red"><b>작성자</b></label>
        <input class="w3-input w3-border" name="last" type="text">
      </p>
      <p>
        <label class="w3-text-red"><b>내용</b></label>
        <textarea class="board-regist-ta" rows="10" cols="100" style="resize:none;"></textarea>
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