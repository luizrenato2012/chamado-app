var module = angular.module('ChamadoControllerCadMdl',['UtilServiceMdl']);

module.controller('chamadoControllerCad', ['$scope', 'utilService',function($scope, utilService){
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
	})();
	
	$scope.grava = function() {
		console.log('Gravando chamado');
	}
	
} ]);





 