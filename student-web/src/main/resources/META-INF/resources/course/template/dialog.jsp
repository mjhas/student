<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="modal-header">
    <h3>
        <spring:message code="course.dialog.header" arguments="{{course.name}}" />
    </h3>
</div>
<div class="modal-body">
    <input type="text" ng-model="course.name" />
</div>
<div class="modal-footer">
    <button class="btn btn-default" ng-click="cancel()">
        <spring:message code="dialog.cancel" />
    </button>
    <button class="btn btn-primary" ng-click="ok()">
        <spring:message code="dialog.save" />
    </button>
</div>