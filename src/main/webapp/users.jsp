<%--
  Created by IntelliJ IDEA.
  User: matma
  Date: 07.10.2018
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<html>
<head>
    <title>List of users</title>
</head>
<body>

<h3>Users:</h3>

<ul>
    <% if (request.getAttribute("users") != null) {%>
    <c:forEach var="user" items="${users}" varStatus="loop">
        <li><c:out value="${user}"/></li>
    </c:forEach>
    <%}%>
</ul>
</body>
</html>
