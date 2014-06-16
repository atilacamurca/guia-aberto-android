# Serviços e Internet

Neste capítulo vamos implementar uma sincronização com servidor externo
dos contatos da nossa aplicação. Através de requisições HTTP seremos
capazes de enviar e receber dados do *smartphone* para um servidor, bem
como utilizar um recurso do Android chamado `Service`. Ele terá a
habilidade de executar tarefas em *background* enquanto o usuário
continua a utilizar o aparelho.

Faremos o seguinte, vamos inicialmente entender como funciona e criar um
cliente HTTP simples que irá enviar dados e receber respostas. Logo em
seguida vamos ver como funciona um `Service` e quais suas vantagens. Por
fim juntaremos esses recursos para criar um servidor de sincronização
dos contatos.

## Fazendo requisições HTTP

O Android vem com um cliente http embutido provido pela Apache, o
`HTTP Components` (<http://hc.apache.org/>). Na página
<http://hc.apache.org/poweredby.html> podemos observar que o Android
utiliza o `HttpCore` e o `HttpClient` 4.0 embutidos, ou seja, não é
preciso adicioná-los como bibliotecas para a utilização.

### Servidor de requisições HTTP

Para iniciar criaremos uma página em php para receber requisições HTTP e
retornar dados. A instalação do ambiente PHP no Ubuntu é bem simples.
Abra um terminal e siga os passos a seguir:

~~~
$ sudo su
# apt-get install php5 apache2
~~~

Agora que temos um servidor HTTP e uma linguagem de *script* para tratar
requisições, vamos a criação da página PHP. Ainda no terminal, faça:

~~~
# cd /var/www
# mkdir contatos
# cd contatos
# touch index.php
# chown usuario.usuario index.php
~~~

##### Observação

Note que na última linha troque `usuario.usuario` pelo seu nome de
usuário seguido de ponto e o nome do seu grupo (que por padrão é o mesmo
nome de usuário). Isso vai permitir que você possa editar o arquivo sem
ter que ser super usuário (*root*).

Edite o arquivo com o seguinte conteúdo.

<!-- index.php -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ php }{ source/index-1.php }
  \caption{script PHP para tratar requisições [index.php]}
\end{listing}

Esse trecho de código funciona da seguinte maneira. A página `index.php`
recebe um parâmetro chamado `saudacao` [linha \circled{11}]. Em seguida um teste é
realizado para saber qual a saudação e onde é determinado qual resposta
será devolvida [linhas \circled{13} a \circled{22}]. Para a resposta é utilizada uma
tecnologia chamada json. Mais detalhes no Apêndice \ref{appx:json}.

### App que realiza acesso externo

Com o servidor implementado precisamos criar um aplicativo Android capaz
de acessar nossa página. No eclipse, crie um novo projeto Android
chamado **Saudacao** usando nome do pacote `saudacao.app` e um `Activity`
chamado `MainActivity`.

Inicialmente criaremos uma classe `Requisicao` contendo o método público
`obterResposta`, além dos métodos privados `enviar`, `lerResposta` e
`parseJSON`.

<!-- Requisicao.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/Requisicao-1.java }
  \caption{Classe para realizar requisições HTTP [Requisicao.java]}
\end{listing}

Uma coisa chama bastante atenção neste trecho de código. Nossa URL usa o
`IP 10.0.2.2` que no Android refere-se ao `localhost`. Isso porque cada
instância do emulador roda sob um roteador/*firewall* virtual que o
isola das interfaces e configurações de rede da máquina e da *internet*.

Mais detalhes sobre esse assunto podem ser encontrados em
<http://developer.android.com/tools/devices/emulator.html#emulatornetworking>.

Vamos a implementação do método `enviar`.

<!-- Requisicao.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/Requisicao-2.java }
  \caption{Implementação do método enviar [Requisicao.java]}
\end{listing}

Em seguida temos o método `lerResposta`.

<!-- Requisicao.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/Requisicao-3.java }
  \caption{Implementação do método lerResposta [Requisicao.java]}
\end{listing}

Por fim o método `parseJSON`.

<!-- Requisicao.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/Requisicao-4.java }
  \caption{Implementação do método parseJSON [Requisicao.java]}
\end{listing}

Precisamos implementar o *layout* que será usado pelo `MainActivity`.

<!-- activity_main.xml -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ xml }{ source/activity_main-1.xml }
  \caption{layout para envio e recebimento de mensagens [activity_main.xml]}
\end{listing}

Esse é um layout bem simples contendo apenas um `TextView` para mostrar
a resposta, um `EditText` para escrever a saudação a ser enviada e um
`Button` que ao ser acionado envia a saudação ao servidor e apresenta a
resposta na tela.

Agora vem o `MainActivity`.

<!-- MainActivity.java -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ java }{ source/MainActivity-15.java }
  \caption{Utilização da classe \texttt{Requisicao} [MainActivity.java]}
\end{listing}

Execute o projeto e teste as saudações. Digite `oi` e `tchau` para obter
respostas. Com isso já somos capazes de enviar e obter dados de um
servidor remoto.

## Tarefas em *background* com `Service`

Um `Service` é utilizado quando se quer executar tarefas que podem durar
bastante tempo e que não tenham interação com o usuário ou para
responder a outras aplicações sobre algum serviço que sua aplicação
dispõe. Cada serviço deve ser regularmente mapeado no `AndroidManifest`
da mesma forma que os `Activity`’s.

Vamos voltar a implementar em cima da nossa aplicação **contatos** e
criar um `Service` que irá sincronizar os dados do celular com o
servidor.

<!-- http://www.felipesilveira.com.br/2010/05/content-providers/ -->
