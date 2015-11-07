'use strict';

angular.module('imobiliaria')
    .factory('Imovel', 
        function(railsResourceFactory, API_URL) {
        var Imovel = railsResourceFactory({
            url: API_URL + 'imoveis'
        });
        
        Imovel.prototype.listaImagens = function() {
           return Imovel.$get(this.$url() + "/imagens");  
        };
        
        Imovel.prototype.urlImagem = function(imagemId) {
            return this.$url() + "/imagens/" + imagemId;
        };

        return Imovel;
    });

