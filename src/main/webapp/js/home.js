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