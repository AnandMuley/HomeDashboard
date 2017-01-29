controllers.controller('InvestmentManagementController',
    ['$scope','InvestmentResource',function($scope,Investment){

        $scope.investment = new Investment();

        $scope.create = function () {
            // $scope.investment.amount = parseFloat($scope.investment.amount);
            $scope.investment.$save(function () {
                $scope.investment = new Investment();
            });
        }

}]);