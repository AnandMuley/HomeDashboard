var app = angular.module('Billing',
  ['ngRoute',
    'BillingControllers','ngMaterial',
    'ngCookies','BillingServices']);

var services = angular.module('BillingServices',['ngResource']);

app.config(['$routeProvider','$mdThemingProvider', function ($routeProvider,$mdThemingProvider) {

  $routeProvider.when('/home', {
    templateUrl: 'views/Home.html',
    controller: 'HomeController'
  }).when('/',{
    redirectTo:'/home'
  }).when('/bills',{
    templateUrl : 'views/Bills.html',
    controller : 'BillsController'
  });

  $mdThemingProvider.theme('docs-dark','default').primaryPalette('yellow').dark();

}]);

var controllers = angular.module('BillingControllers', []);
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
      name:"Bills",
      link:"bills"
    }
  ];

}]);

app.value('RestApiBasePath','rest/');
