var app = angular.module('chamadoApp',['ngRoute','UsuarioControllerCadMdl','UsuarioControllerListMdl','ChamadoControllerListMdl','TesteControllerMdl',
										'ChamadoControllerCadMdl']);

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
})
.directive('datePicker', function() {
    return {
        restrict: 'A',
        require: 'ngModel',
        link: function(scope, element, attrs, ctrl) {
            $(element).datepicker({
            	 dateFormat: 'dd/mm/yy',
                 dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'],
                 dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
                 dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
                 monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
                 monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
                 onSelect: function(date) {
                    ctrl.$setViewValue(date);
                    ctrl.$render();
                    scope.$apply();
                }
            });
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
		.when('/chamados/insert', {
			templateUrl: '/chamado_cad.html',
			controller: 'chamadoControllerCad'
		})
		.when('/chamados/update', {
			templateUrl: '/chamado_cad.html',
			controller: 'chamadoControllerCad'
		})
		.when('/teste', {
			templateUrl: '/teste_select.html',
			controller: 'testeController'
		})
		.when('', {
			templateUrl: 'view/index.html',
			controller: 'appController'
		}).otherwise ({redirectTo: '/'}) ;
}]);