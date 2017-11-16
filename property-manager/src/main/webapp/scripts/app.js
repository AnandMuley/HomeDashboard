var app = angular.module('WebUI',
  ['ngRoute',
    'UIControllers','ngMaterial',
    'ngCookies','myAppServices']);

var services = angular.module('myAppServices',['ngResource']);

app.config(['$routeProvider', function ($routeProvider) {

  $routeProvider.when('/', {
    templateUrl: 'views/Home.html',
    controller: 'HomeController'
  }).when('/payments',{
    templateUrl: 'views/Payments.html',
    controller : 'PaymentsController'
  }).when('/payments/summary',{
    templateUrl : 'views/payments/Summary.html',
    controller : 'PaymentSummaryController'
  }).when('/payments/schedule',{
    templateUrl : 'views/payments/PaymentSchedule.html',
    controller : 'PaymentScheduleController'
  });

}]);

var controllers = angular.module('UIControllers', []);
controllers.controller('AppCtrl',['$scope','$location',function($scope,$location){

  $scope.currentNavItem = 'Home';

  $scope.renderPage = function(link,displayName){
    $scope.currentNavItem = displayName;
    $location.path(link);
  }

  $scope.navItems = [
    {
      name:"Home",
      link:"home"
    },
    {
      name:"Properties",
      link:"properties"
    },
    {
      name:"Settings",
      link:"settings"
    },
    {
      name:"Payments",
      link:"payments"
    }
  ];

}]);

app.value('RestApiBasePath','rest/');
