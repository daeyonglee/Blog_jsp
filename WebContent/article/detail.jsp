<%@page import="kr.or.blog.article.domain.Article"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	Article article = (Article)request.getAttribute("article");
    request.setAttribute("article", article);
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
        <div class="w3-input w3-border"><%= article.getSubject() %></div>
      <p>      
        <label class="w3-text-red"><b>작성자</b></label></p>
        <div class="w3-input w3-border"><%= article.getWriter() %></div>
      <p>
        <label class="w3-text-red"><b>내용</b></label></p>
        <div class="w3-input w3-border"><%= article.getContent() %></div>
      <p>      
        <label class="w3-text-red"><b>비밀번호</b></label>
        <div class="w3-cell"><input class="w3-input w3-border" name="passwd" type="password"></div>
      <p>
      <p>      
        <a class="w3-btn w3-red" href="<%=application.getContextPath()%>/article/list.do">글목록</a>
        <a class="w3-btn w3-red" href="<%=application.getContextPath()%>/article/regist.do?article_id=<%=article.getArticleId()%>">답글쓰기</a>
        <a class="w3-btn w3-red" onclick="">글수정</a>
        <a class="w3-btn w3-red" onclick="">글삭제</a>
      </p>
    </div>
  </div>
</div>

<jsp:include page="../modules/footer.jsp" />

</div>
</body>
</html>