<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<script src="<spring:url value="/"/>/javascript/student.js"></script>

<div ng:app="studentApp" class="row" ng:controller="studentController" xmlns:ng="http://angularjs.org">

	<createstudent class="row" ></createstudent>

	<students class="row"></students>

</div>