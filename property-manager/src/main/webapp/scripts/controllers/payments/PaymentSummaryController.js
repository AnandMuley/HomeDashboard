app.controller('PaymentSummaryController',['$scope','PaymentResource',
      function($scope,PaymentResource){
        $scope.pageName = "Payment Summary";
        $scope.summary = PaymentResource.query();

}]);
