var app = angular.module('Investments', ['ngRoute', 'ngMaterial', 'InvestmentServices', 'InvestmentControllers']);
var services = angular.module('InvestmentServices', ['ngResource', 'ngCookies']);
var controllers = angular.module('InvestmentControllers', []);

app.config(['$routeProvider', '$mdIconProvider', '$mdThemingProvider', '$locationProvider',
    function ($routeProvider, $mdIconProvider, $mdThemingProvider, $locationProvider) {

        $locationProvider.hashPrefix('!');

        $routeProvider.when('/', {
            redirectTo: '/home',
        }).when('/home', {
            templateUrl: 'views/Home.html',
            controller: 'HomeController'
        }).when('/investments', {
            templateUrl: 'views/ManageInvestments.html',
            controller: 'InvestmentManagementController'
        });

        $mdThemingProvider.theme('default').primaryPalette('teal', {
            'default': '500',
            'hue-1': '300',
            'hue-2': '700',
            'hue-3': 'A100'
        }).accentPalette('amber').warnPalette('red');

    }]).value('BaseUrl', 'http://localhost:8090/investments/rest/');