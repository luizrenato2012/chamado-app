var module = angular.module('ChamadoControllerCadMdl',['UtilServiceMdl','ChamadoServiceMdl']);

module.controller('chamadoControllerCad', ['$scope', 'utilService','chamadoService', function($scope, utilService, chamadoService){
	$scope.chamado = {};
	$scope.tiposChamado = [];
	$scope.situacoes = [];
	$scope.tipoTela='';
	
	$scope.listaMensagens=[];
	$scope.flagMensagemErro;
	$scope.flagMensagemSucesso;
	
	(function() {
		$scope.chamado = chamadoService.getChamadoEdicao();
		utilService.getListaUsuarios().then (
			function(result){
				$scope.solicitantes= result;
			},
			function(error) {
				console.error(error);
			});
		chamadoService.getListaSistemas().then(
			function(result) {
				$scope.sistemas = result;
				if($scope.chamado!=null && $scope.chamado.sistema!= undefined && $scope.chamado.sistema!= null) {
					configuraSistemaSelecionado();
				}
				preencheListaTipo();
				preencheListaSituacao();
				$scope.tipoTela = ($scope.chamado==null || $scope.chamado.id==undefined || $scope.chamado.id==null) ? 'Inclui' : 'Altera';
		}, function(error){
			console.error(error);
		});
		
	})();
	
	function configuraSistemaSelecionado() {
		for(let i = 0 ; i < $scope.sistemas.length; i++ ) {
			let sistema = $scope.sistemas[i];
			if($scope.chamado.sistema.id== sistema.id) {
				$scope.chamado.sistema = sistema;
				break;
			}
		}
	}
	
	preencheListaTipo= function() {
		utilService.getListaTiposChamado().then(
				function(result){
					$scope.tiposChamado = result;
					if ($scope.chamado!=null && $scope.chamado.tipo!= undefined && $scope.chamado.tipo!=null) {
						configuraTipoSelecionado();
					}
				}, function(error) {
					console.error(error);
				});
	}
	
	configuraTipoSelecionado = function () {
		for(let i=0; i < $scope.tiposChamado.length; i++) {
			let tipo = $scope.tiposChamado[i];
			if ($scope.chamado.tipo.id == tipo.id){
				$scope.chamado.tipo = tipo;
				break;
			}
		}
	}
	
	preencheListaSituacao = function() {
		utilService.getListaSituacoes().then(
				function(result) {
					$scope.situacoes = result;
					if($scope.chamado!=null && $scope.chamado.situacao!=undefined && $scope.chamado.situacao!=null) {
						configuraSituacaoSelecionada();
					}
				}, function(error){
					console.error(error);
				}
		);
	}
	
	configuraSituacaoSelecionada = function() {
		for(let i=0; i < $scope.situacoes.length; i++){
			let situacao = $scope.situacoes[i];
			if( $scope.chamado.situacao.id == situacao.id ) {
				$scope.chamado.situacao = situacao;
				break;
			}
		}
	}
	
	$scope.grava = function() {
		console.log('Gravando chamado');
		chamadoService.gravaChamado($scope.chamado).success(
			function (result) {
				$scope.chamado.id = result;
				console.log(`Chamado ${chamado.id} gravado com sucesso`);
				$scope.exibeMensagemSucesso('Chamado gravado com sucesso!');
			}).error (
				function (data, status) {	
				console.error(data);
				$scope.exibeMensagemErro('Erro ao gravar ');
			});	
	}
	
	$scope.exibeMensagemErro= function(mensagem) {
		$scope.flagMensagemErro=true;
		$scope.flagMensagemSucesso=false;
		$scope.listaMensagensChamado = [{"mensagem" : mensagem}];
	}
	
	$scope.exibeMensagemSucesso = function(mensagem) {
		$scope.flagExibeMensagem = true;
		$scope.flagMensagemSucesso=true;
		$scope.flagMensagemErro=false;
		$scope.listaMensagensChamado = [ {"mensagem": mensagem}];
	}
	
} ]);





 