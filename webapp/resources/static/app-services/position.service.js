(function () {
    'use strict';

    angular
        .module('app')
        .factory('PositionService', PositionService);

    PositionService.$inject = ['$http'];
    function PositionService($http) {
        var service = {};

        service.GetUserPositions = GetUserPositions;


        return service;

        function GetUserPositions(userId,startDateInMiliseconds,endDateInMiliseconds) {
            return $http.get('rest/positions/?userId='+userId+'&startDate='+startDateInMiliseconds+'&endDate='+endDateInMiliseconds).then(handleSuccess, handleError('Error getting positions'));
        }



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
