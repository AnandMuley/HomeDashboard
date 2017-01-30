controllers.controller('InvestmentManagementController',
    ['$scope','InvestmentResource',function($scope,Investment){

        $scope.myDate = new Date();

        $scope.investment = new Investment();

        $scope.investmentTypes = ['SIP','MONTHLY','QUARTERLY','ADHOC'];

        $scope.create = function () {
            $scope.investment.$save(function () {
                $scope.investment = new Investment();
            });
        }

}]);