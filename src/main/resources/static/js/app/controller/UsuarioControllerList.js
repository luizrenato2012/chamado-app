var app = angular.module('UsuarioControllerListMdl',['UsuarioServiceMdl','angularUtils.directives.dirPagination']);

app.controller('usuarioControllerList', ['$scope','usuarioService', function($scope, usuarioService){
	
	$scope.usuarios = [];
	$scope.listaMensagens=[];
	$scope.flagMensagemErro;
	$scope.flagMensagemSucesso;
	$scope.argumento;
	$scope.idExclusao;
	
	$scope.teste = function() {
		console.log('teste controller usuario');
	}
	

	$scope.lista = function(argumento) {
		usuarioService.lista(argumento).success(function(data){
			$scope.usuarios = data;
		}).error(function(data, status){
			console.log(data);
			//$scope.exibeMensagemErro(data);
		});
	}
	
	$scope.seleciona = function(usuario) {
		console.log('Selecionado ' + usuario);
		usuarioService.setUsuarioEdicao(usuario);
	}
	
	$scope.exibeTelaExclusao = function(id) {
		$('#delete-modal').modal({
			keyboard: false
		});
		$scope.idExclusao = id;
	}
	
	$scope.deleta = function() {
		usuarioService.deleta($scope.idExclusao).success(function(data){
			$scope.idExclusao=0;
			$scope.lista($scope.argumento);
		}).error(function(data, status){
			console.log('Erro ' + data);
		});
	}
	
}]);