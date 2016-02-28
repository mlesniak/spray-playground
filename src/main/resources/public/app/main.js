var mainApp = angular.module('mainApp', []);

mainApp.controller('MainCtrl', function ($scope, $http) {
    // List of values
    $scope.todos = [];

    $http({
        url: '/api/time'
    }).then(function (data) {
        $scope.value = data["data"]
    });

    $scope.submit = function () {
        console.log("Clicked: " + $scope.text);
        $scope.todos.push($scope.text);
        $scope.text = '';
    }

    $scope.remove = function (index) {
        $scope.todos.splice(index, 1);
    }
});