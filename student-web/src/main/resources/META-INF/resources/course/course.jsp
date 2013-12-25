<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<script src="<spring:url value="/"/>/javascript/course.js"></script>

<div ng:app="courseApp" class="row" ng:controller="courseController" xmlns:ng="http://angularjs.org">

	<createcourse class="row" ></createcourse>

	<courses class="row"></courses>

</div>