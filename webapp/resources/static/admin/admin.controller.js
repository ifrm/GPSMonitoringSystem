(function () {
    'use strict';
    angular
        .module('app')
        .controller('AdminController', AdminController);

    AdminController.$inject = ['UserService', 'PositionService', '$rootScope'];
    function AdminController(UserService, PositionService, $rootScope) {
        var vm = this;
        vm.allUsers = [];
        vm.userPositions = [];
        vm.getUserPositions = getUserPositions;
        vm.map = {center: {latitude: 46, longitude: 23}, zoom: 6};
        vm.Markers = [];


        initController();


        function loadAllUsers() {
            UserService.GetAll()
                .then(function (users) {
                    vm.allUsers = users;
                });
        }

        function initDates() {
            vm.endDate = new Date().toISOString().substring(0, 16);
            var firstDayOfMonth = new Date();
            firstDayOfMonth.setDate(1);
            firstDayOfMonth.setHours(0);
            firstDayOfMonth.setMinutes(0);
            vm.startDate = firstDayOfMonth.toISOString().substring(0, 16);
        }

        function getUserPositions() {

            PositionService.GetUserPositions(vm.selectedUser.id, Date.parse(vm.startDate), Date.parse(vm.endDate))
                .then(function (userPositions) {
                    vm.userPositions = userPositions
                    updateMarkers(userPositions);
                });
        }

        function updateMarkers(userPositions){
            vm.Markers=userPositions;

            vm.Markers.forEach(function(entry,pos){
                entry.id=pos;
            });
        }

        function initController() {
            loadAllUsers();
            initDates();
        }

    }

    //HomeController.$inject = ['UserService', '$rootScope'];
    //function HomeController(UserService, $rootScope) {
    //    var vm = this;
    //
    //    vm.user = null;
    //    vm.allUsers = [];
    //    vm.deleteUser = deleteUser;
    //
    //    initController();
    //
    //    function initController() {
    //        loadCurrentUser();
    //        loadAllUsers();
    //    }
    //
    //    function loadCurrentUser() {
    //        UserService.GetByUsername($rootScope.globals.currentUser.username)
    //            .then(function (user) {
    //                vm.user = user;
    //            });
    //    }
    //
    //    function loadAllUsers() {
    //        UserService.GetAll()
    //            .then(function (users) {
    //                vm.allUsers = users;
    //            });
    //    }
    //
    //    function deleteUser(id) {
    //        UserService.Delete(id)
    //            .then(function () {
    //                loadAllUsers();
    //            });
    //    }
    //}

})
();