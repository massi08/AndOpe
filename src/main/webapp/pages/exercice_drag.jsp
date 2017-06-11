<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.1/css/materialize.min.css">
  <link href="/css/style.css" type="text/css" rel="stylesheet"/>
  <link href="/css/cours.css" type="text/css" rel="stylesheet"/>
  <link href="/css/exercice.css" type="text/css" rel="stylesheet"/>
  <link href="/css/exercice_qcm.css" type="text/css" rel="stylesheet"/>
  <link href="/css/exercice_drag.css" type="text/css" rel="stylesheet"/>
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
      <li class="active-tab"><a href="/manage_project.html">Mes Projets</a></li>
      <li><a href="/account.html">Mon Compte</a></li>
      <li><a href="/parameters.html">Paramètres</a></li>
      <li><a href="/index.html">Déconnexion</a></li>
    </ul>

    <ul id="nav-mobile" class="side-nav">
      <li class="active-tab"><a href="/manage_project.html">Mes Projets</a></li>
      <li><a href="/account.html">Mon Compte</a></li>
      <li><a href="/parameters.html">Paramètres</a></li>
      <li><a href="/index.html">Déconnexion</a></li>
    </ul>
    <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
  </div>
</nav>

<div class="container-full valign-wrapper">

  <div class="navigation-wrapper">
    <a class="precedent waves-effect waves-purple btn-flat" href="./exercice1.html"><i class="material-icons left">chevron_left</i>
      Exercice précedant</a>
    <a class="next waves-effect waves-purple btn-flat" href="#"> <i class="material-icons right">chevron_right</i>
      Exercice suivant </a>
  </div>

  <div class="projet-titre row">
    <h3 class="left-align h4-margin">Exercice 2</h3>
  </div>

  <div class="card exo-card">
    <h4>Réarangez ces éléments dans l'ordre</h4>
    <h5>Dans quel ordre sont appelées ces fonctions après la création d'une vue</h5>
    <ul id="sortable">
      <li class="default" id="1">
        <div class="chip">beforeCreate()</div>
      </li>
      <li class="default" id="2">
        <div class="chip">created()</div>
      </li>
      <li class="default" id="3">
        <div class="chip">beforeMount()</div>
      </li>
      <li class="default" id="4">
        <div class="chip">mounted()</div>
      </li>
      <li class="default" id="5">
        <div class="chip">beforeUpdate()</div>
      </li>
      <li class="default" id="6">
        <div class="chip">updated()</div>
      </li>
      <li class="default" id="7">
        <div class="chip">beforeDestroy()</div>
      </li>
      <li class="default" id="8">
        <div class="chip">destroyed()</div>
      </li>
    </ul>

    <div class="validate-button">
      <a class="waves-effect waves-light btn btn-submit" id="submit-drag">Submit</a>
    </div>

    <div class="answers">
      <div class="card-panel teal correct" id="m1">
        <span class="white-text">
        <i class="material-icons">sentiment_very_satisfied</i>
          <span>Réponse correcte =)</span>
        </span>
      </div>

      <div class="card-panel red" id="m1">
        <span class="white-text">
        <i class="material-icons">sentiment_very_dissatisfied</i>
        <span></span>
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
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.1/js/materialize.min.js"></script>
<script type="text/javascript" src="/js/init.js"></script>
<script type="text/javascript" src="/js/server_request.js"></script>
<script type="text/javascript" src="/js/exercice_drag.js"></script>
</body>
</html>