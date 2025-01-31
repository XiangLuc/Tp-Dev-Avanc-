<%--
  Created by IntelliJ IDEA.
  User: xiang
  Date: 31/01/2025
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
    <h1>Hello the world</h1>

    <form method="post" action="hello">
        <label for="name">Entrez votre nom :</label>
        <input type="text" id="name" name="name" required>
        <button type="submit">Envoyer</button>
    </form>

    <% String name = request.getParameter("name"); %>
    <% if (name != null && !name.isEmpty()) { %>
    <h2>Hello the World <%= name %></h2>
    <% } %>

</body>
</html>