var mainApp = angular.module('mainApp', []);

mainApp.controller('MainCtrl', function ($scope, $http) {
    // List of values
    $scope.todos = ["foo", "bar"];

    $http({
        url: '/api/time'
    }).then(function (data) {
        $scope.value = data["data"]
    });

    $scope.submit = function () {
        $scope.todos.push($scope.text);
        $scope.text = '';
    }

    $scope.remove = function (index) {
        $scope.todos.splice(index, 1);
    }

    $scope.edit = function (index, value) {
        console.log("Edit: " + index);
        $scope.todos[index] = value;
    };
});