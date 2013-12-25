var courseApp = angular.module('courseApp', []);

courseApp.controller('courseController', function($scope, courseRepository) {
	$scope.update = function() {
		courseRepository.fetchAll().success(function(courses) {
			$scope.courses = courses;
		});
	};
	$scope.update();
	$scope.add = function(course) {
		courseRepository.save(course).success(function(data) {
			$scope.update();
			$scope.reset();
		});
	};
	$scope.reset = function() {
		$scope.course = {};
	};
	$scope.remove = function(id) {
		courseRepository.remove(id).success(function(data) {
			$scope.update();
		});
	};
	
});

courseApp.factory('courseRepository', function($http) {
	return {
		fetchAll : function() {
			var url = "api/";
			return $http.get(url);
		},
		save : function(course) {
			return $http.post("api/save", course);
		},
		remove : function(id) {
			return $http.get("api/delete/" + id);
		},
	};
});

courseApp.directive("courses", function() {
	return {
		restrict : "E",
		templateUrl : "api/list.html",
	};
});

courseApp.directive("createcourse", function() {
	return {
		restrict : "E",
		templateUrl : "api/create.html",
	};
});