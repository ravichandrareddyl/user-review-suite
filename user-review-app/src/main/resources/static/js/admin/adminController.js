'use strict';
angular.module('userReview')
    .controller('adminController', ['adminService', '$q', '$state', function (adminService, $q, $state) {
        var vm = this;
        vm.title = 'Admin';
        
        function activate() {
            // loading dropdowns
        }
        activate();
    }]);