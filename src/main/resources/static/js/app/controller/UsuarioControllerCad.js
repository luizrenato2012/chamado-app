var app = angular.module('UsuarioControllerCadMdl',['UsuarioServiceMdl']);

app.controller('usuarioControllerCad', ['$scope','usuarioService', function($scope, usuarioService){
	
	$scope.usuario = {};
	$scope.listaMensagens=[];
	$scope.flagMensagemErro;
	$scope.flagMensagemSucesso;
	$scope.argumento;
	
	$scope.teste = function() {
		console.log('teste controller usuario');
	}
	
	$scope.grava = function() {
		usuarioService.grava($scope.usuario).success(function(data){
			console.log('Usuario gravado com sucesso');
			$scope.usuario.id = data.id;
			$scope.frm_usuario.$setPristine(true);
			$scope.exibeMensagemSucesso('Registro gravado com sucesso!');
		}).error(function(data, status){
			var texto = data[0].mensagem;
			console.log('Erro ao gravar contato ' + texto);
			$scope.frm_usuario.$setPristine(false);
			$scope.exibeMensagemErro(data);
		});
	}
	
	$scope.exibeMensagemSucesso = function(mensagem) {
		$scope.flagMensagemSucesso=true;
		$scope.flagMensagemErro=false;
		$scope.listaMensagens = [ {"mensagem": mensagem}];
	}
	
	$scope.exibeMensagemErro= function(mensagens) {
		$scope.flagMensagemErro=true;
		$scope.flagMensagemSucesso=false;
		$scope.listaMensagens = mensagens;
	}
	
	$scope.cancela = function() {
		$scope.usuario = {};
		$scope.frm_usuario.$setPristine(true);
		$scope.frm_usuario.$setDirty(false);
	}
	
	$scope.exibe = function(item) {
		console.log('Exibindo ' );
	}
	
	//funcao de inicializacao
	$scope.inicia = function () {
		console.log('Iniciando cad usuario ');
		$scope.usuario = usuarioService.getUsuarioEdicao();
	};
	$scope.inicia();
	
	
}]);