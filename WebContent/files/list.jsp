<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<%=application.getContextPath() %>/css/w3.css">
<link rel="stylesheet" href="<%=application.getContextPath() %>/css/common.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<title>index</title>
</head>
<body class="w3-light-grey">
<div class="w3-content" style="max-width:1400px">

<jsp:include page="../modules/nav.jsp" />
<jsp:include page="../modules/header.jsp" />

<div class="w3-container">
  <!-- Blog entry -->
  <div class="w3-card-4 w3-margin w3-white">
    <div class="w3-container" style="margin-bottom: 10px;">
      <a href="regist.jsp" class="w3-button w3-right w3-red board-regist-btn">글쓰기</a>
      <select class="board-select w3-border">
        <option>글제목</option>
        <option>글내용</option>
        <option>작성자</option>
      </select>
      <input type="text" class="board-search w3-white" placeholder="Search..">
      <a href="#" class="w3-button w3-red">검색</a>
    </div>
    <table class="w3-table-all w3-striped">
      <tr class="w3-red">
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회</th>
      </tr>
      <tr>
        <td>3</td>
        <td>안녕하세요3안녕하세요3안녕하세요3안녕하세요3안녕하세요3안녕하세요3안녕하세요3안녕하세요3안녕하세요3안녕하세요3안녕하세요3</td>
        <td>이대용3</td>
        <td>2018-04-06</td>
        <td>11</td>
      </tr>
      <tr>
        <td>2</td>
        <td>안녕하세요</td>
        <td>이대용2</td>
        <td>2018-04-06</td>
        <td>11</td>
      </tr>
      <tr>
        <td>1</td>
        <td>안녕하세요1</td>
        <td>이대용</td>
        <td>2018-04-06</td>
        <td>11</td>
      </tr>
    </table>
    <hr>
    <div class="w3-container">
      <div class="w3-center">
        <div class="w3-bar w3-border">
            <a href="#" class="w3-bar-item w3-button">&laquo;&laquo;</a>
            <a href="#" class="w3-bar-item w3-button">&laquo;</a>
            <a href="#" class="w3-bar-item w3-button">1</a>
            <a href="#" class="w3-bar-item w3-button">2</a>
            <a href="#" class="w3-bar-item w3-button">3</a>
            <a href="#" class="w3-bar-item w3-button">4</a>
            <a href="#" class="w3-bar-item w3-button">&raquo;</a>
            <a href="#" class="w3-bar-item w3-button">&raquo;&raquo;</a>
        </div>
      </div>
    </div>
  </div>
</div>

<jsp:include page="../modules/footer.jsp" />

</div>
</body>
</html>