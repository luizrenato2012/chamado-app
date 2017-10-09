var app = angular.module('chamadoApp',['ngRoute','UsuarioControllerCadMdl','UsuarioControllerListMdl','ChamadoControllerListMdl','TesteControllerMdl']);

app.controller('appController', ['$scope', '$route', function($scope, $route){
	$scope.rota = $route;
}]);

app.directive('alertaMensagem', function(){
	return {
		restrict: "E",
		templateUrl: '../diretiva.html',
		scope : {
			//mapeamento variavel escopo p/ atributo tag
			mensagens : "=itens",
			tipoMensagemErro: "=tipoErro",
			tipoMensagemSucesso: "=tipoSucesso"
		}
	}
});

app.config(['$routeProvider','$locationProvider',function($routeProvider,$locationProvider){
//	$locationProvider.hashPrefix('!'); desabilitado p/ html5 mode
	$locationProvider.html5Mode({
		  enabled: true,
		  requireBase: false
		});
	$routeProvider
		.when('/usuarios/list', {
			templateUrl: '/usuario_list.html',
			controller: 'usuarioControllerList'
		})
		.when('/usuarios/insert', {
			templateUrl: '/usuario_cad.html',
			controller: 'usuarioControllerCad'
		})
		.when('/usuarios/update', {
			templateUrl: '/usuario_cad.html',
			controller: 'usuarioControllerCad'
		})
		.when('/chamados/list', {
			templateUrl: '/chamado_list.html',
			controller: 'chamadoControllerList'
		})
		.when('/testes/', {
			templateUrl: '/teste.html',
			controller: 'testeController'
		})
		.when('', {
			templateUrl: 'view/index.html',
			controller: 'appController'
		}).otherwise ({redirectTo: '/'}) ;
}]);