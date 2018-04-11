<%@page import="kr.or.blog.article.domain.Article"%>
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
<%
  Article article = (Article)request.getAttribute("article");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<%=application.getContextPath() %>/css/w3.css">
<link rel="stylesheet" href="<%=application.getContextPath() %>/css/common.css">
<link rel="stylesheet" href="<%=application.getContextPath() %>/css/aritcle.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<title>index</title>
<script type="text/javascript" src="<%=application.getContextPath()%>/js/article/regist.js"></script>
</head>
<body class="w3-light-grey">
<div class="w3-content" style="max-width:1400px">

<jsp:include page="../modules/nav.jsp" />
<jsp:include page="../modules/header.jsp" />

<div class="w3-container">
  <!-- Blog entry -->
  <div class="w3-card-4 w3-margin w3-white w3-animate-zoom">
    <form id="frmReg" class="w3-container w3-card-4" action="<%=application.getContextPath()%>/article/regist.do" method="post">
      <input type="hidden" name="writer" value="<%=id%>">
      <h2 class="w3-text-red">게시글 작성</h2>
      <hr>
      <p>      
        <label class="w3-text-red"><b>글제목</b></label>
        <% if (article != null) {
        %>
        <input type="hidden" name="articleId" value="<%=article.getArticleId()%>">
        <input type="hidden" name="groupNo" value="<%=article.getGroupNo() %>">
        <input type="hidden" name="levelNo" value="<%=article.getLevelNo() %>">
        <input type="hidden" name="orderNo" value="<%=article.getOrderNo() %>">
        <input class="w3-input w3-border" name="subject" type="text" value='<%="[RE]"+article.getSubject() %>'>
        <%	
        } else {
        %>
        <input class="w3-input w3-border" name="subject" type="text">
        <% 
        }
        %>
        <span id="warning" class="warning"></span>
      </p>
      <p>      
        <label class="w3-text-red"><b>작성자</b></label> </p>
        <div class="w3-input w3-border"><%=id %></div>
        <span id="warning" class="warning"></span>
      <p>
        <label class="w3-text-red"><b>내용</b></label>
        <textarea name="content" class="board-regist-ta" rows="10" cols="100" style="resize:none;"></textarea>
        <span id="warning" class="warning"></span>
      </p>
       <p class="w3-cell">      
        <label class="w3-text-red"><b>비밀번호</b></label>
        <input class="w3-input w3-border" name="passwd" type="password">
        <span id="warning" class="warning"></span>
      </p>
      <p>
        <input type="submit" value="등록하기" class="w3-btn w3-red">
      </p>
    </form>
  </div>
</div>

<jsp:include page="../modules/footer.jsp" />

</div>
</body>
</html>