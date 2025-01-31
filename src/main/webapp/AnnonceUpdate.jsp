<%--
  Created by IntelliJ IDEA.
  User: xiang
  Date: 31/01/2025
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="entities.Annonce" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Modifier annonce</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <div class="container">
    <h1 class="mt-4">Modifier une Annonce</h1>

    <%
      Annonce annonce = (Annonce) request.getAttribute("annonce");
      if (annonce == null) {
    %>
    <div class="alert alert-danger">Aucune annonce trouvée.</div>
    <%
    } else {
    %>

    <form method="post" action="update" class="mt-3">
      <input type="hidden" name="id" value="<%= annonce.getId() %>">

      <div class="mb-3">
        <label for="title" class="form-label">Titre:</label>
        <input type="text" class="form-control" id="title" name="title" value="<%= annonce.getTitle() %>" required>
      </div>

      <div class="mb-3">
        <label for="description" class="form-label">Description:</label>
        <textarea class="form-control" id="description" name="description" required><%= annonce.getDescription() %></textarea>
      </div>

      <div class="mb-3">
        <label for="adress" class="form-label">Adresse:</label>
        <input type="text" class="form-control" id="adress" name="adress" value="<%= annonce.getAdress() %>" required>
      </div>

      <div class="mb-3">
        <label for="mail" class="form-label">Email:</label>
        <input type="email" class="form-control" id="mail" name="mail" value="<%= annonce.getMail() %>" required>
      </div>

      <button type="submit" class="btn btn-success">Mettre à jour</button>
      <a href="liste" class="btn btn-secondary">Retour à la liste</a>
    </form>

    <%
      }
    %>
  </div>
</body>
</html>