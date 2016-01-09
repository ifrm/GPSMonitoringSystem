/**
 * Created by Ionatan on 02.01.2016.
 */
(function () {
    'use strict';
    angular
        .module('app')
        .controller('LoginController', LoginController);

    function LoginController($rootScope, $scope, $http, $location, $route,UserService) {

        $scope.tab = function(route) {
            return $route.current && route === $route.current.controller;
        };

        var authenticate = function(credentials, callback) {



            UserService.Login(credentials).then(
                function(data) {
                                if (data.statusText) {
                                    $rootScope.authenticated = true;
                                } else {
                                    $rootScope.authenticated = false;
                                }
                                callback && callback($rootScope.authenticated);
                },function() {
                                  $rootScope.authenticated = false;
                                  callback && callback(false);
                              }
            );


        }


        $scope.credentials = {};
        $scope.login = function() {
            authenticate($scope.credentials, function(authenticated) {
                if (authenticated) {
                    console.log("Login succeeded")
                    $location.path("/admin");
                    $scope.error = false;
                    $rootScope.authenticated = true;
                } else {
                    console.log("Login failed")
                    $location.path("/login");
                    $scope.error = true;
                    $rootScope.authenticated = false;
                }
            })
        };

        $scope.logout = function() {
            $http.post('logout', {}).success(function() {
                $rootScope.authenticated = false;
                $location.path("/");
            }).error(function(data) {
                console.log("Logout failed")
                $rootScope.authenticated = false;
            });
        }

    }


})();