<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c2" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.1/css/materialize.min.css">
  <link href="../css/style.css" type="text/css" rel="stylesheet"/>
  <link href="../css/ajout_cours.css" type="text/css" rel="stylesheet"/>
  <!--Let browser know website is optimized for mobile-->
  <link rel="icon" type="image/png" href="../img/favicon.png"/>
  <title> Code </title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
</head>

<body>

<nav class="white" role="navigation">
  <div class="nav-wrapper container">
    <a id="logo-container" href="#" class="brand-logo">
      <img src="../img/Logo_IDE.png">
    </a>
    <ul class="right hide-on-med-and-down">
      <li class="active-tab"><a href="manage_project.html">Mes Projets</a></li>
      <li><a href="./account.html">Mon Compte</a></li>
      <li><a href="./parameters.html">Paramètres</a></li>
      <li><a href="index.html">Déconnexion</a></li>
    </ul>

    <ul id="nav-mobile" class="side-nav">
      <li class="active-tab"><a href="manage_project.html">Mes Projets</a></li>
      <li><a href="./account.html">Mon Compte</a></li>
      <li><a href="./parameters.html">Paramètres</a></li>
      <li><a href="index.html">Déconnexion</a></li>
    </ul>
    <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
  </div>
</nav>

<div class="container-full">
  <div class="projet-titre row">
    <h4 class="left-align h4-margin">Ajouter un cours</h4>
  </div>

  <div class="form-container">
    <div class="chapitres-container">
        <div class="row">
          <div class="input-field">
            <input type="text" id="url" name="image" required class="validate">
            <label>Url de l'image</label>
          </div>
        </div>

        <div class="row">
          <div class="input-field">
            <input type="text" id="title" name="title" required class="validate">
            <label>Titre</label>
          </div>
        </div>

        <div class="row">
          <div class="input-field">
            <textarea name="description" id="description" class="materialize-textarea"></textarea>
            <label for="textarea1">Description</label>
          </div>
        </div>

        <div class="row">
          <div class="input-field">
            <input type="text" name="nbExercices" id="nbExercices" required class="validate">
            <label>Nombre d'exercices</label>
          </div>
        </div>

        <div class="row btn-row">
          <button type="submit" class="waves-effect waves-light btn" id="create-course"><i
               class="material-icons right">done_all</i>Créer
            cours
          </button>
        </div>
    </div>

  </div>

</div>

<%@include file="footer.jsp" %>

<script type="text/javascript" src="../js/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.1/js/materialize.min.js"></script>
<script type="text/javascript" src="../js/server_request.js"></script>
<script type="text/javascript" src="../js/init.js"></script>
<script type="text/javascript" src="../js/add_cours.js"></script>
</body>
</html>
