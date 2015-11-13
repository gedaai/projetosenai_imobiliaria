'use strict';

function HomeController($scope, Imovel) {

    $scope.listar = function () { 
        Imovel.query().then(function (data) {
            $scope.imoveis = data;
        }, function (error) {
            console.log('error', error);
            alert(error.data);
        });
    };
    
    $scope.buscarImagens = function (imovel) { 
        $scope.imovel = imovel;
        imovel.listaImagens().then(function (data) {
            $scope.imagens = data;
            console.log($scope.imagens);
        }, function (error) {
            console.log('error', error);
            alert(error.data);
        });
    };
    
    $scope.excluir = function (imovel) {
        imovel.remove().then(function () {
            $scope.listar();
        }, function (error) {
            console.log('error', error);
            alert(error.data);
        });
    };
    
    $scope.listar();
}

function HomeRoute($stateProvider) {
    $stateProvider.state('home', {
        url: '/',
        templateUrl: 'views/home.html',
        controller: 'HomeController'
    });
}

angular.module('imobiliaria')
        .config(HomeRoute)
        .controller('HomeController', HomeController);