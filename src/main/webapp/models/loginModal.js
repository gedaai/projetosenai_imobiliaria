angular.module('imobiliaria').controller('loginModal', function ($scope, $uibModal) {

  $scope.animationsEnabled = true;

  $scope.open = function (size) {

    var modalInstance = $uibModal.open({
      animation: $scope.animationsEnabled,
      templateUrl: 'myModalContent.html',
      controller: 'loginModalFunc',
      size: size,
      resolve: {
        items: function () {
          //return $scope.items;
        }
      }
    });

  };

  $scope.toggleAnimation = function () {
    $scope.animationsEnabled = !$scope.animationsEnabled;
  };

});
