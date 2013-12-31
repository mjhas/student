(function(angular, $j, undefined) {
	var courseApp = angular.module('courseApp', [ 'ngGrid',
			'ui.bootstrap.modal' ]);

	courseApp.controller('courseController',
			function($scope, courseRepository) {
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
	courseApp.controller('gridController', function($scope, $modal,
			courseRepository) {
		$scope.mySelections = [];
		$scope.gridOptions = {
			data : 'courses',
			columnDefs : [ {
				field : 'name',
				displayName : 'Name'
			} ],
			selectedItems : $scope.mySelections,
			multiSelect : false
		};
		$scope.edit = function() {
			var modalInstance = $modal.open({
				templateUrl : 'api/dialog.html',
				controller : 'dialogController',
				resolve : {
					course : function() {
						return $scope.mySelections[0];
					}
				}
			});
		};
	});
	courseApp.controller('dialogController', function($scope, $modalInstance,
			course, courseRepository) {
		$scope.course = course;
		$scope.oldName = '' + course.name;
		$scope.ok = function() {
			studentRepository.save($scope.course);
			$modalInstance.close($scope.course);
		};
		$scope.cancel = function() {
			$scope.course.name = $scope.oldName;
			$modalInstance.dismiss('cancel');
		};
	});
}(angular, jQuery));