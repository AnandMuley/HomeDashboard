app.controller('AddBillController',['$scope','PaidBillsResource',
          function($scope,PaidBillsResource){

  $scope.bill = new PaidBillsResource();
  $scope.bills = PaidBillsResource.query();

  $scope.save = function(){
    $scope.bill.$save({},function (data) {
      $scope.bill = new PaidBillsResource();
      $scope.message = "Details saved successfully !";
      $scope.bills = PaidBillsResource.query();
    },function (response) {
      $scope.message = "Something went wrong !";
    });
  }

  $scope.reset = function(){
      $scope.bill = new PaidBillsResource();
  }

  $scope.edit = function(bill){
    $scope.bill = new PaidBillsResource(bill);
  }

  $scope.delete = function(bill){
    $scope.bill.$delete({id:bill.id},function(response){
      $scope.bills = PaidBillsResource.query();
    },function(response){
      $scope.message = "Something went wrong !";
    });
  }

}]);
