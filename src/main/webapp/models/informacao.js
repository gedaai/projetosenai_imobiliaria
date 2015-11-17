'use strict';

angular.module('imobiliaria')
    .factory('Informacao', 
        function(railsResourceFactory, API_URL) {
        var Informacao = railsResourceFactory({
            url: API_URL + 'informacoes'
        });
        
        return Informacao;
    });

