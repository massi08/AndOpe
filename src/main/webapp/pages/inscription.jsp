<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.1/css/materialize.min.css">
  <link href="/css/style.css" type="text/css" rel="stylesheet"/>
  <link href="/css/inscription.css" type="text/css" rel="stylesheet"/>
  <!--Let browser know website is optimized for mobile-->
  <link rel="icon" type="image/png" href="/img/favicon.png"/>
  <title> Inscription </title>
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
      <li class="active-tab"><a href="#">S'inscrire</a></li>
      <li><a href="./index.jsp">Se connecter</a></li>
    </ul>

    <ul id="nav-mobile" class="side-nav">
      <li class="active-tab"><a href="#">S'inscrire</a></li>
      <li><a href="./index.jsp">Se connecter</a></li>
    </ul>
    <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
  </div>
</nav>

<div class="container-full valign-wrapper">
  <div class="row row-full valign-wrapper">
    <div class="card inscription-card">

      <div class="header">
        <h4>Inscrivez-vous</h4>
      </div>

      <div class="inscription-form">
        <form class="col s12">
          <div class="row">
            <div class="input-field">
              <input type="text" required class="validate lastname">
              <label>Nom</label>
            </div>
          </div>

          <div class="row">
            <div class="input-field">
              <input type="text" required class="validate firstname">
              <label>Prenom</label>
            </div>
          </div>

          <div class="row">
            <div class="input-field">
              <input type="text" required class="validate pseudo">
              <label>Pseudo</label>
            </div>
          </div>

          <div class="row">
            <div class="input-field">
              <input type="email" required class="validate email">
              <label>Email</label>
            </div>
          </div>

          <div class="row">
            <div class="input-field">
              <input type="password" required class="validate password">
              <label>Mot de passe</label>
            </div>
          </div>

          <div class="row">
            <div class="input-field">
              <input type="password"  required class="validate confirm_password">
              <label>Confirmation du mot de passe</label>
            </div>
          </div>

          <div class="row connect-btn">
            <a class="waves-effect waves-light btn user-register"><i class="material-icons right">done_all</i>INSCRIPTION</a>
          </div>
        </form>
      </div>
    </div>
  </div>

</div>

<%@include file="footer.jsp" %>

<script type="text/javascript" src="/js/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.1/js/materialize.min.js"></script>
<script type="text/javascript" src="/js/server_request.js"></script>
<script type="text/javascript" src="/js/init.js"></script>
<script type="text/javascript" src="/js/login.js"></script>
<script type="text/javascript" src="/js/password_verification.js"></script>
</body>
</html>
