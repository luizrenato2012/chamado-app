var service = angular.module('ChamadoServiceMdl',['UtilServiceMdl']);

service.factory('chamadoService', function($http, utilService, $q){
	//http://localhost:1234/api/chamados?descricao=proposta&sistema=cadastro
	_chamadoEdicao = {};
	_listaSistemas = [];
	
	var _lista = function(argumento){
		
		
		var parametros =  { dataDe : argumento.dataDe,
							dataAte : argumento.dataAte,
							situacao :  argumento.situacao,
							sistema: argumento.sistema,
							descricao : argumento.descricao,
							numero : argumento.numero};
		
		if (parametros.dataDe!= null && parametros.dataDe!= undefined && parametros.dataDe.length==10) {
			parametros.dataDe =  utilService.transformaData(parametros.dataDe);
		}
		
		if ( parametros.dataAte!=null && parametros.dataAte!= undefined && parametros.dataAte.length==10) {
			parametros.dataAte = utilService.transformaData(parametros.dataAte);
		}
		return $http.get('/api/chamados?'+ retornaUrl(parametros));
	}
	
	var _setChamadoEdicao = function(chamado) {
		_chamadoEdicao = chamado;
	}
	
	var _getChamadoEdicao = function() {
		return _chamadoEdicao;
	}
	
	var _getListaSistemas = function() { 
		var deferred = $q.defer();
		$http.get('/api/chamados/sistemas').success(
				function(data){
					_listaSistemas = data;
					deferred.resolve (_listaSistemas);
				}).error(
				function(data,status){
					console.error(data);
				});
		return deferred.promise;
	}
	
	return {
		lista: _lista,
		setChamadoEdicao: _setChamadoEdicao,
		getChamadoEdicao: _getChamadoEdicao,
		getListaSistemas: _getListaSistemas
	}
	
	function retornaUrl (argumento) {
		var queryStr = '';
		if (argumento.situacao){
			queryStr="situacao="+ argumento.situacao;
		}
		if (argumento.sistema){
			queryStr+= (queryStr.length!= 0 ? "&" : "") + "sistema="+argumento.sistema;
			
		}
		if (argumento.descricao){
			queryStr+= (queryStr.length!= 0 ? "&": "") + "descricao="+argumento.descricao;
		}
		if (argumento.dataDe){
			queryStr+= (queryStr.length!= 0 ? "&" : "") +   "dataDe="+ argumento.dataDe+ "&dataAte="+ argumento.dataAte;
		}
		
		if (argumento.numero){
			queryStr+= (queryStr.length!= 0 ? "&" : "") +   "numero="+ argumento.numero;
		}
		return queryStr;
	}
	
});