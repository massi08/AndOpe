<h4 skip="true">Les <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="composants">composants</span></h4><p>Le <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="système">syst&egrave;me</span> de <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="composant">composant</span> est un <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="autre">autre</span> concept important de Vue, car c&rsquo;est une abstraction qui <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="nous">nous</span> <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="permet">permet</span> de <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="construire">construire</span> de plus grosses applications <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="composées">compos&eacute;es</span> de plus <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="petits">petits</span> <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="composants">composants</span> <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="réutilisables">r&eacute;utilisables</span> et <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="autonomes">autonomes</span>. <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="Quand">Quand</span> on y <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="pense">pense</span>, <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="presque">presque</span> <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="tous">tous</span> les types d&rsquo;interface applicative <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="peuvent">peuvent</span> &ecirc;tre abstraits en un arbre de <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="composants">composants</span>.</p><p><img src="https://fr.vuejs.org/images/components.png" style="width: 500px;" class="fr-fic fr-dib"></p><p>Dans Vue, un <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="composant">composant</span> est essentiellement une instance de Vue avec des options pr&eacute;d&eacute;finies. D&eacute;clarer un <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="composant">composant</span> avec Vue est tr&egrave;s simple :</p><pre>// D&eacute;finit un nouveau <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="composant">composant</span> appel&eacute; todo-item
Vue.component(&#39;todo-item&#39;, {
  template: &#39;&lt;li&gt;Ceci est une liste&lt;/li&gt;&#39;
})</pre><p>Maintenant <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="nous">nous</span> pouvons l&rsquo;ins&eacute;rer dans le template d&rsquo;un <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="autre">autre</span> <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="composant">composant</span> :</p><pre>&lt;ol&gt;
  &lt;!-- Cr&eacute;e une instance du <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="composant">composant</span> todo-list --&gt;
  &lt;todo-item&gt;&lt;/todo-item&gt;
&lt;/ol&gt;</pre><p>Mais cela donnerait comme rendu le m&ecirc;me texte, ce qui n&rsquo;est pas vraiment int&eacute;ressant. Nous devrions &ecirc;tre capable de passer les donn&eacute;es de la port&eacute;e parente dans le <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="composant">composant</span> enfant. Modifions la d&eacute;finition du <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="composant">composant</span> pour lui permettre d&rsquo;accepter une prop :</p><pre>Vue.component(&#39;todo-item&#39;, {
  // Le <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="composant">composant</span> todo-item accepte maintenant une
  // &laquo; prop &raquo; qui est comme un attribut personnalis&eacute;.
  // Cette prop est appel&eacute;e todo.
  props: [&#39;todo&#39;],
  template: &#39;&lt;li&gt;{{ todo.text }}&lt;/li&gt;&#39;
})</pre><p>Maintenant <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="nous">nous</span> pouvons passer la liste dans chaque <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="composant">composant</span> r&eacute;p&eacute;t&eacute; en utilisant <code>v-bind</code> :</p><pre>&lt;div id=&quot;app-7&quot;&gt;
  &lt;ol&gt;
    &lt;!--
    Maintenant <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="nous">nous</span> fournissons &agrave; chaque todo-item l&#39;objet todo
    qu&#39;il repr&eacute;sente de mani&egrave;re &agrave; ce que son contenu puisse &ecirc;tre dynamique.
    Nous avons &eacute;galement besoin de fournir &agrave; chaque <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="composant">composant</span> une &laquo; cl&eacute; &raquo;,
    mais <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="nous">nous</span> expliquerons cela plus tard.
    --&gt;
    &lt;todo-item
      v-for=&quot;item in groceryList&quot;
      v-bind:todo=&quot;item&quot;
      v-bind:key=&quot;item.id&quot;&gt;
    &lt;/todo-item&gt;
  &lt;/ol&gt;
&lt;/div&gt;</pre><pre>Vue.component(&#39;todo-item&#39;, {
  props: [&#39;todo&#39;],
  template: &#39;&lt;li&gt;{{ todo.text }}&lt;/li&gt;&#39;
})

var app7 = new Vue({
  el: &#39;#app-7&#39;,
  data: {
    groceryList: [
      { id: 0, text: &#39;L&eacute;gumes&#39; },
      { id: 1, text: &#39;Fromage&#39; },
      { id: 2, text: &#39;Tout ce que les humains sont suppos&eacute;s manger&#39; }
    ]
  }
})</pre><p>On devrait avoir le r&eacute;sultat suivant:&nbsp;</p><ol><li>L&eacute;gumes</li><li>Fromage</li><li>Tout ce que les humains sont suppos&eacute;s manger</li></ol>