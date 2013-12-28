<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="modal-header" xmlns:ng="http://angularjs.org">
    <h3><spring:message code="student.dialog.header" arguments="{{student.name}}" /></h3>
</div>
<div class="modal-body" xmlns:ng="http://angularjs.org">
    <input type="text" ng:model="student.name" />
</div>
<div class="modal-footer" xmlns:ng="http://angularjs.org">
    <button class="btn btn-default" ng:click="cancel()"><spring:message code="dialog.cancel" /></button>
    <button class="btn btn-primary" ng:click="ok()"><spring:message code="dialog.save" /></button>
</div>