<h4>Conditions &amp; boucles</h4><p>Il est assez simple de permuter la pr&eacute;sence d&rsquo;un &eacute;l&eacute;ment:</p><pre>&lt;div id=&quot;app-3&quot;&gt;
  &lt;p v-if=&quot;seen&quot;&gt;Maintenant vous me voyez&lt;/p&gt;
&lt;/div&gt;</pre><pre>var app3 = new Vue({
  el: &#39;#app-3&#39;,
  data: {
    seen: true
  }
})</pre><p>et exemple d&eacute;montre que nous pouvons lier des donn&eacute;es non seulement aux textes et attributs, mais &eacute;galement &agrave; la <strong>structure</strong> du DOM. De plus, Vue fournit un puissant syst&egrave;me d&rsquo;effets de transition qui peut automatiquement appliquer des effets de transition quand des &eacute;l&eacute;ments sont ins&eacute;r&eacute;s/mis &agrave; jour/enlev&eacute;s par Vue.</p><p>Il existe quelques autres directives, chacune avec leur propre fonction sp&eacute;cifique. Par exemple, la directive <code>v-for</code> peut &ecirc;tre utilis&eacute;e pour afficher une liste d&rsquo;&eacute;l&eacute;ments en provenance d&rsquo;un tableau de donn&eacute;es.</p><pre>&lt;div id=&quot;app-4&quot;&gt;
  &lt;ol&gt;
    &lt;li v-for=&quot;todo in todos&quot;&gt;
      {{ todo.text }}
    &lt;/li&gt;
  &lt;/ol&gt;
&lt;/div&gt;</pre><pre>var app4 = new Vue({
  el: &#39;#app-4&#39;,
  data: {
    todos: [
      { text: &#39;Apprendre JavaScript&#39; },
      { text: &#39;Apprendre Vue&#39; },
      { text: &#39;Cr&eacute;er quelque chose de g&eacute;nial&#39; }
    ]
  }
})</pre><p>On devrait avoir comme r&eacute;sultat une liste de ce genre:&nbsp;</p><ol><li>Apprendre JavaScript</li><li>Apprendre Vue</li><li>Cr&eacute;er quelque chose de g&eacute;nial</li></ol>