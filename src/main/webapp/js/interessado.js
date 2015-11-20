'use strict';

function InteressadoController($scope,$rootScope,$location){
    $scope.voltar = function () {
        $location.path("/");
    };
    
}

function InteressadoRoute($stateProvider) {
    $stateProvider.state('interessados', {
        url: '/interessados',
        templateUrl: 'views/interessados.html',
        controller: 'InteressadoController'
    });
}

angular.module('imobiliaria')
        .config(InteressadoRoute)
        .controller('InteressadoController', InteressadoController);


