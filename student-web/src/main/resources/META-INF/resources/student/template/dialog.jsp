<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="modal-header">
    <h3>
        <spring:message code="student.dialog.header" arguments="{{student.name}}" />
    </h3>
</div>
<div class="modal-body">
    <form role="form">
        <div class="form-group">
            <label for="editStudentName"><spring:message code="student.create.name" /></label> <input id="editStudentName" type="text" class="form-control" ng:model="student.name" placeholder="<spring:message
                code="student.create.name.hint" />" />
        </div>
        <div class="form-group">
            <label for="editEnrolledCourses"><spring:message code="student.enrolledCourses.label" /></label> <select id="editEnrolledCourses" class="form-control" multiple ng-multiple="true" ng-model="selectedCourses" ng-options="course as course.name for course in courses">
            </select>
        </div>
    </form>
</div>
<div class="modal-footer">
    <button class="btn btn-default" ng:click="cancel()">
        <spring:message code="dialog.cancel" />
    </button>
    <button class="btn btn-primary" ng:click="ok(selectedCourses)">
        <spring:message code="dialog.save" />
    </button>
</div>