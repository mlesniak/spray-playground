var mainApp = angular.module('mainApp', []);

mainApp.controller('MainCtrl', function ($scope) {
    $scope.value = 1 + 2 == 3;
});