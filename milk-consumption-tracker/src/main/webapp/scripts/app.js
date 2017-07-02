var app = angular.module('WebUI',
  ['ngRoute',
    'UIControllers','ngMaterial',
    'ngCookies']);

app.config(['$routeProvider', function ($routeProvider) {

  $routeProvider.when('/', {
    templateUrl: 'views/Home.html',
    controller: 'HomeController'
  }).when('/consumption', {
    templateUrl: 'views/Consumptions.html',
    controller: 'ConsumptionController'
  });

}]);

var controllers = angular.module('UIControllers', []);
controllers.controller('AppCtrl',['$scope',function($scope){

  $scope.currentNavItem = 'page1';

}]);
