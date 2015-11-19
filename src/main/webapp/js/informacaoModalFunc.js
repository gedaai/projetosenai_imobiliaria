angular.module('imobiliaria').controller('informacaoModalFunc', function ($scope, $rootScope, $location, Informacao, $modalInstance) {

    $scope.informacao = {};

    $scope.gravarInformacao = function (informacao) {

        $scope.informacao.imovel = $rootScope.imovel;

        if ($scope.informacao.id) {
            $scope.informacao.update().then(function () {
                $modalInstance.close(informacao);
            }, function (error) {
                console.log('error', error);
                alert(error.data);
            });
        } else {
            new Informacao($scope.informacao).create()
                    .then(function () {
                        $modalInstance.close(informacao);
                    }, function (error) {
                        console.log('error', error);
                        alert(error.data);
                    });
        }

    };
    
    $scope.listar = function () { 
        Informacao.query().then(function (data) {
            $scope.informacoes = data;
        }, function (error) {
            console.log('error', error);
            alert(error.data);
        });
    };

    $scope.buscarInformacoes = function (informacao) {
        $rootScope.informacao = informacao;
        informacao.listaInformacoes.then(function (data) {
            $rootScope.informacoes = data;
            console.log($scope.informacoes);
        }, function (error) {
            console.log('error', error);
            alert(error.data);
        });
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
    
    $scope.listar();

});
