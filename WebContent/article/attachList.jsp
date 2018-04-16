<%@page import="java.util.Map"%>
<%@page import="kr.or.blog.article.domain.Article"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
  List<Map<String, Object>> list = (List<Map<String, Object>>)request.getAttribute("list");
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
    <div class="w3-container" style="margin-bottom: 10px;">
      <a href="<%=application.getContextPath()%>/article/attachUpload.jsp" class="w3-button w3-right w3-red board-regist-btn">파일업로드</a>
    </div>
    <table class="w3-table-all w3-striped">
      <tr class="w3-red">
        <th>번호</th>
        <th>파일명</th>
        <th>파일크기</th>
        <th>작성자</th>
        <th>다운로드</th>
      </tr>
      <%
        for (Map<String, Object> map : list) {
          Article article = (Article)map.get("article");
      %>
      <tr>
        <td><%=article.getArticleId() %></td>
        <td><%=article.getAttachFile() %></td>
        <td><%=map.get("fileSize") %></td>
        <td><%=article.getWriter() %></td>
        <td><a class="w3-button w3-black board-regist-btn" href="<%=application.getContextPath()%>/article/attachDownload.do?file=<%=article.getAttachFile()%>">다운로드</a></td>
      </tr>
      <%    
        }
      %>
    </table>
    <hr>
    <!-- <div class="w3-container">
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
    </div> -->
  </div>
</div>

<jsp:include page="../modules/footer.jsp" />

</div>
</body>
</html>