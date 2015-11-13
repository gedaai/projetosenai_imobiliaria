angular.module('imobiliaria').controller('loginModalFunc', function ($scope, Corretor, $modalInstance) {
   
   $scope.corretorLogado = {nome: "TESTE"}  
   $scope.login = function (corretor) {
    console.log("LOGIN");
    console.log(corretor);
    new Corretor(corretor).create()
          .then(function (data) {
            console.log(data);
            $scope.corretorLogado = data;
            console.log($scope.corretorLogado);
        }, function (error) {
            console.log('error', error);
            alert(error.data);
    });
    
    $modalInstance.close(corretor);
  };

  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
});