<%@ page import="kr.or.blog.board.domain.Params"%>
<%@ page import="kr.or.blog.board.domain.Article"%>
<%@ page import="java.util.List"%>
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
  
  List<Article> list = (List<Article>)request.getAttribute("list");
  Params params = (Params)request.getAttribute("params");
  int curPage = (int)request.getAttribute("page");
  int startPage = (int)request.getAttribute("startPage");
  int endPage = (int)request.getAttribute("endPage");
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
    <div class="w3-container" style="margin-bottom: 10px;">
      <%
        if (id != null) {
      %>
      <a href="regist.jsp" class="w3-button w3-right w3-red board-regist-btn">글쓰기</a>
      <%    
        }
      %>
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
      <%
        for (Article article : list) {
      %> 
        <tr>
          <td><%= article.getArticleId() %></td>
          <td><a class="board-detail-tt" href="<%= application.getContextPath()%>/board/detail.do?article_id=<%=article.getArticleId()%>"><%= article.getSubject() %></a></td>
          <td><%= article.getWriter() %></td>
          <td><%= article.getRegdate() %></td>
          <td><%= article.getHitcount()%></td>
        </tr>
      <%     
        }
      %>
    </table>
    <hr>
    <div class="w3-container">
      <div class="w3-center">
        <div class="w3-bar w3-border">
            <a href="<%=application.getContextPath() %>/board/list.do?page=1" class="w3-bar-item w3-button">&laquo;&laquo;</a>
            <%
              if (startPage == 1) {
            %>
            <a href="<%=application.getContextPath() %>/board/list.do?page=1" class="w3-bar-item w3-button">&laquo;</a>
            <%	  
              } else {
            %>
            <a href="<%=application.getContextPath() %>/board/list.do?page=<%=startPage-10 %>" class="w3-bar-item w3-button">&laquo;</a>
            <%   
              }
            %>
            <%
              if (params.getPageNum() > 0) {
                for (int i=startPage; i<=endPage; i++) {
                  if (i == curPage) {
            %>
              <a href="<%=application.getContextPath() %>/board/list.do?page=<%=i %>&" class="w3-bar-item w3-button w3-red"><%=i%></a>
            <%        
                  } else {
            %>
              <a href="<%=application.getContextPath() %>/board/list.do?page=<%=i %>" class="w3-bar-item w3-button"><%=i%></a>
            <%       
                  }
                }
              } else {
            %>
              <a href="#" class="w3-bar-item w3-button">1</a>
            <%         	  
              }
            %>
            <a href="<%=application.getContextPath() %>/board/list.do?page=<%=startPage+10 %>" class="w3-bar-item w3-button">&raquo;</a>
            <a href="<%=application.getContextPath() %>/board/list.do?page=<%=params.getPageNum() %>" class="w3-bar-item w3-button">&raquo;&raquo;</a>
        </div>
      </div>
    </div>
  </div>
</div>

<jsp:include page="../modules/footer.jsp" />

</div>
</body>
</html>