angular.module('imobiliaria').controller('loginModalFunc', function ($scope, $rootScope, Corretor, $modalInstance) {
     
   $scope.login = function (corretor) {
    new Corretor(corretor).create()
          .then(function (data) {
            $rootScope.corretor = data;
            if($rootScope.corretor.id){
                $scope.erro = null;
                $modalInstance.close(corretor);      
            }else{
                $scope.erro = "erro";
            }
        }, function (error) {
            console.log('error', error);
            alert(error.data);
    });
 
  };

  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
});