<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Manager</title>
</head>
<body>
<h2>User management</h2>

<form action="resources/users" method="POST">
    <input type="text" name="firstName" placeholder="First name"/><br/>
    <input type="text" name="lastName" placeholder="Last name"/><br/>
    <input type="text" name="telephone" placeholder="Telephone"/><br/>
    <input type="text" name="pesel" placeholder="PESEL"/><br/>
    <p>Additional info</p>
    <input type="text" name="address" placeholder="Address"/><br/>
    <select name="country">
        <option>Poland</option>
        <option>Germany</option>
        <option>France</option>
        <option>USA</option>
    </select><br/>
    <input type="submit" value="Add"/>
</form>
<a href="users">User list</a>


<form method="post" action="/message-servlet">
    <input type="text" name="title" placeholder="title">
    <input type="text" name="content" placeholder="content">
    <input type="submit" value="validate">
</form>
</body>
</html>