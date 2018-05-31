var modulo = angular.module('TesteControllerMdl',['UtilServiceMdl']);

modulo.controller('testeController',['$scope','utilService','chamadoService', function($scope, utilService, chamadoService){
	$scope.chamado = {};
	$scope.sistemas = [];
	$scope.sistema = {};
	
	chamadoService.getListaSistemas().then(function(result) {
		$scope.sistemas = result;
		$scope.chamado = chamadoService.getChamadoEdicao();
//		$scope.sistema = $scope.chamado.sistema;
		for(let i = 0 ; i < _listaSistemas.length; i++) {
			let sistemaAtual = _listaSistemas[i];
			if ($scope.chamado.sistema.id== sistemaAtual.id) {
				console.log('sistema encontrado '+ sistemaAtual);
				$scope.chamado.sistema = sistemaAtual;
				$scope.sistema = sistemaAtual;
				break;
			}
		}
		console.log('iniciado chamadcadcointroller');
	}, function(error){
		console.log(error);
	});
	
	(function() {
		console.log('Iniciando TesteController');
		//$scope.sistemas = chamadoService.getSistemas();
//		$scope.chamado = chamadoService.getChamadoEdicao();
////		$scope.sistema = $scope.chamado.sistema;
//		for(let i = 0 ; i < _listaSistemas.length; i++) {
//			let sistemaAtual = _listaSistemas[i];
//			if ($scope.chamado.sistema.id== sistemaAtual.id) {
//				console.log('sistema encontrado '+ sistemaAtual);
//				$scope.chamado.sistema = sistemaAtual;
//				$scope.sistema = sistemaAtual;
//				break;
//			}
//		}
//		console.log('iniciado chamadcadcointroller');
	})();
	
		
	
}]);