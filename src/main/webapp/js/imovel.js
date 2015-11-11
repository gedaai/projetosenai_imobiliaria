'use strict';

function ImovelController($scope, Imovel,$location){
    $scope.gravar = function () {
       
        if ($scope.imovel.id) {
            $scope.imovel.update().then(function () {

            }, function (error) {
                console.log('error', error);
                alert(error.data);
            });
        } else {
            new Imovel($scope.imovel).create()
                    .then(function () {
                        
                    }, function (error) {
                        console.log('error', error);
                        alert(error.data);
                    });
        }
    };
}

function ImovelRoute($stateProvider) {
    $stateProvider.state('imovel', {
        url: '/imovel',
        templateUrl: 'views/imovel.html',
        controller: 'ImovelController'
    });
}

angular.module('imobiliaria')
        .config(ImovelRoute)
        .controller('ImovelController', ImovelController);
