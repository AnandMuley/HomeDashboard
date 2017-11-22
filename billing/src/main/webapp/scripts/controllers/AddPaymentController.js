app.controller('AddPaymentController',['$scope','PaymentResource','BillingResource',
        function($scope,PaymentResource,BillingResource){
  $scope.pageName = "Add Payment Details";
  $scope.bills = BillingResource.query();
  $scope.payments = PaymentResource.query();

  $scope.payment = new PaymentResource({
    paymentDate:"20-Nov-2017",
    amount:2300,
    billId:"BID201"
  });

  $scope.save = function(){
    $scope.payment.$save({},function(data){
      $scope.payment = new PaymentResource({
        paymentDate:"20-Nov-2017",
        amount:2300,
        billId:"BID201"
      });
      $scope.message = "Details saved successfully !";
    },function(response){
      $scope.message = "Something went wrong !";
    });
  }

}]);
