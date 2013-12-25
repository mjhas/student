<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1>
	<spring:message code="student.create.new" />
</h1>
<form class="form-inline" xmlns:ng="http://angularjs.org">
	<div class="form-group">
		<label class="sr-only" for="studentName"><spring:message
				code="student.create.name" /></label> <input id="studentName" type="text"
			ng:model="student.name" class="form-control" id="exampleInputEmail1"
			placeholder="<spring:message
				code="student.create.name.hint" />" />
	</div>
	<div class="form-group">
		<button ng:click="reset()" class="btn btn-default">
			<spring:message code="student.create.clear" />
		</button>
		<button ng:click="add(student)" class="btn btn-default">
			<spring:message code="student.create.add" />
		</button>
	</div>
</form>