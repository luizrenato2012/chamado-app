var service = angular.module('ChamadoServiceMdl',['UtilServiceMdl']);

service.factory('chamadoService', function($http, utilService){
	//http://localhost:1234/api/chamados?descricao=proposta&sistema=cadastro
	return {
		lista : function(argumento){
			var parametros =  { dataDe : argumento.dataDe,
								dataAte : argumento.dataAte,
								situacao :  argumento.situacao,
								sistema: argumento.sistema,
								descricao : argumento.descricao};
			if (parametros.dataDe!= null && parametros.dataDe!= undefined && parametros.dataDe.length==10) {
				parametros.dataDe =  utilService.transformaData(parametros.dataDe);
			}
			
			if ( parametros.dataAte!=null && parametros.dataAte!= undefined && parametros.dataAte.length==10) {
				parametros.dataAte = utilService.transformaData(parametros.dataAte);
			}
			return $http.get('/api/chamados?'+ retornaUrl(parametros));
		}
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
		return queryStr;
	}
	
});