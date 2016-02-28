var mainApp = angular.module('mainApp', []);

mainApp.controller('MainCtrl', function ($scope, $http) {
    $http({
        url: '/api/time'
    }).then(function (data) {
        $scope.value = data["data"]
    })
});