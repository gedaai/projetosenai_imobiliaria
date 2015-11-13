angular.module('imobiliaria').controller('loginModalFunc', function ($scope, Corretor, $modalInstance) {
     
   $scope.login = function (corretor) {
    console.log("LOGIN");
    console.log(corretor);
    new Corretor(corretor).create()
          .then(function (data) {
            corretor = data;
            console.log(corretor);
            if(corretor.id){
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