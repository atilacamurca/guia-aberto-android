# Exemplo prático

## Primeira aplicação - Contatos

Baseado em \ref{sssec:testando} Testando o ADT, crie um novo aplicativo
chamado **Contatos**. Use `guia.android.exemplo` como o nome da companhia.
Siga os passos descritos nas figuras \ref{fig:new-project-1},
\ref{fig:new-project-2}, \ref{fig:new-project-3} e \ref{fig:new-project-4} para criar uma
`Activity` inicial chamada `MainActivity` e um *layout* inicial chamado
`main`. Depois clique em `Finish`.

\begin{figure}[h]
	\includegraphics[scale=0.35]{img/exemplo-pratico/android-new-project-1.png}
	\caption{Novo projeto, tela 1}
    \label{fig:new-project-1}
\end{figure}

\begin{figure}[p]
	\includegraphics[scale=0.35]{img/exemplo-pratico/android-new-project-2.png}
	\caption{Novo projeto, tela 2}
    \label{fig:new-project-2}
\end{figure}

\begin{figure}[p]
	\includegraphics[scale=0.35]{img/exemplo-pratico/android-new-project-3.png}
	\caption{Novo projeto, tela 3}
    \label{fig:new-project-3}
\end{figure}

\begin{figure}[h]
	\includegraphics[scale=0.32]{img/exemplo-pratico/android-new-project-4.png}
	\caption{Novo projeto, tela 4}
    \label{fig:new-project-4}
\end{figure}

Este exemplo é bastante útil para aprendermos como funciona o Android.
Você só poderá criar algo se você souber utilizar bem as ferramentas.

### AndroidManifest.xml

Este é o arquivo que define nossa aplicação, mapeia as `Activity`'s,
entre outras configurações. Ao finalizar a criação do projeto,
inicialmente este arquivo deverá conter o conteúdo descrito no Código-fonte
\ref{code:android-manifest-1}:

<!-- AndroidManifest.xml -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ xml }{ source/AndroidManifest-1.xml }
  \caption{Projeto inicial [AndroidManifest.xml]}
  \label{code:android-manifest-1}
\end{listing}

Devido a entrada do \gls{gradle}
(ver [Gradle: The New Android Build System](http://www.gradleware.com/android/gradle-the-new-android-build-system/))
a versão mínima e a versão alvo do SDK foram movidas
para o arquivo `build.gradle`. Outros detalhes em
<http://developer.android.com/sdk/installing/studio-build.html>.

#### Links para ver o código online

Desse ponto em diante você verá a cada código mostrado um link para o código
online, no \gls{github}. Se você está na versão eletrônica basta clicar no link. Se
você está na versão impressa acesse a página web
<https://github.com/atilacamurca/guia-aberto-android-contatos/commits/master>.

#### Commit

[d47028c8b7273f5a10c849c8b487f262360ded56](https://github.com/atilacamurca/guia-aberto-android-contatos/commit/d47028c8b7273f5a10c849c8b487f262360ded56)

### Activity \label{ssec:act}

Não existe método `main` visível ao programador no Android. Ao invés disso
temos `Activity`'s. Para que o Android saiba qual ele deve iniciar
primeiro utilizamos um `intent-filter` como visto no trecho de código
acima da linha \circled{09} a \circled{12}. Para nossa primeira `Activity`
criaremos uma lista de contatos e um menu para criação de um novo contato.

Para construir o *layout* inicial de nossa aplicação precisamos editar o
arquivo `activity_main.xml` localizado em `res/layout`.

<!-- TODO: renomear main-1.xml para activity_main-1.xml,
arquivo já existe e deve ser atualizado -->

<!-- res/layout/activity_main.xml -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ xml }{ source/main-1.xml }
  \caption{Layout principal [res/layout/activity_main.xml]}
\end{listing}

O resultado pode ser visto na figura \ref{fig:activity-main-1}.

\begin{figure}[h]
	\center
	\includegraphics[scale=0.3]{img/exemplo-pratico/activity_main-1.png}
	\caption{Layout tela principal}
    \label{fig:activity-main-1}
\end{figure}

#### Commit

[5e31fe9e7c9b15596ae6bfe1ca857d92544290a2](https://github.com/atilacamurca/guia-aberto-android-contatos/commit/5e31fe9e7c9b15596ae6bfe1ca857d92544290a2)

Deste momento em diante tenha em mente que os arquivos \gls{xml} aqui
descritos são apenas para você poder comparar e ver se não esqueceu de
nada. Todos os *layout*'s devem ser criados usando o \gls{layout-editor}.
Você irá notar que ao abrir o `xml` uma janela de *layout* aparecerá.
Para visualizar o `xml` ou o *layout* gráfico basta utilizar a aba
inferior esquerda.

Por fim, temos o menu. Clique com o botão direito do *mouse* no diretório
`res/menu` $\rightarrow$ `New` $\rightarrow$ `Menu resource file`.
Chame-o de `main_menu.xml`.

<!-- res/menu/main_menu.xml -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ xml }{ source/main_menu-1.xml }
  \caption{Menu principal [res/menu/main\b{ }menu.xml]}
\end{listing}

#### Commit

[a49787ebc586dca2db9fa3adc92b134453258354](https://github.com/atilacamurca/guia-aberto-android-contatos/commit/a49787ebc586dca2db9fa3adc92b134453258354)

\begin{figure}[h]
	\includegraphics[scale=0.3]{img/exemplo-pratico/main_menu-1.png}
	\caption{Menu principal}
\end{figure}

Pronto, já temos nosso layout. Compile o projeto e vamos a próxima
iteração.

#### Convenção de nomes para ícones \label{sssec:nomeicones}

Na edição 2 deste guia, falamos sobre o uso de ícones no menu e seus
_namespaces_. Mas desde a versão 3.0, o Android introduziu o conceito
de **Action Bar**. Isso fez com que o uso de ícones no menu sumisse.

* <http://android-developers.blogspot.in/2012/01/say-goodbye-to-menu-button.html>
* <http://developer.android.com/guide/topics/ui/actionbar.html>

Mesmo assim vou manter a tabela com as convenções adotadas pelo Android
para o prefixo dos ícones:

<!--
Observe que o ícone utilizado no menu vem junto com o SDK do Android.
Você pode visualizar os ícones em
`SDK_INSTALL/plataforms/android-8/data/res/drawable-hdpi` (substitua
`SDK_INSTALL` pelo diretório de instalação do SDK do Android, no nosso
caso `usr/local/lib/android-sdk`, \ref{ssec:sdk}). Note que há *namespaces*
ou prefixos em cada um dos ícones. O Android recomenda a seguinte
convenção:
-->

-----------------------------------------------------------------------
**Tipo de Recurso**  **Prefixo**        **Exemplo**
-------------------  ---------------    -------------------------------
Ícones               `ic_`              `ic_adicionar.png`

Launcher icons       `ic_launcher_`     `ic_launcher_calendario.png`

Menu e Action Bar    `ic_menu_`         `ic_menu_ajuda.png`

Status bar icons     `ic_stat_notify_`  `ic_stat_notify_msg.png`

Tab icons            `ic_tab_`          `ic_tab_recente.png`

Dialog icons         `ic_dialog_`       `ic_dialog_info.png`
-----------------------------------------------------------------------

Table: Convenção para nome dos ícones

Note que você não é obrigado a utilizar os prefixos citados acima, isto
é apenas uma convenção. Veja mais detalhes em
<http://developer.android.com/design/style/iconography.html#action-bar>.

Abra o arquivo `MainActivity.java` e vá ao método `onCreate`. Defina o
*layout* como sendo nosso `main.xml`. Para isso adicione o *layout*
**main** ao final do método:

<!-- MainActivity.java -->
\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/MainActivity-1.java }
  \caption{Definir layout [MainActivity.java]}
\end{listing}

#### Commit

[a49787ebc586dca2db9fa3adc92b134453258354](https://github.com/atilacamurca/guia-aberto-android-contatos/commit/a49787ebc586dca2db9fa3adc92b134453258354)

##### Cuidado \label{par:r}

no ambiente Android temos uma classe chamada `R`. Ela existe tanto na
biblioteca do Android como em cada projeto. A classe `android.R` é utilizada em outras
situações, onde códigos pré-prontos foram disponibilizados pela equipe
do Android.

Agora precisamos sobrescrever os métodos `onCreateOptionsMenu` e
`onOptionsItemSelected`. Eles irão criar o menu a partir de nosso *layout*
e notificar quando os itens do menu forem pressionados, respectivamente.
Vamos ao código:

<!-- MainActivity.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/MainActivity-2.java }
  \caption{Criando o menu [MainActivity.java]}
\end{listing}

#### Commit

[18c59c4a828c40f0877f0adef352b1afe6c3412f](https://github.com/atilacamurca/guia-aberto-android-contatos/commit/18c59c4a828c40f0877f0adef352b1afe6c3412f)

<!-- http://www.felipesilveira.com.br/desenvolvendo-para-android/ -->
<!-- http://www.felipesilveira.com.br/2010/05/content-providers/ -->

### Formulários

Agora vamos criar nosso formulário para criação e edição de contatos.
Começaremos pelo *layout*. Crie um arquivo `xml` em `res/layout` chamado
`activity_salvar.xml`.

Existem alguns pontos importantes para este trecho de código. Começando
pelo *layout* inicial, onde usaremos `TableLayout` (dentro de um `RelativeLayout`).
Esse *layout* é ideal para telas com estilo tabela.

\begin{figure}[h]
	\center
	\includegraphics[scale=0.6]{img/exemplo-pratico/new-layout-salvar.png}
	\caption{Novo layout, Root element com busca de layouts disponíveis}
\end{figure}

Um detalhe importante para observarmos neste *layout* é que ele possui o
atributo `stretchColumns` com valor `1`. Isso quer dizer que a coluna
`1` da tabela terá o maior tamanho possível, respeitando o tamanho
mínimo das outras células. Para visualizar as mudanças você pode tentar
usar outros valores como `0` tornando a primeira coluna maior que as
demais, ou ainda `*` que fará com que todas as células tenham o mesmo
tamanho.

<!-- res/layout/activity_salvar.xml -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ xml }{ source/activity_salvar-1.xml }
  \caption{Formulário principal [res/layout/activity_salvar.xml]}
\end{listing}

#### Commit

[f130f18bcdab8638641d42c32557ffffa2e1b0ba](https://github.com/atilacamurca/guia-aberto-android-contatos/commit/f130f18bcdab8638641d42c32557ffffa2e1b0ba)

\bigskip

Atentem para a linha \circled{23} do código acima. Nele podemos ver o uso do
indicador do tipo de dados que vamos entrar, no caso `textPersonName`. Isso significa
que o teclado irá se comportar de forma a ajudar o usuário, fazendo com que a
primeira letra seja digitada sempre em maiúsculo. Sabendo disso use o mesmo
raciocínio para os campos Telefone e E-mail, usando o valor `phone` e `textEmailAddress`
em `android:inputType`, respectivamente.

A lista completa pode ser vista em
<http://developer.android.com/reference/android/widget/TextView.html#attr_android:inputType>.

\begin{figure}[H]
	\center
	\includegraphics[scale=0.3]{img/exemplo-pratico/activity_salvar-1.png}
	\caption{Layout tela Salvar Contato}
\end{figure}

Crie uma nova `Activity` chamada `SalvarActivity` dentro de
`exemplo.android.guia.contatos.view`. Para irmos de uma `Activity` para outra precisamos
de um `Intent`. Um de seus construtores recebe como parâmetros a
instância da classe em que estamos, sendo que ela deve implementar a
interface `Context` e o nome da classe a qual deve ser mostrada. Veja
como implementar o método `irParaSalvar` da classe `MainActivity`:

<!-- MainActivity.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/MainActivity-3.java }
  \caption{Mudando de Activity [MainActivity.java]}
\end{listing}

#### Commit

[ec5b0f1913e300a91bde424f596cc15e25b9ef18](https://github.com/atilacamurca/guia-aberto-android-contatos/commit/ec5b0f1913e300a91bde424f596cc15e25b9ef18)

\medskip

Veremos agora como manipular `EditText`'s, que representam os campos de
entrada de dados. Abra o `SalvarActivity` e adicione o método carregar e
crie atributos para guardar os `EditText`'s:

<!-- SaveActivity.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/SalvarActivity-1.java }
  \caption{Utilizando EditText's [SalvarActivity.java]}
\end{listing}

#### Commit

[16671ee3a0afeec91431deb656aeaab906d4abb8](https://github.com/atilacamurca/guia-aberto-android-contatos/commit/16671ee3a0afeec91431deb656aeaab906d4abb8)

\bigskip

Para que a `Activity` funcione precisamos mapeá-la no arquivo
`AndroidManifest.xml`. Adicione o conteúdo abaixo entre as *tags*
`application`:

<!-- AndroidManifest.xml -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ xml }{ source/AndroidManifest-2.xml }
  \caption{Mapear SalvarActivity [AndroidManifest.xml]}
\end{listing}

#### Commit

[fb4b54a586e6669ab4974cbf7d38edb5b72eb1a4](https://github.com/atilacamurca/guia-aberto-android-contatos/commit/fb4b54a586e6669ab4974cbf7d38edb5b72eb1a4)

### Construindo o Model da aplicação \label{ssec:model}

Precisamos de um *helper* para fazer acesso ao banco de dados. O Android
provê suporte a bancos de dados [Sqlite](http://sqlite.org/) por padrão. Qualquer banco de
dados que você criar será acessível pelo nome por qualquer classe na sua
aplicação, mas não fora dela.

Crie uma classe abstrata chamada `AbstractHelper` em `exemplo.android.guia.contatos.model` que
extende de `SQLiteOpenHelper`. Qualquer outra classe que necessite acesso ao banco de
dados agora deve estender de `AbstractHelper` e utilizar os métodos `getReadableDatabase()` e
`getWritableDatabase()` para ler e escrever no banco de dados, respectivamente.

<!--
Essa classe será capaz de ler e escrever
no banco de dados graças aos métodos `getReadableDatabase()` e
`getWritableDatabase()`, respectivamente.
-->

A princípio temos que criar um construtor passando como parâmetros o
nome do banco de dados e a versão da \gls{ddl} (*Data Definition Language*).
Logo em seguida precisamos implementar os métodos `onCreate`, no qual
iremos criar as tabelas e `onUpdate`, caso tenhamos que alterar alguma
tabela em versões futuras do aplicativo. Mais detalhes sobre isso em
\ref{sssec:update-ddl}.

<!-- AbstractHelper.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/AbstractHelper-1.java }
  \caption{Helper da aplicação [AbstractHelper.java]}
\end{listing}

#### Como funciona o SQLiteOpenHelper?

Ao estender de `SQLiteOpenHelper` somos obrigados a chamar seu construtor e passar
alguns parâmetros para a super classe. Vamos indentificá-los:

* **context**: significa quem tem acesso ao banco de dados, ou seja, somente sua
	aplicação, como ela é a única que pode criar essa classe, ela é a única que
    tem o direito de acessar.
* **name**: nome do banco de dados a ser criado fisicamente no Android.
* **factory** $^1$: fábrica que cria a instância da classe Cursor, que serve para acessar
	os dados após fazer queries. No nosso caso passamos `null`. Isso se deve pelo
    fato de que queremos usar o `Factory` padrão do Android. Caso queiramos criar
    um Cursor especializado ai sim teremos que nos preocupar com esse parâmetro.
* **version**: versão do banco de dados, usado para fazer _upgrade_ ou _downgrade_
	da \gls{ddl}.

1. <http://stackoverflow.com/a/11643417/1152679>

Outros detalhes em
<http://developer.android.com/reference/android/database/sqlite/SQLiteOpenHelper.html>.

<!--
https://plus.google.com/+GiacomoBresciani/posts/bSTeoVBjM4m
http://android-developers.blogspot.com.br/2010/05/be-careful-with-content-providers.html
http://developer.android.com/guide/topics/providers/content-provider-basics.html
http://www.vogella.com/tutorials/AndroidSQLite/article.html#sqliteoverview_sqliteopenhelper
http://www.androidhive.info/2011/11/android-sqlite-database-tutorial/
-->

Tudo que temos a fazer a partir deste ponto para acessar o banco de dados
é criar classes que estendam de `AbstractHelper`, no caso a primeira a ser
criada é `ContatoHelper`.

<!-- ContatoHelper.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/ContatoHelper-1.java }
  \caption{Helper para acessar tabela contato [ContatoHelper.java]}
\end{listing}

Devido a classe `AbstractHelper` ser abstrata, é possível repassar a tarefa de
implementar os método `onCreate` e `onUpdate` para as classes filhas. Dessa forma
podemos tratar muito melhor a criação das tabelas referentes a classe em questão,
como podemos ver nas linhas \circled{10} a \circled{29}.

Também vemos uma classe interna que implementa `BaseColumns`. Ela é uma interface
bem simples contendo apenas dois atributos, `_id` e `_count`. Entretanto é uma forma
bem expressiva de definir as colunas de sua tabela e usá-las para fazer queries,
entre outras coisas.

A documentação pode ser encontrada em
<http://developer.android.com/reference/android/provider/BaseColumns.html>.

Para a iteração de criação de um novo contato, ainda em `ContatoHelper`
vamos adicionar um método `criar`. Faça:

<!-- ContatoHelper.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/ContatoHelper-2.java }
  \caption{Criar novo contato [ContatoHelper.java]}
\end{listing}

#### ContentProvider

Um `ContentProvider` é uma maneira universal de acesso aos dados, sejam eles em
banco de dados, arquivo, rede (_stream_), etc. Isso quer dizer que eles fazem uma
abstração de como esses dados são acessados, além de permitir que outros aplicativos
possam fazer uso das informações obtidas na sua aplicação.

Vamos por partes. O `ContentProvider` é uma classe do Android que tem o objetivo de encapsular
os dados e provê uma interface única para que outros aplicativos, inclusive o seu, tenham acesso
a esses dados. Entretanto ele somente é necessário se você precisa compartilhar os dados
entre outros aplicativos.

Seu funcionamento é bem simples, um `ContentProvider` é identificado por um \gls{uri},
ou seja, um valor único que o representa. Um exemplo bem conhecido é a forma de acessar
dados da internet através de \gls{http}, onde utilizamos uma \gls{url}. Uma URL é um
conjunto específico de URI. Ao ser realizada uma requisição a um determinado URI para
um `ContentResolver`, ele verifica quem é responsável por responder pelo URI e repassa
a requisição. Uma URI genérica é escrita na forma: `<scheme>://<authority><path>?<query>`.

Os principais métodos a serem implementados são:

* `onCreate()`: inicializa o _provider_;
* `query(Uri, String[], String, String[], String)`: realiza busca;
* `insert(Uri, ContentValues)`: insere dados;
* `update(Uri, ContentValues, String, String[])`: atualiza dados;
* `delete(Uri, String, String[])`: deleta dados;
* `getType(Uri)`: obtém o _MIME type_ dos dados.

Mais detalhes em:

* <http://developer.android.com/reference/android/content/ContentProvider.html>
* <http://developer.android.com/guide/topics/providers/content-providers.html>
* <http://www.faqs.org/rfcs/rfc2396.html>
* <http://www.faqs.org/rfcs/rfc1738.html>

<!-- TODO: mudar para a chamada do ContentProvider -->
Agora temos que fazer a chamada do método criar da classe
`ContatoHelper` em `SalvarActivity`. Para isso temos que criar uma
instância de `ContatoHelper`, adicionar o botão salvar e adicionar um
*Listener* de *click* (faça o *import* da classe \newline
`android.view.View.OnClickListener`). Vamos ao código:

<!-- SaveActivity.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/SalvarActivity-2.java }
  \caption{Fim da iteração criar contato [SalvarActivity.java]}
\end{listing}

Com essa implementação já é possível salvar contatos na base de dados.

### Mostrando os dados na View \label{ssec:listview}

Após salvar os dados no banco, devemos ser capazes de obter tais
informações e colocá-las em forma de Lista. Para isso criaremos um novo
*layout* que será responsável por representar uma linha de nossa Lista.
Essa linha deve ser semelhante a figura abaixo:

\begin{figure}[h]
	\centering
	\includegraphics[scale=0.6]{img/layout-linha.png}
	\caption{Layout linha da Lista}
\end{figure}

Para isso crie um arquivo chamado `linha.xml` em `res/layout` com o
seguinte conteúdo.

<!-- res/layout/linha.xml -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ xml }{ source/linha-1.xml }
  \caption{Layout para cada linha da lista [res/layout/linha.xml]}
\end{listing}

Note a possibilidade de aninhar o `LinearLayout`. Fazendo isso é
possível criar o *layout* desejado fazendo com que alguns elementos
sejam inseridos na horizontal, outros na vertical.

Outro ponto interessante é o uso de negrito no `TextView` correspondente
ao nome, na linha \circled{14}, e o uso de reticências caso o nome seja maior que
a tela usando `android:ellipsize="end"` na linha \circled{15}.

Agora vamos até `ContatoHelper` e adicionar o método `listar`. E também
adicionaremos métodos para facilitar a obtenção dos valores de cada
atributo.

<!-- ContatoHelper.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/ContatoHelper-3.java }
  \caption{Listar contatos existentes [ContatoHelper.java]}
\end{listing}

Os elementos de um `Cursor` são numerados iniciando de 0 (zero). Neste
caso o 0 é a coluna `_id`. Observe que ela não será usada pelo programador
e sim pelo Android. Isto será visto com mais detalhes em \ref{ssec:edit}
Editando dados existentes.

Para popular cada linha de nossa Lista vamos criar uma classe interna
(*inner class*) em `MainActivity`. Assim podemos fazer *cache* dos
objetos aumentando a performance. Use o sufixo `Holder` para esse tipo
de classe.

<!-- MainActivity.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/MainActivity-4.java }
  \caption{Classe Holder [MainActivity.java]}
\end{listing}

Levando em conta que estamos usando a interface `Cursor` em nosso
`Helper` temos que criar uma classe que extenda de `CursorAdapter` que
será responsável por definir o *layout* de cada linha da Lista. Crie uma
classe interna chamada `ContatoAdapter`. Iremos sobrescrever dois
métodos, `newView()` e `bindView()`, que são responsáveis por inflar
(*inflate*) uma nova linha e reciclar uma linha existente,
respectivamente.

<!-- MainActivity.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/MainActivity-5.java }
  \caption{Classe Adapter [MainActivity.java]}
\end{listing}

Com a introdução do `Helper` teremos que criar uma instância da classe
`Cursor` para popular nossa `ListView`. Vamos ao código-fonte:

<!-- MainActivity.java -->
\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/MainActivity-6.java }
  \caption{Popular ListView [MainActivity.java]}
\end{listing}

Nunca esquecendo de fechar o `helper` ao sair, pois assim garantimos que
a conexão com o banco será fechada.

### Editando dados existentes \label{ssec:edit}

Para a edição de informações usaremos o mesmo `Activity` que usamos para criar
um contato, ou seja, `SalvarActivity`. Mas para isso precisamos passar um
parâmetro para o `Activity`. Usaremos então um método do `Intent` que é
responsável por isso, `putExtra(chave, valor)`.

Para uma passagem de parâmetros segura devemos usar um *namespace* para
que não colida com nenhum nome já utilizado pelo Android. Assim, vamos
criar uma variável estática do tipo `String`. Isso acontecerá quando o
usuário pressionar a linha que ele deseja editar. Podemos fazer isso
utilizando a interface `OnItemClickListener`.

Vamos incrementar também o método `irParaSalvar` passando o parâmetro caso
haja um. Vamos ao código:

<!-- MainActivity.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/MainActivity-7.java }
  \caption{Passagem de parâmetros [MainActivity.java]}
\end{listing}

Agora é hora de tratar nosso parâmetro no `SalvarActivity`. Caso haja um
parâmetro precisamos obter os dados existentes no banco de dados para
então editá-lo. Neste caso precisaremos de mais dois métodos em
`ContatoHelper`, que são `ler` e `atualizar`.

<!-- ContatoHelper.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/ContatoHelper-4.java }
  \caption{Ler e atualizar dados existentes [ContatoHelper.java]}
\end{listing}

O próximo passo é tratar no `SalvarActivity` caso o parâmetro tenha sido
enviado ou não. Caso positivo devemos carregar os dados existentes no
banco de dados e depois atualizá-los.

<!-- SaveActivity.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/SalvarActivity-3.java }
  \caption{Usando Activity para criar ou atualizar [SalvarActivity.java]}
\end{listing}

Com isso encerramos um **CRUD** básico, mas completo. A seguir temos
implementações mais específicas que irão tornar nossa aplicação mais
profissional.
