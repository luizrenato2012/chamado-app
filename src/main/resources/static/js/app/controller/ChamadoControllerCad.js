var module = angular.module('ChamadoControllerCadMdl',['UtilServiceMdl','ChamadoServiceMdl']);

module.controller('chamadoControllerCad', ['$scope', 'utilService','chamadoService', function($scope, utilService, chamadoService){
	$scope.chamado = {};
	$scope.tiposChamado = [];
	
	(function() {
		utilService.getListaUsuarios().then (
			function(result){
				$scope.solicitantes= result;
			},
			function(error) {
				console.log(error);
			});
		chamadoService.getListaSistemas().then(
			function(result) {
				$scope.sistemas = result;
				$scope.chamado = chamadoService.getChamadoEdicao();
				for(let i = 0 ; i < $scope.sistemas.length; i++ ) {
					let sistema = $scope.sistemas[i];
					if($scope.chamado.sistema.id== sistema.id) {
						$scope.chamado.sistema = sistema;
						break;
					}
				}
				if ($scope.chamado.tipo!=null) {
					configTipo();
				}
			console.log('iniciado chamadcadcointroller');
		}, function(error){
			console.log(error);
		});
		
		
	})();
	
	configTipo= function() {
		utilService.getListaTiposChamado().then(
				function(result){
					$scope.tiposChamado = result;
					for(let i=0; i < $scope.tiposChamado.length; i++) {
						let tipo = $scope.tiposChamado[i];
						if ($scope.chamado.tipo.id == tipo.id){
							console.log('tipo chamado '+ tipo.codigo);
							$scope.chamado.tipo = tipo;
							break;
						}
					}
				}, function(error) {
					console.log(error);
		});
	}
	
	$scope.grava = function() {
		console.log('Gravando chamado');
	}
	
} ]);





 