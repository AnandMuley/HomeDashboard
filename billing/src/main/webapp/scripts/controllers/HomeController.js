app.controller('HomeController',['$scope','BillingResource',
      function($scope,BillingResource){
        $scope.bills = BillingResource.status();
}]);
