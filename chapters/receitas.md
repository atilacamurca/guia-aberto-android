# Livro de Receitas

## Mostrando Diálogos

No Android, podemos criar diálogos no `Activity` mostrando opções ao
usuário, como por exemplo, escolher itens de uma lista, ou responder sim
ou não a uma ação, etc.

Vamos incrementar algumas partes de nosso código e tentar encaixar
algumas funcionalidades relacionadas.

### Editar/Excluir ao clicar e segurar na ListView

Vamos implementar uma ação comum no mundo Android, que é a seguinte: ao
clicar e segurar num item da `ListView`, ele mostra opções editar e
excluir, por exemplo. Isto pode ser feito facilmente usando
`AlertDialog.Builder`, uma classe com métodos pré-prontos para serem
usados por você.

Neste exemplo, precisaremos editar `ContatoHelper` e adicionar um método
para deletar um contato, editar nosso `MainActivity` no método
configurar e adicionar um *Listener* que ao clicar e segurar num item da
`ListView` um método é acionado. Vamos a implementação:

<!-- ContatoHelper.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/ContatoHelper-5.java }
  \caption{Deletar dados existentes [ContatoHelper.java]}
\end{listing}

<!-- MainActivity.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/MainActivity-8.java }
  \caption{Adicionar Listener para click longo [MainActivity.java]}
\end{listing}

Note a necessidade de um novo método em `MainActivity`, o
exibirMensagem. Ele é bastante útil quando se quer exibir uma mensagem
rapidamente e depois ela suma. Para isso usamos a classe `Toast`.

#### Interface como parâmetro de um método

Você já deve ter notado o uso de *interface*'s como parâmetro dos
métodos, por exemplo na linha \circled{4} e \circled{11} do código acima. Essa prática
obriga ao programador implementar a classe na passagem dos parâmetros.

Essa ideia vem de algumas linguagens de programação que possuem funções
como parâmetros para outras funções. Como o Java não suporta essa
característica, a solução veio em forma de uma *interface*, a qual o
programador é obrigado a implementar seus métodos. Com isso o método que
recebe a *interface* como parâmetro sabe exatamente o que ela tem
disponível.

A partir dessa observação, podemos justificar o uso da palavra reservada
final em alguns parâmetros dos métodos acima. Isso acontece porque
alguns parâmetros são utilizados dentro da implementação das
*interface*’s.

Caso haja a necessidade de utilizar uma implementação em outra classe
você pode criar uma classe que implementa uma *interface*, por exemplo a
*interface* `OnItemLongClickListener`. Daí para a passagem do parâmetro
apenas crie uma instância da classe. Por exemplo, suponha que você tenha
uma classe chamada `OpcoesContato` que implementa
`OnItemLongClickListener`, nesse caso a linha \circled{4} se tornaria:

`listView.setOnItemLongClickListener(new OpcoesContato());`

### Diálogo de confirmação

Deletar dados é uma ação que deve ser feita com cuidado, então sempre é
bom confirmar com o usuário se ele deseja realmente deletar, no nosso
caso, um contato. Para isso usaremos o `AlertDialog.Builder` mais uma
vez, agora apenas com uma mensagem e os botões *Sim* ou *Não*.

Ainda em `MainActivity` criaremos um outro `AlertDialog.Builder` no
momento que o usuário clicar em `Deletar`. Segue o trecho:

<!-- MainActivity.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/MainActivity-9.java }
  \caption{Diálogo de confirmação ao deletar contato [MainActivity.java]}
\end{listing}

Pronto, agora o trecho que deleta o contato foi movido para dentro do
*Listener* do botão *Sim*. No botão *Não* passamos `null` no *Listener*,
pois caso seja a opção escolhida apenas fazemos nada. Você pode, se
quiser, criar um *Listener* e mostrar uma mensagem do tipo, *Cancelado
pelo usuário*, para isso usando o método `exibirMensagem`.

### Entrada de diferentes tipos de dados

O Android foi desenvolvido com muitos recursos pré-prontos para
facilitar o desenvolvimento de aplicações. Um recurso bastante útil é a
distinção dos dados que irão ser inseridos nos `TextView`'s. Com isso o
teclado virtual do cliente se adapta ao tipo de dado que será inserido.
No nosso caso faremos distinção do campo `telefone`, onde apenas números
e hífens (-) podem ser inseridos, e o campo `e-mail` onde a presença do
arroba (@) e pontos (.) são elementos essenciais.

Vejamos alguns valores aceitos pelo `inputType`:

-   Para textos:
    -   `text`
    -   `textCapCharacters`
    -   `textMultiLine`
    -   `textUri`
    -   `textEmailAddress`
    -   `textPersonName`
    -   `textPassword`
    -   `textVisiblePassword`
-   Para números:
    -   `number`
    -   `numberSigned`
    -   `numberDecimal`
    -   `phone`
    -   `datetime`
    -   `date`
    -   `time`

Precisaremos alterar apenas o `salvar.xml` localizado em `res/layout`.
Localize o atributo `inputType` dos campos `telefone` e `e-mail` e
altere os valores da seguinte maneira:

<!-- res/layout/salvar.xml -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ xml }{ source/salvar-2.xml }
  \caption{Distinção de dados [res/layout/salvar.xml]}
\end{listing}

### Validação de dados

Mesmo configurando um `inputType` para seu `TextView` pode não ser o
bastante para que os dados inseridos estejam corretos. Para isso
usaremos a classe `Patterns` do pacote `android.util`. Nela podemos
encontrar alguns objetos bastante úteis na hora de validar dados. Entre
eles estão os objetos `Patterns.EMAIL ADDRESS` e `Patterns.PHONE`. Com
eles podemos validar de forma simples os dados inseridos em nosso
formulário.

Em nosso `SalvarActivity` adicionaremos um método validar passando como
parâmetro um `ContentValues`. Copie o método `exibirMensagem` da classe
`MainActivity` para mostrar uma mensagem caso alguma validação seja
falsa.

##### OBS:

Para um melhor reuso crie uma classe abstrata que implementa o método
`exibirMensagem` e que extenda de `Activity` e faça com que seus
`Activity`'s herdem dela. É uma boa prática.

Vamos ao trecho de código:

<!-- SaveActivity.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/SalvarActivity-4.java }
  \caption{Validação dos dados [SalvarActivity.java]}
\end{listing}

### Fazendo uma ligação

Já que estamos fazendo uma lista de contatos nada melhor que usar o
número do telefone dos contatos inseridos para realizar chamadas. Para
isso vamos aprender um pouco sobre **Permissões**.

Permissões no Android são definidas no `AndroidManifest.xml`. Ao
instalar seu aplicativo, o usuário saberá quais as permissões que o seu
aplicativo necessita para ser executado.

Por padrão, o Android traz uma série de permissões que auxiliam seu
aplicativo a se comunicar com o aparelho. Abaixo alguns exemplos:

-   Verificação
    -   `ACCESS_NETWORK_STATE`
    -   `ACCESS_WIFI_STATE`
    -   `BATTERY_STATS`
-   Comunicação
    -   `BLUETOOTH`
    -   `CALL_PHONE`
    -   `INTERNET`
    -   `SEND_SMS`

A lista completa pode ser vista em
<http://developer.android.com/reference/android/Manifest.permission.html>.

Edite o `AndroidManifest.xml` e adicione a permissao `CALL_PHONE`.

<!-- AndroidManifest.xml -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ xml }{ source/AndroidManifest-3.xml }
  \caption{Permissão de realizar chamadas [AndroidManifest.xml]}
\end{listing}

Agora vamos adicionar um item ao diálogo que aparece ao clicar e segurar
um item da `ListView`. Ele servirá para implementarmos o trecho que
realiza a chamada. Vamos a ele:

<!-- MainActivity.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/MainActivity-10.java }
  \caption{Item chamar no diálogo [MainActivity.java]}
\end{listing}

Nesse trecho de código podemos ver o uso de `Intent`'s do prórpio
Android, nesse caso o Intent.ACTION\_CALL (veja linha \circled{14}). Ele serve para
chamar uma `Activity` que realize ligações. Atente apenas para um
detalhe - esse `Intent` faz a chamada sem confirmação. Caso você queira
que o usuário possa visualizar o número no discador use o `Intent`
Intent.ACTION\_DIAL. Faça esse teste e veja a diferença entre os
`Intent`'s.

Veja mais detalhes em
<http://developer.android.com/reference/android/content/Intent.html>.

### Enviando e-mail

Para envio de e-mail você pode simplesmente usar a aplicação de e-mail
padrão do aparelho. Seguindo o mesmo princípio do exemplo anterior vamos
apenas inserir um trecho de código no método configurar da classe
`MainActivity`:

<!-- MainActivity.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/MainActivity-11.java }
  \caption{Item enviar e-mail no diálogo [MainActivity.java]}
\end{listing}

Ao testar no emulador você receberá a mensagem: **No applications can
perform this action**. Traduzindo quer dizer que: Nenhuma aplicação pode
executar esta ação. Em outras palavras, nenhum cliente de e-mail foi
encontrado.

## Forçando região para teste

Para podermos testar as `strings` de *i18n* podemos forçar o `Activity`
a utilizar uma determinada linguagem. Isso se dá por meio da classe
`Locale`. Façamos um teste com o `SalvarActivity` inserindo o trecho de
código abaixo no método `onCreate`. Vamos a ele:

<!-- SaveActivity.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/SalvarActivity-5.java }
  \caption{Forçando região [SalvarActivity.java]}
\end{listing}

Para visualizar a mudança crie *strings* no seu arquivo `strings.xml`.
Substitua as *strings* `Nome`, `Telefone`, `E-mail` e `Salvar` pelos
respectivos valores em inglês `Name`, `Phone`, `E-mail` e `Save`. Agora
crie outro arquivo `strings.xml` dentro do diretório
`/res/values-pt-rBR` e insira as mesmas *strings* citadas anteriormente,
traduzindo cada valor.

Faça testes comentando a chamada para a função `forceLocale` e veja as
mudanças.

### Forçando região pelo emulador

A maneira mais rápida e prática de forçar a região é pelo próprio
emulador. Vá até a lista de aplicativos e procure por `Custom Locale`.
Depois pesquise por `pt_BR` e caso não encontre clique em
`Add New Locale`. Digite `pt_BR` e clique em `Add and Select`.

## Utilizando as Preferências do Android

O Android já disponibiliza uma maneira de criar preferências de forma
fácil. Para demonstrar implementaremos um exemplo bem amplo, que irá nos
ajudar a entender ainda mais de Android. Para começar adicionaremos um
nova coluna a nossa tabela `contato` chamada `grupo`. Depois
adicionaremos um *array* de *string*'s ao nosso arquivo `strings.xml` e
ainda vamos aprender a utilizar um `Spinner`, também conhecido como
*combo box*. Por último, e não menos importante, usaremos as
preferências para tornar padrão um valor de nosso `Spinner`.

### Atualizando colunas de uma tabela

Como visto em \ref{ssec:model}, a classe `SQLiteOpenHelper` obriga-nos a
implementar os métodos `onCreate` e `onUpgrade`. Neste ponto será necessário
o uso do método `onUpgrade`. Ele serve, como o nome sugere, para atualizar
a \gls{ddl} do banco de dados. Isso é útil quando seu cliente já possui uma
versão do seu aplicativo instalada e ele quer apenas atualizar para uma
nova versão. Também será necessário adicionar a coluna `grupo` nas
*queries*. Abra a classe `ContatoHelper` em `contatos.app.model` e faça
as modificações:

<!-- ContatoHelper.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/ContatoHelper-6.java }
  \caption{Nova coluna grupo na base de dados [ContatoHelper.java]}
\end{listing}

Vemos neste exemplo o uso da classe `Log` do pacote `android.util`. Ela
possui apenas métodos estáticos, assim não precisamos instanciar, apenas
faça a chamada dos métodos. Temos:

* `Log.w()`: para mostrar *warning*’s, ou seja, avisos.
* `Log.e()`: para mensagens de erro.
* `Log.d()`: para mensagens *debug*.
* `Log.i()`: para mensagens informativas.
* `Log.v()`: para outras mensagens.

<!-- ContatoHelper.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/ContatoHelper-7.java }
  \caption{Modificação nas queries [ContatoHelper.java]}
\end{listing}

### Array de Strings

No arquivo de *string*'s do Android é possível criar vários recursos.
Dentre eles temos Cor, Dimensão, Estilo/Tema. Usando a ferramenta ADT,
crie um `String Array` em `strings.xml` dentro de `res/values` e
adicione alguns itens para representar os valores da coluna `grupo`, e
outro `String Array` para representar os índices:

##### Dica:

você pode tentar implementar o trecho usando uma tabela do banco de
dados. A ideia é a mesma, neste caso não seria necessário o uso de
`String Array`'s.

<!-- strings.xml -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ xml }{ source/strings-1.xml }
  \caption{Array de Strings [strings.xml]}
\end{listing}

### Spinner, diálogo de seleção

O *Spinner* é ideal quando temos que escolher entre valores fixos, sejam
eles estáticos ou dinâmicos. Nosso exemplo irá utilizar valores
estáticos para popular o mesmo. Para isso utilizaremos o `array_grupos`
que criamos em `res/values/strings.xml`. Também veremos um exemplo de
uso da classe `android.R` como visto em \ref{par:r} em que é explicado a
diferença entre as classes de recursos. Mas antes temos que atualizar
nosso *layout* `salvar.xml`. Adicione o *Spinner* logo abaixo do
`e-mail`, como mostra o trecho abaixo:

<!-- res/layout/salvar.xml -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ xml }{ source/salvar-3.xml }
  \caption{Adicionando elemento Spinner [res/layout/salvar.xml]}
\end{listing}

Agora já podemos carregar e popular o *Spinner* na classe
`SalvarActivity`.

<!-- SaveActivity.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/SalvarActivity-6.java }
  \caption{Utilização de Spinner [SalvarActivity.java]}
\end{listing}

Note a utilização da classe `android.R` nas linhas \circled{10} e \circled{11}. Eles servem
para definir o *layout* do *Spinner*. Isso quer dizer que você pode
implementar como seu *Spinner* irá aparecer na tela da mesma maneira que
implementamos a linha da `ListView` em \ref{ssec:listview}.

### A classe PreferenceActivity

Afinal vamos utilizar as preferências do Android. Neste exemplo a
usaremos para decidir qual grupo do `array_grupos` aparecerá selecionado
por padrão. A princípio é um exemplo bem simples, mas que pode ser
ajustado para outras finalidades, o que importa realmente é a ideia.

Para começar criaremos um *layout* em `res/layout` chamado
`preferencias.xml`. No projeto clique com botão direito do *mouse* e
selecione `New` $\rightarrow$ `Other...`, pesquise por `Android XML File` e
`Next`. Em `Resource Type` escolha `Preference` e escreva `preferencias`
em `File`. Logo abaixo em `Root Element` escolha a opção
`PreferenceScreen`, então `Finish`.

Utilizando a ferramenta ADT adicione um elemento `ListPreference` a
`PreferenceScreen`. Defina os parâmetros necessários como mostra o
código abaixo:

<!-- preferencias.xml -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ xml }{ source/preferencias-1.xml }
  \caption{XML descrevendo layout de preferências [res/xml/preferencias.xml]}
\end{listing}

Crie uma nova classe chamada `EditarPreferencias` em `contatos.app.view`
herdando de `PreferenceActivity`. Agora de uma maneira bem simples
implementaremos essa classe. Veja:

<!-- EditarPreferencias.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/EditarPreferencias-1.java }
  \caption{Activity para mostrar preferências [EditarPreferencias.java]}
\end{listing}

Para chamar a nova `Activity` temos ainda que mapeá-la no
`AndroidManifest` e criar um item no menu.

<!-- AndroidManifest.xml -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ xml }{ source/AndroidManifest-4.xml }
  \caption{Mapeando Activity EditarPreferencias [AndroidManifest.xml]}
\end{listing}

<!-- res/menu/main_menu.xml -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ xml }{ source/main_menu-2.xml }
  \caption{Adicionar item Preferências ao menu principal [res/menu/main_menu.xml]}
\end{listing}

Agora que adicionamos um item ao menu, temos que capturar o evento
quando o usuário o selecionar e direcioná-lo às Preferências. Isso deve
ser feito em `MainActivity`.

<!-- MainActivity.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/MainActivity-12.java }
  \caption{Ir para Preferências pelo menu principal [MainActivity.java]}
\end{listing}

Note que para ter um código mais eficiente e otimizado tivemos que mudar
o método `irParaSalvar` para `irPara` passando como parâmetro a classe que
desejamos ir. Essa mudança é boa mais causa um impacto em outros trechos
do código. Conserte-os da seguinte maneira:

<!-- MainActivity.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/MainActivity-13.java }
  \caption{Mudança em método irParaSalvar [MainActivity.java]}
\end{listing}

Por fim temos que selecionar o item que o usuário quer que esteja
selecionado por padrão ao inserir um novo contato. Assim, em
`SalvarActivity` adicione o trecho:

<!-- SaveActivity.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/SalvarActivity-7.java }
  \caption{Obtem o valor padrão definido nas Preferências [SalvarActivity.java]}
\end{listing}

## Grupo de Contatos usando Grid

Uma das coisas mais legais quando falamos de aparelhos móveis é a ideia
da visão da lista de aplicativos usada comumente com o ícone e o texto
logo abaixo. Essa ideia pode ser facilmente implementada em um
aplicativo Android usando `GridView`.

Nessa implementação vamos criar uma tela que mostra os grupos de
contatos em forma de *Grid* e ao clicar levaremos o usuário a lista de
contatos mostrando apenas aqueles contatos de um determinado grupo.

### Layout usando GridView

Para começar criaremos um *layout* em `res/layout` chamado
`grupos_item.xml`. Ele irá conter a imagem e o texto que serão exibidos
no `GridView`. Faça como mostra o trecho abaixo:

<!-- res/layout/grupos_item.xml -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ xml }{ source/grupos_item-1.xml }
  \caption{Item do Layout de Grupos [res/layout/grupos\b{ }item.xml]}
\end{listing}

Hora de criar o `GridView`. Para isso crie um novo *layout* em
`res/layout` chamado `grupos.xml`. Adicione apenas um `GridView` como
mostra o trecho de código abaixo:

<!-- res/layout/grupos.xml -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ xml }{ source/grupos-1.xml }
  \caption{Layout de Grupos [res/layout/grupos.xml]}
\end{listing}

##### Dica:

a ferramenta ADT provê uma forma de pré-visualizar seu *layout*. Note
que na linha 12 temos um comentário e nele temos a referência ao
*layout* `grupos_item`. Para isso apenas clique com botão direito do
*mouse* na `GridView` e na opção
`Preview Grid Content` $\rightarrow$ `Choose Layout...` selecione
`grupos_item`.

### Activity para visualizar os Grupos

Como é de se imaginar temos que criar uma `Activity` para visualizar os
Grupos.

<!-- GruposActivity.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/GruposActivity-1.java }
  \caption{Activity para visualizar Grupos [GruposActivity.java]}
\end{listing}

Temos que criar duas classes internas para nos ajudar a criar cada item
do grupo de contatos. Para isso usaremos a classe abstrata
`BaseAdapter`.

<!-- GruposActivity.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/GruposActivity-2.java }
  \caption{Adapter responsável por cada item do Grid [GruposActivity.java]}
\end{listing}

Nesse momento precisamos usar a ferramenta Inkscape e criar alguns
ícones. Para os exemplos a seguir você deve criar um ícone para cada
item do grupo, sendo eles:

-   amigos
-   trabalho
-   conhecidos
-   família

Para título de exemplo crie apenas ícones simples e depois tente fazer
itens mais sofisticados. Em
<http://developer.android.com/design/style/iconography.html> você pode
ver como devem ser criados os ícones para seu aplicativo.

#### Criando ícones com Inkscape

Use o Inkscape para criar um novo ícone. No menu
`Arquivo` $\rightarrow$ `Propriedades do Desenho...` ou apenas
`Shift + Ctrl + D` e altere a largura e altura para `512px`.

Aperte `5` para centralizar a folha e crie um quadrado (`F4`) um pouco
menor que a página. Utilize `Ctrl` para criar um quadrado perfeito.
Altere a borda usando o círculo branco no canto superior direito do
quadrado. Selecione uma cor legal.

O Android possui uma paleta de cores que pode lhe ajudar inicialmente.
Veja a tabela abaixo:

------------------------------------------------------------------------------------------------
**Cor**     **Tom claro**                               **Tom escuro**
----------  --------------------------------------  --------------------------------------------
Azul        `#33B5E5` \squarecolor{android-blue}    `#0099CC` \squarecolor{android-dark-blue}

Roxo        `#AA66CC` \squarecolor{android-purple}  `#9933CC` \squarecolor{android-dark-purple}

Verde       `#99CC00` \squarecolor{android-green}   `#669900` \squarecolor{android-dark-green}

Laranja     `#FFBB33` \squarecolor{android-orange}  `#FF8800` \squarecolor{android-dark-orange}

Vermelho    `#FF4444` \squarecolor{android-red}     `#CC0000` \squarecolor{android-dark-red}
------------------------------------------------------------------------------------------------

Table: Paleta de cores do Android

Mais detalhes em <http://developer.android.com/design/style/color.html>.

Para alterar a cor clique com botão direito do *mouse* no quadrado e
selecione `Preenchimento e contorno`. Observe a entrada de texto onde
aparece `RGBA`. Altere com os valores acima mantendo os dois últimos,
pois eles são referentes a transparência (_alpha_).

Chegou a hora de exportar seu ícone para os tamanhos sugeridos pelo
Android. Basta ir no menu `Arquivo` $\rightarrow$ `Exportar Bitmap...` ou
ainda `Shift + Ctrl + E`. Os tamanhos estão definidos na tabela abaixo:

----------------------------------
**Local**             **Tamanho**
--------------------  ------------
`res/drawable-xhdpi`  `96px`

`res/drawable-hdpi`   `72px`

`res/drawable-mdpi`   `48px`

`res/drawable-ldpi`   `36px`
----------------------------------

Table: Localização e tamanho dos ícones

Exporte o ícone para cada um desses diretórios, crie-os caso não
existam. Como temos quatro grupos crie quatro ícones usando cores
diferentes. Siga a nomenclatura sugerida em \ref{sssec:nomeicones} Convenção
de nomes para ícones, exemplo: `ic_launcher_grupo_amigos.png`.

### Implementando o Adapter

<!-- GruposActivity.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/GruposActivity-3.java }
  \caption{implementação do Adapter [GruposActivity.java]}
\end{listing}

Como visto em \ref{ssec:listview} Mostrando os dados na View, no `Adapter`
podemos fazer *cache* dos objetos e otimizar o código. Isso pode ser
observado a partir da linha \circled{25} até a linha \circled{35}, onde um teste é realizado
para ver se a linha está em *cache*.

##### Observação:

na linha \circled{37} existe um trecho de código que não está nada otimizado. No
entanto usando `string-array` é a única maneira de dar certo. Isso
poderia ser evitado se os grupos de contatos fossem retirados do banco
de dados. Seguindo as instruções antes abordadas tente você mesmo
implementar usando banco de dados. É uma ótima maneira de aprender
melhor como funciona um aplicativo Android.

Finalize adicionando o `Activity` no `AndroidManifest.xml`. Clique na
aba inferior em `Application` e em `Application Nodes` clique em `Add`.
Escolha `Activity` na lista de opções e no atributo `Name` clique em
`Browser` e busque por `GruposActivity`.

Para visualizar a nova `Activity` é preciso adicionar um novo item no
menu principal. Reveja \ref{ssec:act} Activity, e implemente essa parte. Não
esqueça de adicionar uma condição no método `onOptionsItemSelected` da
classe `MainActivity`.

### Selecionando contatos de um determinado grupo

Para não deixar dúvidas quanto a implementação deste trecho vamos fazer
com que ao clicar em um determinado grupo, somente contatos daquele
grupo apareçam na lista que fica em `MainActivity`.

Primeiro sobrescreva o método listar da classe `ContatoHelper` para que
ele receba um parâmetro, que irá representar o grupo.

<!-- ContatoHelper.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/ContatoHelper-8.java }
  \caption{Método listar com parâmetro grupo [ContatoHelper.java]}
\end{listing}

A implementação do clique em um item do *grid* é semelhante a vista em
\ref{ssec:edit} Editando dados existentes, onde criamos uma variável
contendo o *namespace* do nosso parâmetro.

Copie o método `irPara` da classe `MainActivity`, mudando apenas o
primeiro parâmetro de `intent.putExtra` para o novo *namespace*, na linha
\circled{17}.

Por fim, inclua o método `configurar` em `onCreate`, o qual será responsável
por configurar para onde ir ao clicar em um item do *grid*.

<!-- GruposActivity.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/GruposActivity-4.java }
  \caption{Evento de clique em um item do \textit{grid} [GruposActivity.java]}
\end{listing}

Agora é preciso capturar o parâmetro em `MainActivity`. Para isso basta
fazer como descrito abaixo:

<!-- MainActivity.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/MainActivity-14.java }
  \caption{Captura de parâmetro vindo de \texttt{GruposActivity} [MainActivity.java]}
\end{listing}

Muito bem, eis que temos um aplicativo já bem completo. Se tudo deu
certo você deve ter uma tela como vemos abaixo:

\begin{figure}[h]
	\centering
	\includegraphics[scale=0.6]{img/screenshot-grupos.png}
	\caption{Tela de Grupos}
\end{figure}
