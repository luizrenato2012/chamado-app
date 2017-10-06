var modulo = angular.module('TesteControllerMdl',[]);

modulo.controller('testeController',['$scope',function($scope){
	$scope.msgsTest=[];
	$scope.flag=true;
	$scope.tipo;
	
	$scope.executa = function(tipo) {
//		$scope.tipo=$scope.flag;
//		$scope.flag = !$scope.flag;
		//$scope.msgTest=`Teste de mensagem ${$scope.flag}`;
		$scope.tipo = tipo;
		console.log(`> Tipo ${$scope.tipo}`);
		$scope.msgsTest=[
			{"mensagem" :`Teste de mensagem ${$scope.tipo}` },
			{"mensagem" :`Teste de mensagens` }
		];
		console.log($scope.msgsTest);
		
	}
}]);

//modulo.directive('alertaMensagem', function(){
//	return {
//		restrict: "E",
//		templateUrl: 'diretiva.html',
//		scope : {
//			//mapeamento variavel escopo p/ atributo tag
//			mensagens : "=textos",
//			tipoMensagem: "=tipo",
//		}
//	}
//});