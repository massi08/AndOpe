<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<nav class="white" role="navigation">
    <div class="nav-wrapper container">
        <a id="logo-container" href="/" class="brand-logo">
            <img src="/img/Logo_IDE.png">
        </a>
        <ul class="right hide-on-med-and-down">
            <li class="active-tab"><a href="/cours">Mes Projets</a></li>
            <li><a href="./account.jsp">Mon Compte</a></li>
            <li><a href="./parameters.jsp">Paramètres</a></li>
            <li><a href="/api/logout">Déconnexion</a></li>
        </ul>

        <ul id="nav-mobile" class="side-nav">
            <li class="active-tab"><a href="./manage_project.jsp">Mes Projets</a></li>
            <li><a href="./account.jsp">Mon Compte</a></li>
            <li><a href="./parameters.jsp">Paramètres</a></li>
            <li><a href="/api/logout">Déconnexion</a></li>
        </ul>
        <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
</nav>