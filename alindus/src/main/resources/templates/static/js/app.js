'use strict';



var myApp = angular.module('cubicApp', [ 'ngRoute', 'ui.bootstrap']);

myApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.
	when('/', {
		templateUrl : '/static/js/dashboard.html',
		controller : 'dashboardCtrl'
	}).
	when('/reports', {
		templateUrl : '/static/js/reports.html',
		controller : 'reportCtrl'
	}).
	when('/admin',{
		templateUrl : '/static/pages/admin.html',
		controller : 'AdminCtrl'
	}).
	otherwise({
		redirectTo : '/'
	})
} ])
