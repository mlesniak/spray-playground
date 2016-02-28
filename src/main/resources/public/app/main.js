var mainApp = angular.module('mainApp', []);

// http://www.angulartutorial.net/2014/04/angular-js-auto-focus-for-input-box.html
mainApp.directive('focus',
    function ($timeout) {
        return {
            scope: {
                trigger: '@focus'
            },
            link: function (scope, element) {
                scope.$watch('trigger', function (value) {
                    if (value === "true") {
                        $timeout(function () {
                            element[0].focus();
                        });
                    }
                });
            }
        };
    });


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
    };

    $scope.remove = function (index) {
        $scope.todos.splice(index, 1);
    };

    $scope.edit = function (index, value) {
        console.log("Edit: " + index);
        $scope.todos[index] = value;
        $scope.entry = true;
    };

    $scope.entry = true;
});