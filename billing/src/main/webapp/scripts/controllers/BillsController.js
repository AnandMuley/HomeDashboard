app.controller('BillsController',['$scope','BillingResource',
        function($scope,BillingResource){

  $scope.pageName = "My Bills";
  $scope.billingTypes = ["Mobile","MSEB","Internet"];
  $scope.frequencies = ["Monthly","Quarterly","Yearly"];
  $scope.editing = false;

  $scope.bill = new BillingResource({
    notes:"",
    frequency:"Monthly",
    billType:"Mobile",
    billDate:""
  });

  $scope.bills = BillingResource.query();

  $scope.update = function(){
    $scope.bill.$update({},function(data){
      $scope.bill = new BillingResource();
      $scope.message = "Details updated successfully !";
      $scope.bills = BillingResource.query();
      $scope.editing = false;
    },function(response){
      $scope.message = "Something went wrong !";
    });
  }

  $scope.save = function(){
    $scope.bill.$save({},function(data){
      $scope.bill = new BillingResource();
      $scope.message = "Details saved successfully !";
      $scope.bills = BillingResource.query();
    },function(response){
      $scope.message = "Something went wrong !";
    });
  }

  $scope.edit = function(bill){
    $scope.bill = new BillingResource(bill);
    $scope.editing = true;
  }

  $scope.delete = function(bill){
    BillingResource.delete({id:bill.id},function(data){
      $scope.bills = BillingResource.query();
    },function(response){
      $scope.message = "Something went wrong !";
    })
  }

  $scope.reset = function(){
    $scope.bill = new BillingResource();
  }

}]);
