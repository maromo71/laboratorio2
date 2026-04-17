<%@ page language="java" contentType="text/html; 
    charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Jogador" %>
<%@ page import="dao.JogadorDao" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Lista de Jogadores</title>
</head>
<body>
    <h1>Lista de Jogadores</h1>
    <table>
        <tr>
            <td>Nome do Jogador</td>
            <td>Apeligo do Jogador</td>
            <td>Posicao do Jogador</td>
            <td>Idade do Jogador</td>
        </tr>
        <% 
            JogadorDao dao = new JogadorDao();
            List<Jogador> jogadores = dao.listarJogadores();
            for(Jogador jogador : jogadores){ 
            %> 
            <tr>
                <td><%= jogador.getNome() %></td>
                <td><%= jogador.getApelido() %></td>
                <td><%= jogador.getPosicao() %></td>
                <td><%= jogador.getIdade() %></td>
            </tr>
        <% } %>
    </table>
</body>
</html>