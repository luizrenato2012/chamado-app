var app = angular.module('ChamadoControllerMdl',['ChamadoServiceMdl','angularUtils.directives.dirPagination']);

app.controller('chamadoControllerList', ['$scope','chamadoService' function($scope, chamadoService){
	$scope.chamados = [];
	$scope.listaMensagens=[];
	$scope.flagMensagemErro;
	$scope.flagMensagemSucesso;
	$scope.argumento;
	$scope.idExclusao;
	
	$scope.teste = function() {
		console.log('Teste');
	}
	
	$scope.lista = function(argumento) {
		if (!$scope.valida(argumento)) {
			console.log('Digite uma argumento valido');
			return;
		}
		chamado.lista(argumento).success(function(data){
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