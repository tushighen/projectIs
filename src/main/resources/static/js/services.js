'use strict';
/* Services */
var myServices = angular.module('myServices', ['ngResource']);

myServices.factory('Student', ['$resource',
    function($resource) {
        return $resource('students/:id', {}, {
            query: {method: 'GET', isArray: true},
            get: {method: 'GET', isArray: false},
            insert: {method: 'POST', isArray: false},
            update: {method: 'PUT', params: {id: '@id'}, isArray: false},
            delete: {method: 'DELETE', params: {id: '@id'}, isArray: false}
        });
    }]);
