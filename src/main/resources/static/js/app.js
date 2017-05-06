'use strict';
/* App Module */
var domogApp = angular.module('myApp', [
    'ngRoute',
    'myControllers',
    'myServices'
]);

domogApp.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.
                when('/students.html', {
                    templateUrl: 'partials/students.html',
                    controller: 'StudentsCtrl'
                }).
                otherwise({
                    redirectTo: '/students.html'
                });
    }]);
domogApp.config([
	'$locationProvider',
	function ($locationProvider) {
		$locationProvider.html5Mode(true).hashPrefix('!');
	}
]);