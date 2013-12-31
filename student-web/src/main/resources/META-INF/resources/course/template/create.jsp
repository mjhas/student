<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1>
	<spring:message code="course.create.new" />
</h1>
<form class="form-inline" >
	<div class="form-group">
		<label class="sr-only" for="courseName"><spring:message
				code="course.create.name" /></label> <input id="courseName" type="text"
			ng:model="course.name" class="form-control" id="exampleInputEmail1"
			placeholder="<spring:message
				code="course.create.name.hint" />" />
	</div>
	<div class="form-group">
		<button ng-click="reset()" class="btn btn-default">
			<spring:message code="course.create.clear" />
		</button>
		<button ng-click="add(course)" class="btn btn-default">
			<spring:message code="course.create.add" />
		</button>
	</div>
</form>