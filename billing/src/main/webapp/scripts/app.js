var app = angular.module('Billing',
  ['ngRoute',
    'BillingControllers','ngMaterial',
    'ngCookies','BillingServices']);

var services = angular.module('BillingServices',['ngResource']);
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
        name:"Add Bill",
        link:"add"
      },
      {
        name:"Add Payment",
        link:"add-payment"
      }
    ];

  }]);

app.config(['$routeProvider','$mdThemingProvider', function ($routeProvider,$mdThemingProvider) {

  $routeProvider.when('/home', {
    templateUrl: 'views/Home.html',
    controller: 'HomeController'
  }).when('/',{
    redirectTo:'/home'
  }).when('/add',{
    templateUrl : 'views/AddBill.html',
    controller : 'BillsController'
  }).when('/add-payment',{
    templateUrl : 'views/AddPayment.html',
    controller : 'AddPaymentController'
  });

  $mdThemingProvider.theme('docs-dark','default').primaryPalette('yellow').dark();

}]);

app.value('RestApiBasePath','rest/');
