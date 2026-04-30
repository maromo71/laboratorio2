<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Calculadora IMC</title>
    </head>
    <body>
        <h2>Resultado do IMC</h2> 
        <%
            double peso = Double.parseDouble(request.getParameter("peso"));
            double altura = Double.parseDouble(request.getParameter("altura"));
            double imc = peso / (altura * altura);
        %>
        <c:set var="imc" value="<%=imc%>"/>

        <p>Resultado: <c:out value="${imc}" /></p>


        <h2>Classificação do IMC</h2>
        <c:if test="${imc < 18.5}">
            <p style="color: blue;">Abaixo do peso</p>
        </c:if>

        <c:if test="${imc >= 18.5 && imc < 25}">
            <p style="color: green;">Peso Normal</p>
        </c:if>

        <c:if test="${imc >= 25 && imc < 30}">
            <p style="color: green;">Sobrepeso</p>
        </c:if>

        <c:if test="${imc >= 30 && imc < 35}">
            <p style="color: red;">Obesidade Grau I</p>
        </c:if>

        <c:if test="${imc >= 35 && imc < 40}">
            <p style="color: red;">Obesidade Grau II</p>
        </c:if>

        <c:if test="${imc >= 40}">
            <p style="color: darkred;">Obesidade Grau III</p>
        </c:if>
    </body>

</html>