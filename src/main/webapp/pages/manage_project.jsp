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
  <link href="/css/manage_project.css" type="text/css" rel="stylesheet"/>
  <!--Let browser know website is optimized for mobile-->
  <link rel="icon" type="image/png" href="/img/favicon.png"/>
  <title> Code </title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
</head>

<body>

<%@include file="header.jsp" %>

<div class="container-full">
  <div class="projet-titre">
    <h4 class="left-align h4-margin">Cours disponibles</h4>
    <c:if test="${user.getPseudo().equals('root')}">
      <a class="waves-effect waves-light btn" href="/addcours"><i
           class="material-icons right">add</i> Ajouter un cours</a>
    </c:if>
  </div>

  <div class="row row-cards">
    <div class="cards defaut-color">
      <c:forEach items="${cours}" var="item" varStatus="myIndex">
        <div class="card col s4 sticky-action cours">
          <div class="card-image waves-effect waves-block waves-light">
            <c:choose>
              <c:when test="${item.getImage() != ' '}">
                <img class="activator" src="${item.getImage()}">
              </c:when>
              <c:otherwise>
                <img class="activator" src="/img/Fiverr.png">
              </c:otherwise>
            </c:choose>
          </div>
          <div class="card-content">
          <span class="card-title activator grey-text text-darken-4">${item.getTitle()}<i
               class="material-icons right">more_vert</i></span>
          </div>

          <div class="card-action loader-container">
            <div id="container_${myIndex.index}"></div>
          </div>

          <div class="card-action">
            <a href="/chapitre/cours/${item.getIdCours()}">Cours</a>
            <a href="/exercice/cours/${item.getIdCours()}">Exercices</a>
          </div>


          <div class="card-reveal">
            <span class="card-title grey-text text-darken-4">${item.getTitle()}<i class="material-icons right">close</i></span>
            <p>${item.getDescription()}</p>
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
<script type="text/javascript" src="/js/progressbar.min.js"></script>
<script type="text/javascript" src="/js/manage_project.js"></script>

</body>
</html>
