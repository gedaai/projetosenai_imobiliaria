'use strict';

function ImovelController($scope, Imovel,$location){
    
    $scope.gravar = function () {
        
       $scope.imovel.tipo = $scope.tipos.codigo.codigo;
       $scope.imovel.uf = $scope.estados.nome.nome;
       
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
    
    $scope.tipos = [
        {nome: "Casa", codigo:1},
        {nome: "Apartamento", codigo:2},
        {nome: "Sala comercial", codigo:3}
    ];
    
    $scope.estados = [
        {nome: "SC"},
        {nome: "PR"},
        {nome: "RS"},
        {nome: "SP"},
        {nome: "RJ"}
    ];
    
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
