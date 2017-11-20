app.controller('BillsController',['$scope','BillingResource',
        function($scope,BillingResource){

  $scope.pageName = "My Bills";

  $scope.bill = new BillingResource({frequency:"Monthly",billType:"Mobile",billDate:"10-Nov-2017"});

  $scope.save = function(){
    $scope.bill.$save({},function(data){
      $scope.bill = new BillingResource();
      $scope.message = "Details saved successfully !";
    },function(response){
      $scope.message = "Something went wrong !";
    });
  }

  $scope.reset = function(){
    $scope.bill = new BillingResource();
  }

}]);
