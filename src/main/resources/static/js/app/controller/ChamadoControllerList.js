var app = angular.module('ChamadoControllerListMdl',['ChamadoServiceMdl', 'UtilServiceMdl','angularUtils.directives.dirPagination']);

app.controller('chamadoControllerList', ['$scope','chamadoService','utilService', function($scope, chamadoService, utilService){
	$scope.chamados = [];
	$scope.listaMensagens=[];
	$scope.flagMensagemErro;
	$scope.flagMensagemSucesso;
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
		chamadoService.lista(argumento).success(function(data){
			$scope.chamados = data;
		}).error(function(data, status){
			console.log(data);
			//$scope.exibeMensagemErro(data);
		});
	}
	
	$scope.valida= function (argumento) {
		return argumento.sistema || argumento.situacao || argumento.descricao || argumento.dataDe 
			|| argumento.dataAte;
	}
	
	
}]);