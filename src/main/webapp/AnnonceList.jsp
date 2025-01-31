<%@ page import="entities.Annonce" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: xiang
  Date: 31/01/2025
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste annonce(s)</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1>Liste des Annonces</h1>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Titre</th>
                <th>Description</th>
                <th>Adresse</th>
                <th>Email</th>
                <th>Date</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<Annonce> annonces = (List<Annonce>) request.getAttribute("annonces");
                if (annonces != null) {
                    for (Annonce annonce : annonces) {
            %>
            <tr>
                <td><%= annonce.getTitle() %></td>
                <td><%= annonce.getDescription() %></td>
                <td><%= annonce.getAdress() %></td>
                <td><%= annonce.getMail() %></td>
                <td><%= annonce.getDate() %></td>
                <td>
                    <a href="update?id=<%= annonce.getId() %>" class="btn btn-warning btn-sm">Modifier</a>
                    <a href="delete?id=<%= annonce.getId() %>" class="btn btn-danger btn-sm" onclick="return confirm('Voulez-vous vraiment supprimer cette annonce ?');">Supprimer</a>
                </td>
            </tr>
            <%
                    }
                }
            %>
            </tbody>
        </table>

        <div class="text-center">
            <a href="add" class="btn btn-primary">Ajouter une Annonce</a>
        </div>
    </div>
</body>
</html>
