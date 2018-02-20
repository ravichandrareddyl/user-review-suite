'use strict';
// app.js
// create our angular app and inject ngAnimate and ui-router 
// =============================================================================
angular.module('userReview', ['ngAnimate', 'ui.router', 'ui.materialize', 'auth', 'dashboard'])
// configuring our routes 
// =============================================================================
.config(function($stateProvider, $urlRouterProvider, $httpProvider) {

    $stateProvider
        // route to show our basic form (/form)
        .state('dashboard', {
            url: '/dashboard',
            templateUrl: 'js/dashboard/dashboard.html',
            controller: 'dashboardController',
            controllerAs: 'vm'
        })
        .state('dashboard.search', {
            url: '/search',
            templateUrl: 'js/dashboard/search-form.html'
        })
        // nested states 
        // each of these sections will have their own view
        // url will be nested (/form/profile)
        .state('dashboard.results', {
            url: '/result',
            templateUrl: 'js/dashboard/search-results.html'
        })
        .state('login', {
            url: '/login',
            templateUrl : 'js/login/login.html',
            controller : 'navigation'
          })
        /*.state('admin', {
            url: '/admin',
            templateUrl: 'js/views/admin.html',
            controller: 'adminController',
            controllerAs: 'vm'
        })
        .state('encryption', {
            url: '/encryption',
            templateUrl: 'js/views/secret-creation.html',
            controller: 'encryptionController',
            controllerAs: 'vm'
        })*/

        
    // catch all route
    // send users to the form page 
    $urlRouterProvider.otherwise('/dashboard/search');
    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
})
.run(function(auth) {
    auth.init('/dashboard', '/login', '/logout');
});



