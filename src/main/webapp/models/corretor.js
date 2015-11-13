'use strict';

angular.module('imobiliaria')
    .factory('Corretor',
    function(railsResourceFactory, API_URL) {
        var Corretor = railsResourceFactory({
            url: API_URL + 'corretores'
    });
    Corretor.prototype.login = function() {
           console.log("LOGIN");
           return Corretor.$post(this.$url() + "/login");  
    };
    return Corretor;
});    