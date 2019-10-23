$(document).ready(function(){
	$(".conteudo").load("buscaros");
});

$("#clientes").click(function() {
    $(".conteudo").load("clientes");
});

$("#buscarOS").click(function() {
    $(".conteudo").load("buscaros");
});

$("#aberturaDeOs").click(function() {
    $(".conteudo").load("aberturadeos");
});

$("#ordemDeServico").click(function() {
    $(".conteudo").load("ordemdeservico");
});

$("#botaoSair").click(function(){
	window.location = "../";
});