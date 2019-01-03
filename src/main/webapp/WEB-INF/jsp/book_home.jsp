<%@ page import="org.apache.shiro.SecurityUtils" %>
<%@ page import="org.apache.shiro.subject.Subject" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

欢迎您来到我的书店。

<shiro:authenticated>
    当前用户 xxx，登录时间 yyy。
</shiro:authenticated>

<shiro:notAuthenticated>
    请点击登录。
</shiro:notAuthenticated>

<shiro:lacksRole name="admin">
    您需要是 admin 才能进行这个业务
</shiro:lacksRole>

</body>
</html>
