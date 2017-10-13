var modulo = angular.module('TesteControllerMdl',['UtilServiceMdl']);

modulo.controller('testeController',['$scope','utilService', function($scope, utilService){
	$scope.msgsTest=[];
	$scope.flag=true;
	$scope.tipo;
	$scope.valorData;
	
	
	$scope.executa = function(tipo) {
		$scope.tipo = tipo;
		console.log(`> Tipo ${$scope.tipo}`);
		$scope.msgsTest=[
			{"mensagem" :`Teste de mensagem ${$scope.tipo}` },
			{"mensagem" :`Teste de mensagens` }
		];
		console.log($scope.msgsTest);
	}
	
	$scope.testaData = function(data) {
		console.log('acionado botao');
		console.log(data);
		console.log( utilService.transformaData(data) );
		
	}
	
	
}]);