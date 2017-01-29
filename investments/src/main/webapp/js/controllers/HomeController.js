controllers.controller('HomeController', ['$scope','InvestmentResource',
    function ($scope,Investment) {

    $scope.investments = Investment.query();

}]);