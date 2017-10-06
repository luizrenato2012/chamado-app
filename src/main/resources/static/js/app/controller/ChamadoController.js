var app = angular.module('ChamadoControllerMdl',[]);

app.controller('chamadoController', ['$scope', function($scope){
	
	$scope.teste = function() {
		console.log('Teste');
	}
}]);