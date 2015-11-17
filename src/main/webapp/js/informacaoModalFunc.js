angular.module('imobiliaria').controller('informacaoModalFunc', function ($scope, $location, Informacao, $modalInstance) {
     
   $scope.gravarInformacao = function (informacao) {
    console.log("INFORMACAO");
    console.log(informacao);
    
   if ($scope.informacao.id) {
            $scope.informacao.update().then(function () {
                $scope.voltar();
            }, function (error) {
                console.log('error', error);
                alert(error.data);
            });
        } else {
            new Informacao($scope.informacao).create()
                    .then(function () {
                        $scope.voltar();
                    }, function (error) {
                        console.log('error', error);
                        alert(error.data);
                    });
        } 
 
  };

  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
  
  $scope.voltar = function () {
        $location.path("/");
    };
    
    $scope.listarInformacao = function () { 
        Informacao.query().then(function (data) {
            $scope.informacao = data;
        }, function (error) {
            console.log('error', error);
            alert(error.data);
        });
    };
  
});