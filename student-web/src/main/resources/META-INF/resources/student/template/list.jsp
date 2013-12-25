<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1><spring:message code="student.list.title" /></h1>
<div class="list" xmlns:ng="http://angularjs.org">
	<div class="row"  ng:repeat="student in students">
	<div class="col-xs-1">
		{{student.name}}
	</div>
	<div class="col-xs-2">
		<button ng:click="remove(student.id)" class="btn btn-default btn-xs">X</button>
	</div>
	</div>
</div>