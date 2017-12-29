var service = angular.module('UtilServiceMdl',['UsuarioServiceMdl']);

service.factory('utilService', function(usuarioService, $q, $http) {
	
	_listaSistemas= [];
	_listaSituacoes= [];
	_listaTipoChamados= [];
	
	return {
		// dd/mm/yyyy p-> yyyy-mm-dd
		transformaObjetoValorData : function(data) {
			return data.substring(6) + '-' + data.substring(3,5) + '-' + data.substring(0,2);
		},
		
		getListaSistemas : function() { 
			var deferred = $q.defer();
			if (_listaSistemas==undefined || _listaSistemas.length==0) {
				$http.get('/api/chamados/sistemas').success(
						function(data){
							_listaSistemas = transformaObjetoValorItens(data, 'descricao', 'id');
							deferred.resolve (_listaSistemas);
						}).error(
						function(data,status){
							console.log(data);
						});
			} else {
					deferred.resolve (_listaSistemas);
			}
			return deferred.promise;
		},
		
		getListaSituacoes : function() {
			var deferred = $q.defer();
			if(_listaSituacoes==undefined || _listaSituacoes.length==0){
				$http.get('/api/chamados/situacoes').success(
						function(data){
							_listaSituacoes = transformaObjetoValorItens(data, 'descricao','id');
							deferred.resolve(_listaSituacoes);
						}
						).error(function(data,status) {
							console.log(data);
						});
			} else {
				deferred.resolve (_listaSituacoes);
			}
			return deferred.promise;
		},
		
		getListaTiposChamado : function() {
			var deferred = $q.defer();
			if (_listaTipoChamados==undefined || _listaTipoChamados.length==0) {
				$http.get('/api/chamados/tiposChamado').success(
						function(data){
							_listaTipoChamados = transformaObjetoValorItens(data, 'descricao','id');
							deferred.resolve(_listaTipoChamados);
						}).error(function(data,status){
							console.log(data);
						});
			} else {
				deferred.resolve (_listaTipoChamados);
			}
			return deferred.promise;
		},
		
		getListaUsuarios : function() {
			var defer = $q.defer();
			usuarioService.lista().success(function(data){
				defer.resolve(transformaObjetoValor (data) );
			}).error(function(data, status){
				console.log(data);
				defer.resolve ('Erro ao listar usuarios ');
			});
			return defer.promise;
		}
	}
	
	function transformaObjetoValorItens(lista, label, valor) {
		var listaRes = [];
		var objeto = {};
		for(var i=0, total=lista.length; i < total; i++){
			objeto = lista[i];
			listaRes.push({'label':objeto.descricao , 'valor': objeto.id});
		}
		return listaRes;
	}
	
	function transformaObjetoValor(objetosValor) {
		var lista = [];
		var objetoValor = {};
		for(var i=0, total=objetosValor.length; i < total; i++){
			objetoValor= objetosValor[i];
			lista.push({'label':objetoValor.nome , 'valor': objetoValor.id});
		}
		return lista;
	}
});