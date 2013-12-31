<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1>
    <spring:message code="course.list.title" />
</h1>
<div class="list">
    <div class="row" ng-controller="gridController">
        <div class="col-xs-8 col-sm-10">
            <div class="courseGrid" ng-grid="gridOptions"></div>
        </div>
        <div class="courseGridActions col-xs-4 col-sm-2">
            <div class="row" ng-repeat="course in mySelections">
                <button ng-click="remove(course.id)" class="btn btn-default btn-xs">Delete {{course.name}}</button>
                <button class="btn btn-primary btn-xs" ng-click="edit()">Edit {{course.name}}</button>
            </div>
        </div>

    </div>
</div>