<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c2" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <base href="${pageContext.request.contextPath}">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.1/css/materialize.min.css">
  <link href=" <c:url value = "/css/style.css" />" type="text/css" rel="stylesheet"/>
  <link href="../css/connexion.css" type="text/css" rel="stylesheet"/>
  <!--Let browser know website is optimized for mobile-->
  <link rel="icon" type="image/png" href="./img/favicon.png"/>
  <title> Connexion </title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
</head>

<body>

<nav class="white defaut-color" role="navigation">
  <div class="nav-wrapper container">
    <a id="logo-container" href="/" class="brand-logo">
      <img src="./img/Logo_IDE.png">
    </a>
    <ul class="right hide-on-med-and-down">
      <li><a href="./inscription.jsp">S'inscrire</a></li>
      <li class="active-tab"><a href="#">Se connecter</a></li>
    </ul>

    <ul id="nav-mobile" class="side-nav">
      <li><a href="./inscription.html">S'inscrire</a></li>
      <li class="active-tab"><a href="#">Se connecter</a></li>
    </ul>
    <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
  </div>
</nav>

<div class="container-full valign-wrapper">

  <div class="row row-full valign-wrapper">
    <div class="card inscription-card">

      <div class="header">
        <h4>Connectez-vous</h4>
      </div>

      <div class="inscription-form">
        <form:form action="/api/login" class="col s12">
          <div class="row">
            <div class="input-field">
              <i class="material-icons prefix">account_circle</i>
                <%--<form:input path="pseudo" size="30" id="icon_prefix" class="validate"/>--%>
              <input id="icon_prefix" type="text" name="pseudo" class="validate pseudo">
              <label for="icon_prefix">Pseudo</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field">
              <i class="material-icons prefix">lock</i>
                <%--<form:input id="icon_password" class="validate" path="password" type="password" size="30"/>--%>
              <input id="icon_password" type="password" name="password" class="validate password">
              <label for="icon_password">Mot de passe</label>
            </div>
          </div>
          <div class="row connect-btn">
              <%--<a href="#" class="waves-effect waves-light btn" id="login"><i
                   class="material-icons right">send</i>CONNEXION</a>--%>
            <button class="waves-effect waves-light btn">
              <i class="material-icons right" name="submit" type="submit">send</i>
              CONNEXION
            </button>
          </div>
        </form:form>
      </div>
    </div>
  </div>
</div>
<%@include file="footer.jsp" %>

<script type="text/javascript" src="./../js/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.1/js/materialize.min.js"></script>
<script type="text/javascript" src="/js/server_request.js"></script>
<script type="text/javascript" src="/js/init.js"></script>
<script type="text/javascript" src="/js/login.js"></script>
</body>
</html>
        