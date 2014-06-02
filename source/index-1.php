<?php
/*
 * Exemplo página HTTP com JSON
 */

$saudacao = $_REQUEST['saudacao'];
$saida = new stdClass;
switch($saudacao) {
case 'oi':
   $saida->resposta = 'oi, tudo bem?';
   break;
case 'tchau':
   $saida->resposta = 'até logo!';
   break;
default:
   $saida->resposta = 'desculpe mas não entendi...';
}

header("Pragma: no-cache");
header("Cache: no-cahce");
header("Cache-Control: no-cache, must-revalidate");
header("Content-type: text/json");
echo json_encode($saida);
?>
