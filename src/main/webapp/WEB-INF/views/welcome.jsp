<%--
  Created by IntelliJ IDEA.
  User: www
  Date: 2017/5/27
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>测试@SessionAttributes注解</title>
</head>
<body>
访问request作用范围域中的user对象：${requestScope.user.username }<br>
访问session作用范围域中的user对象：${sessionScope.user.username }<br>
<br>
</body>
</html>
