<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/28 0028
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>hello world ${requestScope.name}</h1>
    <form action="/rm/test1" method="post">
        <input type="text" name="name">
        <input type="submit" value="post提交">
    </form>
</body>
</html>
