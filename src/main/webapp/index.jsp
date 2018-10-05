<%--
  Created by IntelliJ IDEA.
  User: matma
  Date: 03.10.2018
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="rest-api/resources/people">people</a>
  <a href="/rest-api/resources/books">books</a>

  <form action="resources/books/form" method="POST">
    <input type="text" name="message" placeholder="message"/>
    <input type="number" name="number" placeholder="number" />
    <input type="submit" value="Send" />
  </form>
  </body>
</html>
