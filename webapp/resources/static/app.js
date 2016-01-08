/**
 * Created by Ionatan on 30.12.2015.
 */
'use strict';
var ana=[];
var myApp = angular.module('app', ['ngRoute', 'ngCookies','uiGmapgoogle-maps']);
myApp.config(['$routeProvider','$httpProvider',function ($routeProvider,$httpProvider) {
    $routeProvider
        .when('/', {
            controller: 'HomeController',
            templateUrl: 'static/home/home.view.html',
            controllerAs: 'vm'
        })
        .when('/admin', {
            controller: 'AdminController',
            templateUrl: 'static/admin/admin.view.html',
            controllerAs: 'vm'
        })
        .when('/login', {
            controller: 'LoginController',
            templateUrl: 'static/login/login.view.html',
            controllerAs: 'vm'
        })
        .when('/editUsers', {
            controller: 'UserController',
            templateUrl: 'static/user/user.view.html',
            controllerAs: 'ctrl'
        })
        .otherwise({ redirectTo: '/' });
    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
}]);

