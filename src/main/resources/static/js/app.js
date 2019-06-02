angular.module('myApp', []).controller('myController', ['$scope', '$http', '$location', '$window', function($scope, $http, $location, $window) {
    var username = "";
    var password = "";
    $scope.login = function() {
        username = $scope.username;
        password = $scope.password;

        //username = 'eve.holt@reqres.in';
        //password = 'asdc222ka22';
        $http.post('https://reqres.in/api/login', {
            email: username,
            password: password
        }).success(function(response, status) {
            console.log('status:', status);
            if (status == 200) {
                $window.location.href = '/home';
            }
        }).error(function(data, status, headers, config) {
            alert('Failed to login.');
        });
    };
    $scope.newuser = function() {
        $window.location.href = '/newuser';
    };

}]);

angular.module('myApp1', []).controller('userController', ['$scope', '$http', '$location', '$window', function($scope, $http, $location, $window) {

    $scope.register = function() {
        var username = $scope.username;
        var password = $scope.password;

        $http.post('https://reqres.in/api/register', {
            email: username,
            password: password
        }).success(function(response, status) {
            console.log('status:', status);
            if (status == 200) {
                alert('new user registered succefully!');
                //$window.location.href = '/home'; 
            }
        }).error(function(data, status, headers, config) {
            alert('Failed to Register.');
        });
    };
}]);