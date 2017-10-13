var service = angular.module('UtilServiceMdl',[]);

service.factory('utilService', function() {
	
	return {
		// dd/mm/yyyy p-> yyyy-mm-dd
		transformaData : function(data) {
			return data.substring(6) + '-' + data.substring(3,5) + '-' + data.substring(0,2);
		}
	}
});