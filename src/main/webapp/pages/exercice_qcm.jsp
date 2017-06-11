<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c2" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.1/css/materialize.min.css">
  <link href="/css/style.css" type="text/css" rel="stylesheet"/>
  <link href="/css/cours.css" type="text/css" rel="stylesheet"/>
  <link href="/css/exercice.css" type="text/css" rel="stylesheet"/>
  <link href="/css/exercice_qcm.css" type="text/css" rel="stylesheet"/>
  <!--Let browser know website is optimized for mobile-->
  <link rel="icon" type="image/png" href="/img/favicon.png"/>
  <title> Code </title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
</head>
<body>

<%@include file="header.jsp" %>

<div class="container-full valign-wrapper">
  <div class="navigation-wrapper">
    <a class="next waves-effect waves-purple btn-flat" href="./exercice2.html"> <i class="material-icons right">chevron_right</i>
      Exercice suivant </a>
  </div>

  <div class="projet-titre row">
    <h3 class="left-align h4-margin">Exercice 1</h3>
  </div>

  <div class="card exo-card">
    <h4>Choisissez la bonne réponse</h4>

    <h5>Quel est l'outil permettant de binder les données aux templates?</h5>
    <form action="#">
      <p>
        <input name="group1" type="radio" id="1"/>
        <label for="1">Les chevrons <></label>
      </p>
      <p>
        <input name="group1" type="radio" id="2"/>
        <label for="2">Les moustaches {}</label>
      </p>
      <p>
        <input name="group1" type="radio" id="3"/>
        <label for="3">Point d'intérrogation <\? ></label>
      </p>
      <p>
        <input name="group1" type="radio" id="4"/>
        <label for="4">Arobase @</label>
      </p>
    </form>

    <div class="answers">
      <div class="card-panel teal" id="m1">
        <span class="white-text">
        <i class="material-icons">done</i>
          Réponse correcte =)
        </span>
      </div>
      <div class="card-panel red" id="m2">
        <span class="white-text">
          <i class="material-icons">close</i>
          Réponse correcte =)
        </span>
      </div>
      <div class="card-panel red" id="m3">
        <span class="white-text">
          <i class="material-icons">close</i>
          Réponse correcte =)
        </span>
      </div>
      <div class="card-panel red" id="m4">
        <span class="white-text">
          <i class="material-icons">close</i>
          Réponse correcte =)
        </span>
      </div>
    </div>

  </div>
</div>

<footer class="page-footer">
  <div class="container">
    <div class="row">
      <div class="col l6 s12">
        <p class="grey-text text-lighten-4">Projet de Logiciels Educatifs.
          Andope vous permet d'apprendre les nouveaux frameworks front-end web de manière intuitive grace à son
          système de
          guidage.
        </p>
      </div>
    </div>
  </div>
  <div class="footer-copyright">
    <div class="container">
      © AndOpe, Tous droits résérvés
      <a class="grey-text text-lighten-4 right" href="http://www.univ-lyon1.fr/">Université Lyon I</a>
    </div>
  </div>
</footer>
<script type="text/javascript" src="/js/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.1/js/materialize.min.js"></script>
<script type="text/javascript" src="/js/init.js"></script>
<script type="text/javascript" src="/js/server_request.js"></script>
<script type="text/javascript" src="/js/exercice_qcm.js"></script>
</body>
</html>