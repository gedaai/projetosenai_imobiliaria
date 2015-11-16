'use strict';

angular.module('imobiliaria')
    .factory('Informacao', 
        function(railsResourceFactory, API_URL) {
        var Imovel = railsResourceFactory({
            url: API_URL + 'informacoes'
        });
        
        return Imovel;
    });

