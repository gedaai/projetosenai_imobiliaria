'use strict';

angular.module('imobiliaria')
    .factory('Imovel', 
        function(railsResourceFactory, API_URL) {
        var Imovel = railsResourceFactory({
            url: API_URL + 'imoveis'
        });

        return Imovel;
    });

