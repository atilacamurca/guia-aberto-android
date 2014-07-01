# Preparando o Ambiente de Desenvolvimento

## Introdução

O desenvolvimento de aplicativos para a plataforma Android é feito na
linguagem Java. Para este guia serão utilizados os seguintes
aplicativos e bibliotecas:

<!-- change to ubuntu 14.04 -->

* Ubuntu 14.04
* Java JDK 6 ou 7
* Android SDK
* Android 4.4 API 17 e 2.2 API 8
* Android Studio
* Sqlite3
* Sqliteman
* Inkscape

Você pode estar se perguntando: "Por que utilizar essa configuração?".
Bom, para começar um ambiente de desenvolvimento precisa ser estável, e
para isso nada melhor que o <http://releases.ubuntu.com/trusty/>
(Ubuntu 14.04) por ser \gls{lts}.

A \gls{ide} Android Studio funciona independente do sistema operacional, então
podemos utilizar a versão mais recente.

Usaremos especificamente para os exemplos a seguir as versões 4.4 e 2.2
do Android. Essas \gls{api}'s são uma ótima escolha inicial, pois são as mais
utilizadas pelos aparelhos que rodam Android. É claro que você poderá
instalar outras versões e compilar seus aplicativos para *tablets*, etc.

## Instalação

### Java JDK 6

Para a instalação no Ubuntu 14.04 temos que habilitar um repositório de
terceiros, também conhecidos como \gls{ppa} (Personal Package Archives). Abra
um terminal e execute os passos a seguir para adicionar um repositório e
instalar o Java 6:

~~~
$ sudo su
# apt-add-repository ppa:flexiondotorg/java
# apt-get update
# apt-get install sun-java6-jdk
~~~

#### Um pouco de Linux

Para quem não está familiarizado com o ambiente Linux vamos a uma
pequena explicação. Nos comandos acima aparecem dois caracteres que não
devem ser escritos mas que representam algo importante no âmbito dos
comandos, são eles `$` e `#`. Estes caracteres indicam qual o nível do
usuário; `$` significa usuário comum, `#` representa super usuário
(`root`). No comando `sudo su` é onde trocamos de usuário comum para
super usuário. Neste momento você terá que entrar com sua senha de
*login*.

#### Java JDK 7

Segundo a página de Requerimentos do Sistema
(<http://developer.android.com/sdk/requirements.html>) do site oficial
do Android, é necessário uso do Java 6. Caso você queira utilizar o Java
7, você terá que configurar seu projeto Android para ser compilado com
suporte a versão 6.

A instalação do Java 7 no Ubuntu 14.04 pode ser feita da seguinte
maneira:

~~~
$ sudo su
# add-apt-repository ppa:webupd8team/java
# apt-get update
# apt-get install oracle-jdk7-installer
~~~

### Android Studio

\begin{figure}[h]
\centering
\includegraphics[scale=0.4]{img/preparando-ambiente/android-studio-splash.png}
\caption{Android Studio splash screen}
\end{figure}

A IDE Android Studio pode ser encontrada em
<http://developer.android.com/sdk/installing/studio.html>. É um ambiente
completo de desenvolvimento baseado na IntelliJ IDEA.

O Android Studio não possui instalador, no caso ele já vem
pré-compilado. Basta apenas descompactar e executar o arquivo
`bin/studio.sh`.

Para sua comodidade você pode adicionar o Android Studio no menu do
Ubuntu. Isso pode ser feito diretamente do Android Studio. Vá até o menu
`Tools` (ou `Configure` caso você não tenha nenhum projeto aberto)
$\rightarrow$ `Create Desktop Entry`. Daí ele pergunta se é
só para o seu usuário ou para todos. Caso escolha para todos ele irá
requisitar sua senha para fazer alterações como `root`.

Para saber como faz isso manualmente use a dica do blog MAD3 Linux
(<http://www.mad3linux.org>) - <http://va.mu/VSgR>. Essa dica irá lhe
mostrar como adicionar um item ao menu visível a todos os usuários.

### Android SDK \label{ssec:sdk}

O Android \gls{sdk} já vem junto do Android Studio, sendo assim apenas instale
as API's necessárias. Basta clicar em
`Tools` $\rightarrow$ `Android` $\rightarrow$ `SDK Manager` e selecionar as
versões 4.4 e 2.2.

### Android Virtual Device (AVD)

\begin{figure}[h]
	\includegraphics[scale=0.5]{img/preparando-ambiente/android-avd.png}
	\caption{Android AVD}
\end{figure}

Vamos aproveitar e criar nosso \gls{avd} para testar pela primeira vez nosso
emulador. Ainda no Android Studio clique em
`Tools` $\rightarrow$ `Android` $\rightarrow$ `AVD Manager`. Na aba
`Android Virtual Devices` clique em `New...`

Dê um nome. Você pode usar qualquer nomenclatura, mas é interessante que
tenha algo haver com a versão. Assim, caso você tenha que testar seu
código em outras versões você poderá saber qual emulador utilizar. Por
exemplo use `android-4.4`. Em `Target` escolha a versão, neste caso
`Android 4.4 (API 19)`. Pronto, apenas clique em `Create AVD`.

#### Dicas

A opção `Device` indica qual a resolução da tela do aparelho. Como não é
possível redimensionar a janela, em alguns monitores a janela fica maior
que a tela do seu monitor.

A opção `Snapshot` quando habilitada, serve para salvar o estado do
emulador. Isso faz com que da segunda inicialização em diante se torne
mais rápida.

A opção `SD Card` é ideal caso sua aplicação necessite guardar dados
como fotos, arquivos. O AVD irá reservar um espaço em seu HD permitindo
assim o acesso a dados pelo emulador.

#### Primeiro projeto Android \label{sssec:testando}

Para criar um projeto no Android Studio selecione
`File` $\rightarrow$ `New Project...`

Dê um nome qualquer ao seu aplicativo, por exemplo `hello.android`. Note
que o Android Studio tenta dar um nome ao seu pacote e ao diretório de
arquivos a partir do nome que você digitou. Deixe como está. Em
`Target SDK` é preciso escolher qual API vamos utilizar, em nosso caso
escolha a `API 19: Android 4.4`. Em `Minimum Required SDK`
escolha a `API 8: Android 2.2 (Froyo)` indicando que a versão mínima é a
`API 8`. Clique em `Next`.

É possível criar o ícone lançador logo ao criar o aplicativo. Selecione
da maneira que achar melhor e clique em `Next`. Em seguida temos a tela
inicial do projeto, a opção `Blank Activity` vem selecionado por padrão,
clique em `Next`. Por fim clique em `Finish`.

Após isso basta executar o projeto usando `Shift + F10` ou no menu
`Run` $\rightarrow$ `Run 'main'`. Se tudo tiver
dado certo é possível ver no emulador sua primeira aplicação rodando.

#### Dicas

Uma vez que você abriu o emulador não o feche. Você irá notar que ao
abrir pela primeira vez ele leva um tempo para isso. Neste caso ao
atualizar o código-fonte apenas rode o aplicativo novamente. O plugin
ADT fará com que o aplicativo seja reinstalado no emulador.

Faça o teste com alguns atalhos básicos:

* **`Alt + Enter`** Maximiza o emulador. Ideal para demostrações.
* **`Ctrl + F11`** Muda a orientação do emulador, retrato ou paisagem.
* **`F8`** Liga/desliga a rede.

Para mais detalhes acesse
<http://developer.android.com/tools/help/emulator.html#KeyMapping>

Outro elemento essencial é o `LogCat`. Ele é responsável por mostrar as
mensagens de *log* do emulador. Caso você encontre problemas com seu
código o `LogCat` será seu melhor aliado. Para acessá-lo utilize o
atalho `Alt + 6`.

### Sqlite3

Sendo o Sqlite o banco de dados embutido na plataforma Android, nada
melhor do que aprendermos um pouco sobre ele.

O Sqlite é um banco de dados relacional bastante utilizado por
dispositivos e sistemas embarcados por ser leve, robusto, de fácil
configuração e, acima de tudo, livre. Para a instalação, abra um
terminal como `root` e:

~~~
$ sudo su
# apt-get install sqlite3
~~~

Após a instalação é possível utilizar o Sqlite via linha de comando.
Faça *logoff* do usuário `root` e faça os seguintes testes:

~~~
# exit
$ sqlite
SQLite version 2.8.17
Enter ".help" for instructions
sqlite>
~~~

Você deverá ver algo parecido. Para sair utilize o comando `.exit`. Veja
outros detalhes na página oficial do projeto: <http://www.sqlite.org/>.

#### Tipos de dados

Utilize a tabela abaixo para criar suas tabelas futuramente.

-------------------------------------------------------------------------------------
**Nome**    **Descrição**
----------  -------------------------------------------------------------------------
`INTEGER`   valores inteiros, positivos ou negativos. Podem variar de 1 a 8 *bytes*.

`REAL`      valores reais ou decimais.

`TEXT`      usado para armazenar valores, não-limitado. Suporta várias codificações,
            por exemplo `UTF-8`.
            
`BLOB`      objetos binários tais como imagens, arquivos de texto, etc.
            Também possui tamanho não-limitado.
            
`NULL`      representa falta de informação.
-------------------------------------------------------------------------------------

Table: Tipos de dados do Sqlite

### Sqliteman

\begin{figure}[h]
\centering
\includegraphics[scale=0.4]{img/preparando-ambiente/sqliteman.png}
\caption{Sqliteman}
\end{figure}

Para uma gerência mais produtiva usaremos o Sqliteman para acessar e
modificar bancos de dados. A instalação é feita via linha de comando.
Abra um terminal e:

~~~
$ sudo su
# apt-get install sqliteman
~~~

Depois de instalado, acesse o aplicativo do menu principal do Ubuntu em
`Aplicativos` $\rightarrow$ `Escritório` $\rightarrow$ `Sqliteman`. Faça alguns
testes criando bancos de dados, depois crie algumas tabelas. Ele possui
assistentes que irão auxiliar nos primeiros momentos.

Por exemplo, crie uma base de dados e depois clique com o botão direito
do *mouse* em `Tables`. Utilize o assistente e veja como é simples criar
tabelas no sqlite.

<!-- exemplo_bd.sql -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ sql }{ source/exemplo-bd-1.sql }
  \caption{Exemplo de banco de dados [exemplo-bd.sql]}
\end{listing}

Observe que podemos fazer auto-relacionamento na tabela. Assim somos
capazes de executar a seguinte SQL, contando o número de distros que
derivam de uma outra original. Veja:

<!-- exemplo_bd.sql -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ sql }{ source/exemplo-bd-2.sql }
  \caption{Exemplo de \textit{query} com \textit{subquery} [exemplo-bd.sql]}
\end{listing}

Mais informações em: <http://sqliteman.com/>

### Inkscape

\begin{figure}[h]
\centering
\includegraphics[scale=0.45]{img/preparando-ambiente/inkscape.png}
\caption{Inkscape}
\end{figure}

Uma ótima ferramenta de desenho vetorial é o Inkscape. Ela será bastante
útil pois o desenvolvimento de aplicativos hoje em dia é baseado muito
em figuras para facilitar a navegação, identidade visual, entre outras
coisas.

A instalação é feita de forma simples. Num terminal:

~~~
$ sudo su
# apt-get install inkscape
~~~

Para dicas de como criar ícones para os diversos elementos do Android
veja a página
<http://developer.android.com/design/style/iconography.html>.

\begin{figure}[h]
	\includegraphics[scale=0.5]{img/preparando-ambiente/iconography-overview.png}
	\caption{Visão geral da iconografia do Android}
\end{figure}
