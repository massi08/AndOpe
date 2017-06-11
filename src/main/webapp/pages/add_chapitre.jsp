<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c2" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.1/css/materialize.min.css">
  <!-- Include external CSS. -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet"
        type="text/css"/>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.25.0/codemirror.min.css">

  <!-- Include Editor style. -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/froala-editor/2.6.0/css/froala_editor.pkgd.min.css"
        rel="stylesheet" type="text/css"/>
  <link href="https://cdnjs.cloudflare.com/ajax/libs/froala-editor/2.6.0/css/froala_style.min.css" rel="stylesheet"
        type="text/css"/>
  <link href="/css/style.css" type="text/css" rel="stylesheet"/>
  <link href="/css/add_chapitre.css" type="text/css" rel="stylesheet"/>
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
    <h4 class="left-align h4-margin">Ajouter un chapitre</h4>
  </div>
  <div class="form-container">
    <div class="row">
      <div class="input-field">
        <input type="text" id="title" required class="validate">
        <label>Titre</label>
      </div>
    </div>
    <div id="froala-editor"></div>
    <div class="row btn-row">
      <a class="waves-effect waves-light btn" id="create-course"><i class="material-icons right">done_all</i>Créer chapitre</a>
    </div>
  </div>
</div>

<%@include file="footer.jsp" %>

<script type="text/javascript" src="/js/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.1/js/materialize.min.js"></script>
<script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.25.0/codemirror.min.js"></script>
<script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.25.0/mode/xml/xml.min.js"></script>

<!-- Include Editor JS files. -->
<script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/froala-editor/2.6.0/js/froala_editor.pkgd.min.js"></script>

<script type="text/javascript" src="/js/server_request.js"></script>
<script type="text/javascript" src="/js/init.js"></script>
<script type="text/javascript" src="/js/login.js"></script>
<script type="text/javascript" src="/js/add_chapitre.js"></script>
</body>
</html>
