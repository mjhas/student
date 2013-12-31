(function(angular, $j, undefined) {

	var studentApp = angular.module('studentApp', [ 'ngGrid',
			'ui.bootstrap.modal' ]);
	studentApp.controller('studentController', function($scope,
			studentRepository) {
		$scope.update = function() {
			studentRepository.fetchAll().success(function(students) {
				$scope.students = students;
				angular.forEach($scope.students, function(student) {
					student.courses = function(){
						return student.enrolledCourses.length;
					};
				});
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
			fetchCourses : function() {
				var url = "api/courses";
				return $http.get(url);
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
	studentApp.controller('gridController', function($scope, $modal,
			studentRepository) {
		$scope.mySelections = [];
		$scope.gridOptions = {
			data : 'students',
			columnDefs : [ {
				field : 'name',
				displayName : 'Name'
			}, {
				field : 'courses()',
				displayName : 'Courses'
			}, ],
			selectedItems : $scope.mySelections,
			multiSelect : false
		};
		$scope.edit = function() {
			var modalInstance = $modal.open({
				templateUrl : 'api/dialog.html',
				controller : 'dialogController',
				resolve : {
					student : function() {
						return $scope.mySelections[0];
					},
				}
			});
		};
	});
	studentApp.controller('dialogController', function($scope, $modalInstance,
			student, studentRepository) {
		$scope.student = student;
		$scope.selectedCourses=[];
		studentRepository.fetchCourses().success(function(courses) {
			$scope.courses = courses;
			//$scope.selectedCourses.push($scope.courses[0]);
			student.enrolledCourses.forEach(function(enrolled){
				$scope.courses.forEach(function(orig_course){
					if (enrolled.id===orig_course.id){
						$scope.selectedCourses.push(orig_course);
					}
				});
			});
		});
		$scope.oldName = '' + student.name;
		$scope.ok = function(selectedCourses) {
			$scope.student.enrolledCourses=selectedCourses;
			studentRepository.save($scope.student);
			$modalInstance.close($scope.student);
		};
		$scope.cancel = function() {
			$scope.student.name = $scope.oldName;
			$modalInstance.dismiss('cancel');
		};
	});
}(angular, jQuery));