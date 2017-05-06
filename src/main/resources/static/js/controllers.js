'use strict';
/* Controllers */
var myControllers = angular.module('myControllers',
	['ngSanitize']);

myControllers.controller('mainCtrl', function ($rootScope) {
    });

myControllers.controller('StudentsCtrl', function ($scope, Student) {
		Student.query(function(data){
			console.log(data);
			$scope.students = data;
		});
		$scope.refresh = function(){
			Student.query(function(data){
				$scope.students = data;
			});
		};
		$scope.selectStudent = function(student){
			$scope.student = student;
		};
		$scope.createStudent = function(){
			Student.insert($scope.student);
		};
		$scope.changeStudent = function(){
			Student.update($scope.student);
		};
		$scope.deleteStudent = function(){
			Student.delete({id:$scope.student.id});
		};
	});