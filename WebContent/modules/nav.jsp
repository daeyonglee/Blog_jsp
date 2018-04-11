<%@ page contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="user" class="kr.or.blog.user.domain.User" scope="request" />
<%
  Cookie[] cookies = request.getCookies();
  String url = "";
  if (cookies != null) {
    for (Cookie cookie : cookies) {
      if ("id".equals(cookie.getName())) {
        user.setId(cookie.getValue());
      }
    }
  }
%>
<div class="w3-bar w3-black w3-hide-small">
  <a href="<%=application.getContextPath() %>/index.jsp" class="w3-bar-item w3-button">HOME</a>
  <a href="<%=application.getContextPath() %>/visitors/list.do" class="w3-bar-item w3-button">방명록</a>
  <a href="<%=application.getContextPath() %>/article/list.do" class="w3-bar-item w3-button">자유게시판</a>
  <a href="<%=application.getContextPath() %>/article/attachList.do" class="w3-bar-item w3-button">자료실</a>
  <%
  	if (user.getId() == null) {
  %>
  <button onclick="document.getElementById('login').style.display='block'; document.getElementsByName('id')[0].focus()" class="w3-button w3-hover w3-border-white w3-hover-border-black w3-right">로그인</button>
  <%		
  	} else {
  %>
  <button id="logout" class="w3-button w3-hover w3-border-white w3-hover-border-black w3-right" onclick="document.forms[0].submit()">로그아웃</button>
  <form action="<%=application.getContextPath()%>/logout.do" method="get">
    <input type="hidden" name="id" value="id">
    <input type="hidden" name="url" value="<%= request.getRequestURI()%>">
  </form>
  <%
  	}
  %>
    <div id="login" class="w3-modal w3-animate-opacity">
      <div class="w3-modal-content w3-card-4" style="width:30%;">
        <!-- 로그인 -->
        <div class="w3-center"><br>
          <span onclick="document.getElementById('login').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright w3-text-black" title="Close Modal">&times;</span>
        </div>
        <div class="w3-container">
          <form class="w3-container" action="<%=application.getContextPath() %>/login.do" method="get">
            <input type="hidden" name="url" value="<%= request.getRequestURI()%>">
            <div class="w3-left-align w3-text-black"><p>ID</p></div>
            <p><input class="w3-input" type="text" name="id"></p>
            <div class="w3-left-align w3-text-black"><p>PASSWORD</p></div>
            <p><input class="w3-input" type="password" name="passwd"></p>
            <p>
            <button class="w3-button w3-border w3-hover-indigo w3-text-black" style="width: 100%;">로그인</button>
            </p>
            <p class="w3-text-blue w3-hover-indigo" onclick="window.location.href='<%=application.getContextPath()%>/user/search.jsp'">아이디/비밀번호 찾기</p>
            <p class="w3-text-blue w3-hover-indigo" onclick="window.location.href='<%=application.getContextPath()%>/user/join.jsp'">회원가입</p>
          </form>
        </div>
      </div>
    </div>
</div>