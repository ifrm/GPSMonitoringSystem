<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<title>GPSMonitoringSystem</title>
<head>
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"/>
    <link href="<c:url value='/static/app-content/app.css'/>" rel="stylesheet"/>
</head>
<body ng-app="app" class="ng-cloak">

<div ng-controller="LoginController" class="container">
    <ul class="nav nav-pills" role="tablist">
        <li ng-show="!authenticated" ng-class="{active:tab('home')}"><a href="#/">home</a></li>
        <li ng-show="!authenticated"><a href="#/login">login</a></li>
        <li ng-show="authenticated"><a href="#/admin">Admin page</a></li>
        <li ng-show="authenticated"><a href="" ng-click="logout()">logout</a></li>
    </ul>
</div>


    <div class="container">
        <div class="col-sm-8 col-sm-offset-2">
            <div ng-view></div>
        </div>
    </div>


<script src='//maps.googleapis.com/maps/api/js?sensor=false'></script>
<script src="//code.jquery.com/jquery-2.0.3.min.js"></script>
<script src="//code.angularjs.org/1.2.20/angular.js"></script>
<script src="//code.angularjs.org/1.2.20/angular-route.js"></script>
<script src="//code.angularjs.org/1.2.13/angular-cookies.js"></script>

<script src="<c:url value='/static/lib/angular-simple-logger.min.js'/>"></script>
<script src="<c:url value='/static/app.js' />"></script>
<script src="<c:url value='/static/home/home.controller.js' />"></script>
<script src="<c:url value='/static/admin/admin.controller.js' />"></script>
<script src="<c:url value='/static/login/login.controller.js' />"></script>
<script src="<c:url value='/static/user/user.controller.js' />"></script>
<script src="<c:url value='/static/app-services/user.service.js' />"></script>
<script src="<c:url value='/static/app-services/position.service.js' />"></script>
<script src="<c:url value='/static/lib/angular-google-maps.min.js' />"></script>
<script src="<c:url value='/static/lib/lodash.min.js' />"></script>

</body>
</html>