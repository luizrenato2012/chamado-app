var module = angular.module('ChamadoControllerCadMdl',['UtilServiceMdl','ChamadoServiceMdl']);

module.controller('chamadoControllerCad', ['$scope', 'utilService','chamadoService', function($scope, utilService, chamadoService){
	$scope.chamado = {};
	
	utilService.getListaSistemas().then(function(result) {
		$scope.sistemas = result;
	}, function(error){
		console.log(error);
	});
	''
	$scope.tiposChamado = utilService.getListaTiposChamado().then(function(result){
		$scope.tiposChamado = result;
	}, function(error) {
		console.log(error);
	});
	
	
	(function() {
		console.log('iniciando chamadcadcointroller');
		utilService.getListaUsuarios().then (
			function(data){
				$scope.solicitantes= data;
			},
			function(error) {
				console.log(error);
			});
		$scope.chamado = chamadoService.getChamadoEdicao();
	})();
	
	$scope.grava = function() {
		console.log('Gravando chamado');
	}
	
} ]);





 