<!DOCTYPE html>
<%@ taglib prefix="c2" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Model.Exercice" %>

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
<%@include file="header.jsp" %>
<div class="container-full">

  <div class="navigation-wrapper">
    <a class="precedent-exercice precedent waves-effect waves-purple btn-flat" href="#"><i class="material-icons left">chevron_left</i> Retour</a>
  </div>
  <div class="projet-titre row">
    <h3 class="left-align h4-margin">Exercice ${exercice.getIdE()}</h3>
  </div>

  <div class="card exo-card cours-card">
    <jsp:include page="/html_files/${exercice.getChapitreByIdC().getCoursByIdCours().getIdCours()}/exercices/${exercice.getIdE()}.jsp"/>
  </div>

</div>

<%@include file="footer.jsp" %>

<script type="text/javascript" src="/js/jquery-2.1.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.1/js/materialize.min.js"></script>
<script type="text/javascript" src="/js/server_request.js"></script>
<script type="text/javascript" src="/js/init.js"></script>
<script type="text/javascript" src="/js/login.js"></script>
<script type="text/javascript" src="/js/exercice_qcm.js"></script>
<script type="text/javascript" src="/js/exercice_drag.js"></script>
<script type="text/javascript" src="/js/vue_exo.js"></script>
</body>
</html>
