var studentApp = angular.module('studentApp', []);

studentApp.controller('studentController', function($scope, studentRepository) {
	$scope.update = function() {
		studentRepository.fetchAll().success(function(students) {
			$scope.students = students;
		});
	};
	$scope.update();
	$scope.add = function(student) {
		studentRepository.save(student).success(function(data) {
			$scope.update();
			$scope.reset();
		});
	};
	$scope.reset = function() {
		$scope.student = {};
	};
	$scope.remove = function(id) {
		studentRepository.remove(id).success(function(data) {
			$scope.update();
		});
	};
	
});

studentApp.factory('studentRepository', function($http) {
	return {
		fetchAll : function() {
			var url = "api/";
			return $http.get(url);
		},
		save : function(student) {
			return $http.post("api/save", student);
		},
		remove : function(id) {
			return $http.get("api/delete/" + id);
		},
	};
});

studentApp.directive("students", function() {
	return {
		restrict : "E",
		templateUrl : "api/list.html",
	};
});

studentApp.directive("createstudent", function() {
	return {
		restrict : "E",
		templateUrl : "api/create.html",
	};
});