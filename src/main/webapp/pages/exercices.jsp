<!DOCTYPE html>
<%@ taglib prefix="c2" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.1/css/materialize.min.css">
  <link href="/css/style.css" type="text/css" rel="stylesheet"/>
  <link href="/css/cours.css" type="text/css" rel="stylesheet"/>
  <!--Let browser know website is optimized for mobile-->
  <link rel="icon" type="image/png" href="./img/favicon.png"/>
  <title> Code </title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
</head>

<body>

<%@include file="nav.jsp" %>

<div class="container-full">
  <div class="projet-titre row">
    <h4 class="left-align h4-margin">Exercices</h4>
  </div>
  <c:if test="${user.getPseudo().equals('root')}">
    <a class="waves-effect waves-light btn" href="/addexercice/cours/${cours.getIdCours()}/"><i
            class="material-icons right">add</i> Ajouter un exercice </a>
  </c:if>
  <div class="chapitres-container">
    <c:forEach items="${exercices}" var="item">
      <div class="card">
        <a href="../html_files/${item.getChapitreByIdC.getCoursByIdCours().getIdCours()}/exercices/${item.getPath()}"> ${item.getTitle()} </a>
      </div>
    </c:forEach>
  </div>

</div>

<%@include file="footer.jsp" %>

<script type="text/javascript" src="/js/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.1/js/materialize.min.js"></script>
<script type="text/javascript" src="/js/server_request.js"></script>
<script type="text/javascript" src="/js/init.js"></script>
<script type="text/javascript" src="/js/login.js"></script>
</body>
</html>
