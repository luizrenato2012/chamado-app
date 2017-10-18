var service = angular.module('UtilServiceMdl',['UsuarioServiceMdl']);

service.factory('utilService', function(usuarioService, $q, $http) {
	
	_listaSistemas= [];
	_listaSituacoes= [];
	_listaTipoChamados= [];
	
	
	(function () {
		console.log('Iniciando listas UtilService');
		
		$http.get('/api/chamados/listas').success(function(data){
			_listaSistemas = data.sistemas;
			_listaSituacoes = data.situacoes;
			_listaTipoChamados = data.tipos
		}).error(function(data, status){
			console.log(data);
		});
	})();
	
	return {
		// dd/mm/yyyy p-> yyyy-mm-dd
		transformaData : function(data) {
			return data.substring(6) + '-' + data.substring(3,5) + '-' + data.substring(0,2);
		},
		
		getListaSistemas : function() { 
			var deferred = $q.defer();
			deferred.resolve (function() {
				transformaItens(_listaSistemas, 'descricao', 'id')
			})
			return deferred.promise;;
		},
		
		getListaSituacoes : function() {
			return transformaItens(_listaSituacoes,'descricao', 'id');
		},
		
		getListaTiposChamado : function() {
			var deferred = $q.defer();
			deferred.resolve (function() {
				transformaItens(_listaTipoChamados, 'descricao', 'id')
			})
			return deferred.promise;;
		},
		
		getListaUsuarios : function() {
			var defer = $q.defer();
			usuarioService.lista().success(function(data){
				defer.resolve(transforma (data) );
			}).error(function(data, status){
				console.log(data);
				defer.resolve ('Erro ao listar usuarios ');
			});
			return defer.promise;
		}
	}
	
	function transformaItens(lista, label, valor) {
		var listaRes = [];
		var objeto = {};
		for(var i=0, total=lista.length; i < total; i++){
			objeto = lista[i];
			listaRes.push({'label':objeto.label , 'valor': objeto.valor});
		}
		return listaRes;
	}
	
	function transforma(usuarios) {
		var lista = [];
		var usuario = {};
		for(var i=0, total=usuarios.length; i < total; i++){
			usuario = usuarios[i];
			lista.push({'label':usuario.nome , 'valor': usuario.id});
		}
		return lista;
	}
});