'use strict';

function ImovelController($scope, Imovel,$location){
    $scope.gravar = function () {
       
        if ($scope.imovel.id) {
            $scope.imovel.update().then(function () {
                $scope.voltar();
            }, function (error) {
                console.log('error', error);
                alert(error.data);
            });
        } else {
            console.log($scope.imovel);
            new Imovel($scope.imovel).create()
                    .then(function () {
                        $scope.voltar();
                    }, function (error) {
                        console.log('error', error);
                        alert(error.data);
                    });
        }
    };
    
    $scope.voltar = function () {
        $location.path("/");
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
