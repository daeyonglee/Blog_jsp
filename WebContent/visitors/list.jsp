<%@page import="kr.or.blog.visitors.domain.GuestBook"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.blog.user.domain.User"%>
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
	List<GuestBook> list = (List<GuestBook>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<%=application.getContextPath() %>/css/w3.css">
<link rel="stylesheet" href="<%=application.getContextPath() %>/css/common.css">
<link rel="stylesheet" href="<%=application.getContextPath() %>/css/visitors.css">
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
    <form class="w3-container" action="<%=application.getContextPath()%>/visitors/list.do" method="post">
      <input type="hidden" name="id" value="<%=id %>">
      <%
        if (id == null) {
      %>
      <textarea id="contents" name="contents" class="visitors-ta" rows="10" cols="100" style="resize:none;" disabled="disabled">로그인 후 이용해주세요.</textarea>
      <%    
        } else {
      %> 
      <textarea id="contents" name="contents" class="visitors-ta" rows="10" cols="100" style="resize:none;"></textarea>
      <%    
        }
      %>
      <input class="w3-btn w3-black" type="submit" value="글쓰기">
    </form>
  </div>
  <hr>
  <%
  	for (GuestBook guestBook : list) {
  %>
	  <div class="w3-card-4 w3-margin w3-white">
	    
	    <div class="w3-container">
	      <h5><span class="w3-opacity"><%=guestBook.getRegdate() %></span></h5>
	    </div>
	
	    <div class="w3-container">
	      <p><%=guestBook.getContents() %></p>
	      <div class="w3-row">
	        <div class="w3-col m12 w3-hide-small">
	          <p><span class="w3-padding-large w3-right"><b>Comments  </b> <span class="w3-tag">0</span></span></p>
	        </div>
	      </div>
	    </div>
	    
	  </div>
  <%
  	}
  %>
  
</div>

<jsp:include page="../modules/footer.jsp" />

</div>
</body>
</html>