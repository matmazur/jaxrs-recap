<%--
  Created by IntelliJ IDEA.
  User: matma
  Date: 07.10.2018
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of users</title>
</head>
<body>

<h3>Users:</h3>

<ul>
    <c:forEach items="${users}" var="user">
        <li><c:out value="${user}"/></li>
    </c:forEach>
</ul>
</body>
</html>
