angular.module('imobiliaria').controller('loginModalFunc', function ($scope, $modalInstance) {

  $scope.login = function (corretor) {
    console.log(corretor);
    $modalInstance.close(corretor);
  };

  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
});