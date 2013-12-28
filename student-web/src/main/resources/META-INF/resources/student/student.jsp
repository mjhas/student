<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div id="studentApp" class="row" ng:controller="studentController" xmlns:ng="http://angularjs.org">

    <createstudent class="row"></createstudent>

    <students class="row"></students>

</div>
<script type="text/javascript">
angular.bootstrap($('#studentApp'), [ 'studentApp' ]);
</script>