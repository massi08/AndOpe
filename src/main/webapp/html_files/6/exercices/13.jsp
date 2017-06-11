<%@ page language="java" pageEncoding="UTF-8" %>
<h4>
    Ecrivez la bonne réponse.
</h4>
<h5>Supposons que nous avons la vue ci-dessous </h5>
<pre>
var app6 = new Vue({
    el: '#app-6',
    data: {
        message: 'Hello Vue!'
    }
})</pre>
<br>
<h5>Inserer le v-model avec la syntaxe moustache</h5>
      <pre>
&lt;div id="app-6">
    &lt;p> <input type="text" id="answer" class="user-input"> &lt;/p>
    &lt;input v-model="message">
&lt;/div></pre>
    <button class="waves-effect waves-light btn btn-submit" id="vue-exo2">Submit</button>
    <div class="after-answer" style="display: none">
        <span>Résultat: </span>
        <input type="text" value="Hello Vue!">
    </div>
<div class="answers">
    <div class="card-panel red" id="m1">
        <span class="white-text">
          <i class="material-icons">close</i></span>
    </div>
    <div class="card-panel orange" id="m3">
        <span class="white-text">
          <i class="material-icons">close</i></span>
    </div>
    <div class="card-panel teal" id="m2" >
        <span class="white-text">
        <i class="material-icons">done</i></span>
    </div>
</div>