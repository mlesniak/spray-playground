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

window.addEventListener("DOMContentLoaded", function () {
    // Grab elements, create settings, etc.
    var canvas = document.getElementById("canvas"),
        context = canvas.getContext("2d"),
        video = document.getElementById("video"),
        videoObj = {"video": true},
        errBack = function (error) {
            console.log("Video capture error: ", error.code);
        };

    // Put video listeners into place
    if (navigator.webkitGetUserMedia) { // WebKit-prefixed
        navigator.webkitGetUserMedia(videoObj, function (stream) {
            video.src = window.URL.createObjectURL(stream);
            video.play();
        }, errBack);
    }

    document.getElementById("snap").addEventListener("click", function () {
        context.drawImage(video, 0, 0, 640, 480);
    });

    // Converts canvas to an image.
    // Temporary.
    window.convertCanvasToImage = function (canvas) {
        var image = new Image();
        image.src = canvas.toDataURL("image/png");
        return image;
    }
}, false);
