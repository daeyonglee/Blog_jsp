<%@page import="kr.or.blog.user.domain.User"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.blog.user.dao.JdbcUserDao"%>
<%@page import="kr.or.blog.common.dao.DaoFactory"%>
<%@page import="kr.or.blog.user.dao.UserDao"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
  // Users 테이블 조회 후 회원가입 시 아이디와 이메일이 존재하는지 체크
  UserDao dao = (UserDao) DaoFactory.getInstance().getDao(JdbcUserDao.class);
  List<User> list = dao.listAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- css -->
<link rel="stylesheet" href="../css/w3.css">
<link rel="stylesheet" href="../css/common.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">

<script type="text/javascript">
	var arrUser = [];
	<%
      for (int i=0; i<list.size(); i++) {
    %>
      arrUser.push({
    	  'id': '<%= list.get(i).getId()%>',
    	  'email': '<%= list.get(i).getEmail()%>'
      });
    <%    
      }
    %>
	
    console.log(arrUser);
    
</script>

<!-- javascript -->
<script type="text/javascript" src="<%=application.getContextPath()%>/js/user/join.js"></script>
<title>join</title>
</head>
<body class="w3-light-grey">
<div class="w3-content" style="max-width:1400px">
  <div class="w3-container">
    <div class="w3-container w3-white w3-padding-large" style="width: 500px; margin:16px auto;">
      <div class="w3-panel w3-blue">
        <h2>회원가입</h2>
      </div>
      <hr>
      <form class="w3-container" method="post" action="<%=application.getContextPath()%>/login.do">
        <p>
        <label>ID</label>
        <input class="w3-input" type="text" name="id" placeholder="영어,한글 4~8자">
        <span class="warning"></span></p>
        <p>
        <label>PASSWORD</label>
        <input class="w3-input" type="password" name="passwd" placeholder="영어,한글 4~8자">
        <span class="warning"></span></p>
        <p>
        <label>NAME</label>
        <input class="w3-input" type="text" name="name" placeholder="2~20자">
        <span class="warning"></span></p>
        <p>
        <label>EMAIL </label>
        <input class="w3-input" type="email" name="email" placeholder="xxx@xxx.xxx">
        <span class="warning"></span></p>
        <p>
        <label>TELEPHONE</label>
        <input class="w3-input" type="tel" name="telephone" placeholder="010-0000-0000">
        <span class="warning"></span></p>
        <p>
      	<input class="w3-btn w3-block w3-red" type="submit" value="가입하기"></p>
      </form>
    </div>
  </div>
<jsp:include page="../modules/footer.jsp" />
</div>
</body>
</html>