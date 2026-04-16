<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "java.time.LocalDate" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página JSP</title>
</head>
<body>
    <h1>Olá Turma</h1>
    <h2>Mogi Mirim</h2>
    <%
        String mensagem = "Sejam bem vindos";
        LocalDate data = LocalDate.now();
    %>
    <h2><%=mensagem%></h2>
    <h3>Data: <%=data%> </h3>
</body>
</html>