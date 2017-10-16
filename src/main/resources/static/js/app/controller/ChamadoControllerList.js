var app = angular.module('ChamadoControllerListMdl',['ChamadoServiceMdl', 'UtilServiceMdl','angularUtils.directives.dirPagination']);

app.controller('chamadoControllerList', ['$scope','chamadoService','utilService', function($scope, chamadoService, utilService){
	$scope.chamados = [];
	$scope.listaMensagens=[];
	$scope.flagMensagemErro;
	$scope.flagMensagemSucesso;
	$scope.argumento;
	$scope.idExclusao;
	$scope.sistemas = utilService.getListaSistemas();
	$scope.situacoes = utilService.getListaSituacoes();
	
	
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