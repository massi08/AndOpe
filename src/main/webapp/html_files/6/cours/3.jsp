<h4 style="margin-left: 420px;">Introduction</h4><p><strong>Vue.js, qu&rsquo;est-ce que c&rsquo;est ?<br></strong><br>Vue (prononc&eacute; /vjuː/, comme le terme anglais view) est un framework &eacute;volutif pour construire des interfaces utilisateur. &Agrave; la diff&eacute;rence des autres frameworks monolithiques, Vue a &eacute;t&eacute; con&ccedil;u et pens&eacute; pour pouvoir &ecirc;tre adopt&eacute; de mani&egrave;re incr&eacute;mentale. Le c&oelig;ur de la biblioth&egrave;que est concentr&eacute; uniquement sur la partie vue, et il est vraiment simple de l&rsquo;int&eacute;grer avec d&rsquo;autres biblioth&egrave;ques ou projets existants.</p><p><strong>Rendu d&eacute;claratif</strong></p><p><br>Au c&oelig;ur de Vue.js, il y a un syst&egrave;me qui va nous permettre de faire le rendu des donn&eacute;es d&eacute;clarativement dans le DOM en utilisant simplement cette syntaxe de template :</p><pre>
&lt;div id=&quot;app&quot;&gt;
  {{ message }}
&lt;/div&gt;</pre><pre>
var app = new Vue({
  el: &#39;#app&#39;,
  data: {
    message: &#39;Hello Vue !&#39;
  }
});</pre>