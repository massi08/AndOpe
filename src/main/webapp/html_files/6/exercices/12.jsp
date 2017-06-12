<%@ page language="java" pageEncoding="UTF-8" %>
<h4>Réarangez ces éléments dans l'ordre</h4>
<h5>Dans quel ordre</h5>
<ul id="sortable">
     <li class="default" id="7">
        <div class="chip">beforeDestroy()</div>
      </li>
     <li class="default" id="4">
        <div class="chip">mounted()</div>
      </li>
     <li class="default" id="1">
        <div class="chip">beforeCreate()</div>
      </li>
     <li class="default" id="5">
        <div class="chip">beforeUpdate()</div>
      </li>
     <li class="default" id="8">
        <div class="chip">destroyed()</div>
      </li>
     <li class="default" id="2">
        <div class="chip">created()</div>
      </li>
     <li class="default" id="6">
        <div class="chip">updated()</div>
      </li>
     <li class="default" id="3">
        <div class="chip">beforeMount()</div>
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
