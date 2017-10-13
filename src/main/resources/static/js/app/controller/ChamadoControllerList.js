var app = angular.module('ChamadoControllerListMdl',['ChamadoServiceMdl','angularUtils.directives.dirPagination']);

app.controller('chamadoControllerList', ['$scope','chamadoService', function($scope, chamadoService){
	$scope.chamados = [];
	$scope.listaMensagens=[];
	$scope.flagMensagemErro;
	$scope.flagMensagemSucesso;
	$scope.argumento;
	$scope.idExclusao;
	$scope.sistemas = [{'label':'', 'valor': ''},
						{'label':'GRisco', 'valor': 'grisco'},
					   {'label':'Cadastro', 'valor': 'cadastro'},
					   {'label':'Gescob', 'valor': 'gescob'}];
	$scope.situacoes = [{'label':'', 'valor': ''},
						{'label':'Aberto', 'valor': 'aberto'},
						{'label':'Fechado', 'valor': 'fechado'},
						{'label':'Pendente', 'valor': 'Pendente'}];
	
	
	$scope.lista = function(argumento) {
		
		
		chamadoService.lista(argumento).success(function(data){
			$scope.chamados = data;
		}).error(function(data, status){
			console.log(data);
			//$scope.exibeMensagemErro(data);
		});
	}
	
	$scope.valida= function (argumento) {
		return argumento.sistema || argumento.situacao || argumento.descricao || argumento.dataDe 
			|| argumento.dataAte;
	}
}]);