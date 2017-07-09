var app = angular.module('WebUI',
  ['ngRoute',
    'UIControllers','ngMaterial',
    'ngCookies']);

app.config(['$routeProvider', function ($routeProvider) {

  $routeProvider.when('/', {
    templateUrl: 'views/Home.html',
    controller: 'HomeController'
  });

}]);

var controllers = angular.module('UIControllers', []);
controllers.controller('AppCtrl',['$scope',function($scope){

  $scope.currentNavItem = 'page1';

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
    }
  ];

}]);
