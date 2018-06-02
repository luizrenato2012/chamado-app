var module = angular.module('ChamadoControllerCadMdl',['UtilServiceMdl','ChamadoServiceMdl']);

module.controller('chamadoControllerCad', ['$scope', 'utilService','chamadoService', function($scope, utilService, chamadoService){
	$scope.chamado = {};
	$scope.tiposChamado = [];
	$scope.situacoes = [];
	
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
					configuraTipo();
				}
				if ($scope.chamado.situacao!=null) {
					configuraSituacao();
				}
			console.log('iniciado chamadcadcointroller');
		}, function(error){
			console.log(error);
		});
		
		
	})();
	
	configuraTipo= function() {
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
	
	configuraSituacao = function() {
		utilService.getListaSituacoes().then(
				function(result) {
					$scope.situacoes = result;
					for(let i=0; i < $scope.situacoes.length; i++){
						let situacao = $scope.situacoes[i];
						if( $scope.chamado.situacao.id == situacao.id ) {
							$scope.chamado.situacao = situacao;
							break;
						}
					}
				}, function(error){
					console.log(error);
				}
		);
	}
	
	$scope.grava = function() {
		console.log('Gravando chamado');
	}
	
} ]);





 