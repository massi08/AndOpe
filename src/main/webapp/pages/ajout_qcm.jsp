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
  <link href="/css/ajout_cours.css" type="text/css" rel="stylesheet"/>
  <link href="/css/ajout_qcm.css" type="text/css" rel="stylesheet"/>
  <!--Let browser know website is optimized for mobile-->
  <link rel="icon" type="image/png" href="/img/favicon.png"/>
  <title> Code </title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
</head>

<body>

<%@include file="header.jsp" %>

<div class="container-full">
  <div class="projet-titre row">
    <h4 class="left-align h4-margin">Ajouter un exercice de type QCM</h4>
  </div>

  <div class="form-container">
    <form action="/addexercice/qcm" method="post">
      <div class="chapitres-container">
        <div class="row">
          <div class="input-field">
            <input type="text" id="title" name="title" required class="validate">
            <label>Titre</label>
          </div>
        </div>
        <div class="row">
          <div class="input-field">
            <input type="text" id="question" name="question" required class="validate">
            <label>Question</label>
          </div>
        </div>
        <select name="idChapitre">
          <c:forEach items="${chapitres}" var="item">
            <option value="${item.getIdC()}">${item.getTitle()}</option>
          </c:forEach>
        </select>
        <% for (int i = 1; i <= 4; i++) { %>
        <h5>Option n°<%=i%></h5>
        <div class="row">
          <div class="input-field">
            <input type="text" id="option_<%=i%>" name="option_<%=i%>" required class="validate">
            <label>Option</label>
          </div>
        </div>

        <div class="row">
          <div class="input-field">
            <textarea name="message_<%=i%>" id="message_<%=i%>" class="materialize-textarea"></textarea>
            <label for="description">Message</label>
          </div>
        </div>
        <p>
          <select name="answer_<%=i%>">
            <option value="1">Vrai</option>
            <option value="0">Faux</option>
          </select>
        </p>
        <% } %>

        <div class="row btn-row">
          <button type="submit" class="waves-effect waves-light btn"><i
               class="material-icons right">done_all</i>Créer QCM
          </button>
        </div>
      </div>
    </form>
  </div>

</div>

<%@include file="footer.jsp" %>

<script type="text/javascript" src="/js/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.1/js/materialize.min.js"></script>
<script type="text/javascript" src="/js/server_request.js"></script>
<script type="text/javascript" src="/js/init.js"></script>
<%--<script type="text/javascript" src="../js/add_cours.js"></script>--%>
<script type="text/javascript" src="/js/server_request.js"></script>
<script type="text/javascript" src="/js/init.js"></script>
</body>
</html>
