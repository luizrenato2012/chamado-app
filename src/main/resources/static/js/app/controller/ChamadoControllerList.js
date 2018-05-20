var app = angular.module('ChamadoControllerListMdl',['ChamadoServiceMdl', 'UtilServiceMdl','angularUtils.directives.dirPagination']);

app.controller('chamadoControllerList', ['$scope','chamadoService','utilService', function($scope, chamadoService, utilService){
	$scope.chamados = [];
	$scope.listaMensagensChamado=[];
	$scope.flagMensagemErro;
	$scope.flagMensagemSucesso;
	$scope.flagExibeMensagem;
	$scope.argumento;
	$scope.idExclusao;
	
	(function(){
		utilService.getListaSistemas().then(
				function(data){
					$scope.sistemas = data;
				},
				function(data){
					console.log('Erro ao listar sistemas: ' + data);
				});
		utilService.getListaSituacoes().then(
				function(data){
					$scope.situacoes = data;
				},
				function(data){
					console.log('Erro ao listar situacoes '+ data);
				});
	})();
	
	$scope.lista = function(argumento) {
		if (argumento== undefined) {
			console.log('Argumento invalidos');
			$scope.flagExibeMensagem = true;
			$scope.exibeMensagemErro('Argumento invalidos');
			return;
		}
		
		if (argumento.dataDe==undefined && argumento.dataAte==undefined && argumento.situacao==undefined && argumento.sistema==undefined 
				&& argumento.descricao ==undefined && argumento.numero==null) {
			console.log('Campos invalidos');
			$scope.exibeMensagemErro('Argumento invalidos');
			return;
		}
		chamadoService.lista(argumento).success(function(data){
			$scope.chamados = data;
			$scope.exibeMensagemSucesso(`Encontrados ${data.length} registros.`);
		}).error(function(data, status){
			console.log(data);
			$scope.exibeMensagemErro('Erro ao pesquisar chamados');
		});
	}
	
	$scope.valida= function (argumento) {
		return argumento.sistema || argumento.situacao || argumento.descricao || argumento.dataDe 
			|| argumento.dataAte;
	}
	
	$scope.exibeMensagemErro= function(mensagem) {
		$scope.flagMensagemErro=true;
		$scope.flagMensagemSucesso=false;
		$scope.listaMensagensChamado = [{"mensagem" : mensagem}];
	}
	
	$scope.exibeMensagemSucesso = function(mensagem) {
		$scope.flagExibeMensagem = true;
		$scope.flagMensagemSucesso=true;
		$scope.flagMensagemErro=false;
		$scope.listaMensagensChamado = [ {"mensagem": mensagem}];
	}
	
	$scope.ocultaMensagem = function() {
		$scope.flagExibeMensagem= false;
	}
	
	
}]);