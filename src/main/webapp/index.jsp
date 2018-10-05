
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>JAX-RS testing field</title>
  </head>
  <body>
  <a href="${pageContext.request.contextPath}resources/people">people</a>
  <a href="${pageContext.request.contextPath}resources/books">books</a>

  <form action="${pageContext.request.contextPath}resources/books/form" method="POST">
    <input type="text" name="message" placeholder="message"/>
    <input type="number" name="number" placeholder="number" />
    <input type="submit" value="Send" />
  </form>
  </body>
</html>
