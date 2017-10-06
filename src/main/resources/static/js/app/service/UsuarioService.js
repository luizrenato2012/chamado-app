var service = angular.module('UsuarioServiceMdl',[]);

service.factory("usuarioService", function($http){
	var usuarioEdicao = {};
	
	var _setUsuarioEdicao = function (usuario) {
		console.log('set usuario ' + usuario);
		usuarioEdicao = usuario;
	}
	
	var _getUsuarioEdicao = function() {
		console.log('get usuario ' + usuarioEdicao);
		return usuarioEdicao;
	}
	
	var _grava = function(usuario) {
		if (usuario.id) {
			return $http.put("/api/usuarios/", usuario);
		} else {
			return $http.post("/api/usuarios/", usuario);
		}
	}
	
	var _lista = function(argumento){
		if(argumento) {
			return $http.get('/api/usuarios/nome/'+argumento);
		} else {
			return $http.get('/api/usuarios/');
		}
	}
	
	var _deleta = function(id) {
		return $http.delete('/api/usuarios/'+id);
	}
	
	return {
		grava: _grava,
		lista: _lista,
		deleta: _deleta,
		setUsuarioEdicao: _setUsuarioEdicao,
		getUsuarioEdicao: _getUsuarioEdicao,
		
	};
});