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
  });

}]);

var controllers = angular.module('UIControllers', []);
controllers.controller('AppCtrl',['$scope','$location',function($scope,$location){

  $scope.currentNavItem = 'page1';

  $scope.renderPage = function(pageName){
    $location.path(pageName);
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
