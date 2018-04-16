<%@page import="java.util.Map"%>
<%@page import="kr.or.blog.article.domain.Article"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
  String id = null;
  Cookie[] cookies = request.getCookies();
  for (Cookie cookie : cookies) {
    if ("id".equals(cookie.getName())) {
      id = cookie.getValue();
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
    <form id="frmReg" class="w3-container w3-card-4" action="<%=application.getContextPath()%>/article/attachUpload.do" method="post" enctype="multipart/form-data">
      <input type="hidden" name="writer" value="<%=id%>">
      <h2 class="w3-text-red">파일 업로드</h2>
      <hr>
      <p>      
        <label class="w3-text-red"><b>작성자</b></label> </p>
        <div class="w3-input w3-border"><%=id %></div>
        <span id="warning" class="warning"></span>
      <p>
        <label class="w3-text-red"><b>내용</b></label>
      </p>
      <p> 
        <input type="file" name="upfile" class="w3-btn w3-red">
        <span id="warning" class="warning"></span>
      </p>
      <p>
        <input type="submit" value="올리기" class="w3-btn w3-red">
      </p>
    </form>
  </div>
</div>

<jsp:include page="../modules/footer.jsp" />

</div>
</body>
</html>