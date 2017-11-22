var app = angular.module('PaidBills',
  ['ngRoute',
    'AppControllers','ngMaterial',
    'ngCookies','AppServices']);

var services = angular.module('AppServices',['ngResource']);
var controllers = angular.module('AppControllers', []);

app.config(['$routeProvider','$mdThemingProvider', function ($routeProvider,$mdThemingProvider) {

  $routeProvider.when('/home', {
    templateUrl: 'views/Home.html',
    controller: 'HomeController'
  }).when('/',{
    redirectTo:'/home'
  }).when('/add',{
    templateUrl : 'views/AddBill.html',
    controller : 'AddBillController'
  });

  $mdThemingProvider.theme('docs-dark','default').primaryPalette('yellow').dark();

}]);


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
      name:"Add Bill",
      link:"add"
    }
  ];

}]);

app.value('RestApiBasePath','rest/');
