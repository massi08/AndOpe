<h4><span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="Rendu">Rendu</span> de <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="listes">listes</span> (v-for)</h4><p><span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="Nous">Nous</span> <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="pouvons">pouvons</span> <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="utiliser">utiliser</span> la directive <strong>v-for</strong> pour faire le <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="rendu">rendu</span> d&rsquo;une <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="liste">liste</span> d&rsquo;<span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="éléments">&eacute;l&eacute;ments</span> en se <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="basant">basant</span> sur un tableau. La directive<strong>&nbsp;v-for</strong> <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="utilise">utilise</span> une <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="syntaxe">syntaxe</span> <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="spécifique">sp&eacute;cifique</span> de la forme<strong>&nbsp;item in items,</strong> o&ugrave; items repr&eacute;sente le tableau source des donn&eacute;es et o&ugrave; <strong>item</strong> est un alias repr&eacute;sentant l&rsquo;&eacute;l&eacute;ment du tableau en cours d&rsquo;it&eacute;ration :</p><p>Utilisation simple:&nbsp;</p><pre>&lt;ul id=&quot;example-1&quot;&gt;
  &lt;li v-for=&quot;item in items&quot;&gt;
    {{ item.message }}
  &lt;/li&gt;
&lt;/ul&gt;</pre><pre>var example1 = new Vue({
  el: &#39;#example-1&#39;,
  data: {
  items: [
    { message: &#39;Foo&#39; },
    { message: &#39;Bar&#39; }
  ]
 }
})</pre><p>R&eacute;sultat :</p><ul><li>Foo</li><li>Bar</li></ul><p>&Agrave; l&rsquo;int&eacute;rieur des structures <code><strong>v-for</strong></code>, nous avons un acc&egrave;s complet aux propri&eacute;t&eacute;s de la port&eacute;e parente. <code><strong>v-for</strong></code> supporte &eacute;galement un second argument optionnel repr&eacute;sentant l&rsquo;index de l&rsquo;&eacute;l&eacute;ment courant.</p><pre>&lt;ul id=&quot;example-2&quot;&gt;
  &lt;li v-for=&quot;(item, index) in items&quot;&gt;
    {{ parentMessage }} - {{ index }} - {{ item.message }}
  &lt;/li&gt;
&lt;/ul&gt;</pre><pre>var example2 = new Vue({
  el: &#39;#example-2&#39;,
  data: {
    parentMessage: &#39;Parent&#39;,
    items: [
      { message: &#39;Foo&#39; },
      { message: &#39;Bar&#39; }
    ]
  }
})</pre><p>R&eacute;sultat :</p><ul><li>Parent - 0 - Foo</li><li>Parent - 1 - Bar</li></ul><p data-empty="true">Vous pouvez &eacute;galement <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="utiliser">utiliser</span> <code><strong>of</strong></code> en tant que mot cl&eacute; &agrave; la place de <code><strong>in</strong></code> pour &ecirc;tre plus proche de la <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="syntaxe">syntaxe</span> JavaScript concernant l&rsquo;utilisation des it&eacute;rateurs :</p><pre data-empty="true">&lt;div v-for=&quot;item of items&quot;&gt;&lt;/div&gt;</pre><p><strong><span style="font-size: 18px;">Limitations</span></strong></p><p>&Agrave; cause des limitations en JavaScript, Vue <strong>ne peut pas</strong> d&eacute;tecter les changements suivants dans un tableau :</p><ol><li>Quand vous affectez directement un &eacute;l&eacute;ment &agrave; un index. Ex. : <code>vm.items[indexOfItem] = newValue</code></li><li>Quand vous modifiez la longeur du tableau. Ex. : <code>vm.items.length = newLength</code></li></ol><p data-empty="true">Pour contourner la premi&egrave;re limitation, les deux exemples suivants accomplissent la m&ecirc;me chose que<strong>&nbsp;vm.items[indexOfItem] = newValue</strong>, mais vont &eacute;galement d&eacute;clencher des mises &agrave; jour de l&rsquo;&eacute;tat dans le syst&egrave;me de r&eacute;activit&eacute; :</p><pre data-empty="true">// Vue.set
Vue.set(example1.items, indexOfItem, newValue)

// Array.prototype.splice
example1.items.splice(indexOfItem, 1, newValue)</pre><p>Pour g&eacute;rer la seconde limitation, vous pouvez &eacute;galement <span class="scayt-misspell-word" data-scayt-lang="en_US" data-scayt-word="utiliser">utiliser</span> <strong>splice&nbsp;</strong>:</p><pre>example1.items.splice(newLength)</pre><p><br></p>