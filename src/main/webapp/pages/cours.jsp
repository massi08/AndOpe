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
  <link rel="icon" type="image/png" href="/img/favicon.png"/>
  <title> Code </title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
</head>
<body>

<%@include file="header.jsp" %>

<div class="navigation-wrapper">
  <a class="precedent-chapitre precedent waves-effect waves-purple btn-flat" href="#"><i class="material-icons left">chevron_left</i> Retour</a>
</div>
<div class="container-full valign-wrapper">
  <div class="card cours-card">
    <jsp:include page="/html_files/${cours.getIdCours()}/cours/${chapitre.getIdC()}.jsp"/>
  </div>
</div>

<%@include file="footer.jsp" %>

<script type="text/javascript" src="/js/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.1/js/materialize.min.js"></script>
<script type="text/javascript" src="/js/init.js"></script>
<script type="text/javascript" src="/js/server_request.js"></script>
<script type="text/javascript" src="/js/exercice_qcm.js"></script>
<script type="text/javascript" src="/js/chapitredone.js"></script>
</body>
</html>