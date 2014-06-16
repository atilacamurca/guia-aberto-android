# JSON \label{appx:json}

Acrônimo para JavaScript Object Notation (Notação de Objetos
JavaScript), é um formato leve para intercâmbio de dados computacionais,
ou seja, é uma ponte entre a conversação entre linguagens diferentes
(<http://www.json.org/json-pt.html>).

## Estrutura

A representação de dados em JSON é bem simples. Temos essencialmente
objetos, *array*s, par de chave e valor.

Um objeto é representado usando chaves da seguinte forma:

\begin{figure}[h]
	\centering
	\includegraphics[scale=0.5]{img/json/object.png}
	\caption{Objeto JSON}
\end{figure}

Já um *array* é representado utilizando colchete:

\begin{figure}[h]
	\centering
	\includegraphics[scale=0.5]{img/json/array.png}
	\caption{Array JSON}
\end{figure}

O valor (*value*) pode ser uma *string*, um número, ou `true` ou
`false`, `null`, um *array*, ou ainda um objeto. Estas estruturas podem
estar aninhadas.

\begin{figure}[h]
	\centering
	\includegraphics[scale=0.5]{img/json/value.png}
	\caption{Possíveis valores}
\end{figure}

Uma *string* é uma coleção de nenhum ou mais caracteres Unicode,
envolvido entre aspas duplas usando barras invertidas como caracter de
escape. Um caracter está representando como um simples caracter de
*string*. Uma cadeia de caracteres é parecida com uma cadeia de
caracteres em C ou Java.

\begin{figure}[h]
	\includegraphics[scale=0.5]{img/json/string.png}
	\caption{Formato de uma string}
\end{figure}

Um número é similar a um número em C ou Java, exceto quando não se usa
os números octais ou hexadecimais.

\begin{figure}[h]
	\includegraphics[scale=0.5]{img/json/number.png}
	\caption{Formato de um número}
\end{figure}

## Exemplo

Para mostrar como funciona vamos a um exemplo bem prático. Acesse o site
<http://www.jsoneditoronline.org/>, onde é possível escrever JSON, visualizar
e validar.

Escreva o trecho abaixo e veja como é simples escrever e entender JSON.

<!-- documento.json -->

\begin{listing}[H]
  \inputminted[linenos=true,frame=bottomline,tabsize=3]{ js }{ source/json/documento-1.json }
  \caption{Exemplo arquivo JSON [documento.json]}
\end{listing}





















