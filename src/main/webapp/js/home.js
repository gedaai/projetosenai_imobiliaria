'use strict';

function HomeController($scope, $rootScope, Imovel, $uibModal, $location) {

    $scope.listar = function () {
        Imovel.query().then(function (data) {
            $scope.imoveis = data;
        }, function (error) {
            console.log('error', error);
            alert(error.data);
        });
    };

    $scope.buscarImagens = function (imovel,size) {
        $rootScope.imovel = imovel;
        imovel.listaImagens().then(function (data) {
            $rootScope.imagens = data;
            console.log($scope.imagens);
            var modalInstance = $uibModal.open({
                animation: $scope.animationsEnabled,
                templateUrl: 'myModalContentImagem.html',
                controller: 'informacaoModalFunc',
                size: size
            });
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

    $scope.editar = function (imovel) {
        $rootScope.imovel = imovel;
        $location.path("/imovel");
    };

    $scope.novo = function () {
        $rootScope.imovel = {};
        $location.path("/imovel");
    };

    $scope.informacao = function (imovel, size) {

        $rootScope.imovel = imovel;
        console.log("Imovel" + imovel)


        var modalInstance = $uibModal.open({
            animation: $scope.animationsEnabled,
            templateUrl: 'myModalContentInfo.html',
            controller: 'informacaoModalFunc',
            size: size
        });
    };

    $scope.interessado = function (imovel) {
        $rootScope.imovel = imovel;
        $rootScope.informacoes = null;
        
        imovel.listaInformacoes().then(function (data) {
            $rootScope.informacoes = data;
            console.log($rootScope.informacoes);
            if ($rootScope.informacoes.length > 0){
                $location.path("/interessados");
            } else {
                alert("Não há interessados por este imóvel!");
            }
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
