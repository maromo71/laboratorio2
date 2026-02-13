<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Primeira página web</title>
</head>
<body>
    <h2>Olá</h2>
    <%
        String nome = "Maromo";
        java.util.Date data = new java.util.Date();

    %>
    <h3>Fala <%= nome %>, hoje é <%= data %> </h3>

    <a href="pagina01.html">Clique para acessar a página 01</a>
</body>
</html>
