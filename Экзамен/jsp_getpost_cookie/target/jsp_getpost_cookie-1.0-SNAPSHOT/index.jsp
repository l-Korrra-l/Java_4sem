<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
${cookie['cookie'].getValue()}
<form action="Servlet1" method="get">
    <br>
    <input type="submit" value="GET"/>
</form>
<form action="Servlet1" method="post">
    <br>
    <input type="submit" value="POST"/>
</form>
</body>
</html>
