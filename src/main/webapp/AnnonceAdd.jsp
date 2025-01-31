<%--
  Created by IntelliJ IDEA.
  User: xiang
  Date: 31/01/2025
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Annonce Add</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h1 class="mb-4">Ajouter une annonce</h1>

        <form method="post" action="add">
            <div class="mb-3">
                <label for="title" class="form-label">Titre:</label>
                <input type="text" class="form-control" id="title" name="title" required>
            </div>

            <div class="mb-3">
                <label for="description" class="form-label">Description:</label>
                <textarea class="form-control" id="description" name="description" required></textarea>
            </div>

            <div class="mb-3">
                <label for="adress" class="form-label">Adresse:</label>
                <input type="text" class="form-control" id="adress" name="adress" required>
            </div>

            <div class="mb-3">
                <label for="mail" class="form-label">Email:</label>
                <input type="email" class="form-control" id="mail" name="mail" required>
            </div>

            <button type="submit" class="btn btn-primary">Ajouter</button>
        </form>

        <br>
        <a href="liste" class="btn btn-secondary">Retour à la liste des annonces</a>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>