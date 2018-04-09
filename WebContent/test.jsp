<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>
Context : <%= request.getContextPath() %>

URL : <%= request.getRequestURL() %>

URI : <%= request.getRequestURI() %>

Path : <%= request.getServletPath() %>

</body>
</html>