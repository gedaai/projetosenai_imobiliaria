'use strict';

function ImovelController($scope, Imovel,$location,$flow,$flowProvider){
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
    $scope.imageStrings = [];
    $scope.processFiles = function(files){
        angular.forEach(files, function(flowFile, i){
            var fileReader = new FileReader();
            fileReader.onload = function (event) {
                var uri = event.target.result;
                $scope.imageStrings[i] = uri;     
            };
          fileReader.readAsDataURL(flowFile.file);
        });
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
