<!DOCTYPE html>
<%@ taglib prefix="c2" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.1/css/materialize.min.css">
  <link href="/css/style.css" type="text/css" rel="stylesheet"/>
  <link href="<c2:url value = "/css/manage_project.css" />" type="text/css" rel="stylesheet"/>
  <!--Let browser know website is optimized for mobile-->
  <link rel="icon" type="image/png" href="/img/favicon.png"/>
  <title> Code </title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
</head>

<body>

<nav class="white" role="navigation">
  <div class="nav-wrapper container">
    <a id="logo-container" href="/" class="brand-logo">
      <img src="/img/Logo_IDE.png">
    </a>
    <ul class="right hide-on-med-and-down">
      <li class="active-tab"><a href="/cours">Mes Projets</a></li>
      <li><a href="./account.jsp">Mon Compte</a></li>
      <li><a href="./parameters.jsp">Paramètres</a></li>
      <li><a href="/api/logout">Déconnexion</a></li>
    </ul>

    <ul id="nav-mobile" class="side-nav">
      <li class="active-tab"><a href="./manage_project.jsp">Mes Projets</a></li>
      <li><a href="./account.jsp">Mon Compte</a></li>
      <li><a href="./parameters.jsp">Paramètres</a></li>
      <li><a href="/api/logout">Déconnexion</a></li>
    </ul>
    <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
  </div>
</nav>

<div class="container-full">
  <div class="projet-titre row">
    <h4 class="left-align h4-margin">Cours disponibles</h4>
  </div>

  <div class="row row-cards">
    <div class="cards defaut-color">
      <c:if test="${user.getPseudo().equals('root')}">
        <a href="/addcours">Ajouter un cours</a>
      </c:if>
      <c:forEach items="${cours}" var="item">
        <div class="card col s4 sticky-action cours">
          <div class="card-image waves-effect waves-block waves-light">
            <img class="activator" src="${item.getImage()}">
          </div>
          <div class="card-content">
          <span class="card-title activator grey-text text-darken-4">${item.getTitle()}<i
                  class="material-icons right">more_vert</i></span>
          </div>

          <div class="card-action">
            <a href="/chapitre?idCours=${item.getIdCours()}">Cours</a>
            <a href="/exercice?idChapitre=${item.getIdCours()}">Exercices</a>
          </div>

          <div class="card-reveal">
            <span class="card-title grey-text text-darken-4">${item.getTitle()}<i class="material-icons right">close</i></span>
            <p>${item.getDescription()}<%--Vue est un framework évolutif pour construire des interfaces
              utilisateur. À la différence des autres frameworks monolithiques, Vue a été conçu et pensé pour pouvoir être
              adopté de manière incrémentale. Le cœur de la bibliothèque est concentré uniquement sur la partie vue, et il
              est vraiment simple de l’intégrer avec d’autres bibliothèques ou projets existants. D’un autre côté, Vue est
              tout à fait capable de faire tourner des applications web monopages quand il est couplé avec des outils
              modernes et des bibliothèques complémentaires.--%></p>
          </div>
        </div>
      </c:forEach>


    </div>
  </div>
</div>

<%@include file="footer.jsp" %>

<script type="text/javascript" src="/js/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.1/js/materialize.min.js"></script>
<script type="text/javascript" src="/js/server_request.js"></script>
<script type="text/javascript" src="/js/init.js"></script>
</body>
</html>
