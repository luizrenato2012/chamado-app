var service = angular.module('ChamadoServiceMdl',[]);

service.factory('chamadoService', function($http){
	//http://localhost:1234/api/chamados?descricao=proposta&sistema=cadastro
	return {
		lista : function(argumento){
				return $http.get('/api/chamados?'+ retornaUrl(argumento));
		}
	}
	
	function retornaUrl (argumento) {
		var queryStr = '';
		if (argumento.situacao){
			queryStr="situacao="+ argumento.situacao;
		}
		if (argumento.sitema){
			queryStr= (queryStr ? " and sistema=" : "sistema=") + argumento.sistema;
			
		}
		if (argumento.descricao){
			queryStr= (queryStr ? " and descricao=": "descricao=") + argumento.descricao;
		}
		if (argumento.dataDe){
			queryStr="dataDe="+ argumento.dataDe + "&dataAte="+ argumento.dataAte;
		}
		return queryStr;
	}
	
});