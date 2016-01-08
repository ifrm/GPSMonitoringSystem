/**
 * Created by Ionatan on 03.01.2016.
 */
(function () {
    'use strict';
    angular
        .module('app')
        .controller('UserController', UserController);

    UserController.$inject = ['UserService','$scope'];
    function UserController (UserService,$scope){

        var self = this;
        self.user={id:null,username:'',address:'',email:''};
        self.users=[];

        self.fetchAllUsers = function(){
            UserService.GetAll()
                .then(
                function(d) {
                    self.users = d;
                }
            );
        }
        self.fetchAllUsers();
    }

})();