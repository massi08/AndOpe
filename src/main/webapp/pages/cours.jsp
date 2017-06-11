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

<div class="container-full valign-wrapper">
  <div class="card cours-card">
    <h4>Introduction</h4>
    <p><strong>Vue.js, qu&rsquo;est-ce que c&rsquo;est ?<br></strong><br>Vue (prononc&eacute; /vjuː/, comme le terme
      anglais view) est un framework &eacute;volutif pour construire des interfaces utilisateur. &Agrave; la diff&eacute;rence
      des autres frameworks monolithiques, Vue a &eacute;t&eacute; con&ccedil;u et pens&eacute; pour pouvoir &ecirc;tre
      adopt&eacute; de mani&egrave;re incr&eacute;mentale. Le c&oelig;ur de la biblioth&egrave;que est concentr&eacute;
      uniquement sur la partie vue, et il est vraiment simple de l&rsquo;int&eacute;grer avec d&rsquo;autres biblioth&egrave;ques
      ou projets existants.</p>
    <p><strong>Rendu d&eacute;claratif</strong></p>
    <p>Au c&oelig;ur de Vue.js, il y a un syst&egrave;me qui va nous permettre de faire le rendu des donn&eacute;es
      d&eacute;clarativement dans le DOM en utilisant simplement cette syntaxe de template :</p>
    <pre>
&lt;div id=&quot;app&quot;&gt;
  {{ message }}
&lt;/div&gt;</pre>
    <pre>
var app = new Vue({
  el: &#39;#app&#39;,
  data: {
    message: &#39;Hello Vue !&#39;
  }
});</pre>
  </div>
</div>

<%@include file="footer.jsp" %>

<script type="text/javascript" src="/js/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.1/js/materialize.min.js"></script>
<script type="text/javascript" src="/js/init.js"></script>
<script type="text/javascript" src="/js/server_request.js"></script>
<script type="text/javascript" src="/js/exercice_qcm.js"></script>
</body>
</html>