(function () {
    'use strict';

    angular
        .module('app')
        .factory('UserService', UserService);

    UserService.$inject = ['$http'];
    function UserService($http) {
        var service = {};

        service.GetAll = GetAll;
        service.Login=Login;

        return service;

        function GetAll() {
            return $http.get('rest/users').then(handleSuccess, handleError('Error getting all users'));
        }

        function Login(credentials){
            return $http.put("rest/users/login",credentials).then(handleSuccess,handleError);
        };

        // private functions

        function handleSuccess(res) {
            return res.data;
        }

        function handleError(error) {
            return function () {
                return { success: false, message: error };
            };
        }
    }

})();
