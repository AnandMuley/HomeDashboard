app.controller('AddPaymentController',['$scope','PaymentResource','BillingResource',
        function($scope,PaymentResource,BillingResource){
  $scope.pageName = "Add Payment Details";
  $scope.bills = BillingResource.query();

  PaymentResource.query(function(data){
    $scope.payments = data;
  });

  $scope.payment = new PaymentResource();
  $scope.editing = false;

  $scope.getTotal = function(){
    let total = 0;
    angular.forEach($scope.payments,function(value,key){
      total+=value.amount;
    });
    return total;
  }

  $scope.save = function(){
    $scope.payment.$save({},function(data){
      $scope.payment = new PaymentResource();
      $scope.message = "Details saved successfully !";
      $scope.payments = PaymentResource.query();
    },function(response){
      $scope.message = "Something went wrong !";
    });
  }

  $scope.edit = function(payment){
    $scope.payment = new PaymentResource(payment);
    $scope.editing = true;
  }

  $scope.update = function(){
    $scope.payment.$update({},function(data){
      $scope.payment = new PaymentResource();
      $scope.message = "Details updated successfully !";
      $scope.payments = PaymentResource.query();
    },function(response){
      $scope.message = "Something went wrong !";
    });
  }

}]);
