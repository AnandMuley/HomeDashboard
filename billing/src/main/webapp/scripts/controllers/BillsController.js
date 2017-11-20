app.controller('BillsController',['$scope','BillingResource',
        function($scope,BillingResource){

  $scope.pageName = "My Bills";
  $scope.billingTypes = ["Mobile","MSEB","Internet"];
  $scope.frequencies = ["Monthly","Quarterly","Yearly"];

  $scope.bill = new BillingResource({
    notes:"Vodafone Bill",
    frequency:"Monthly",
    billType:"Mobile",
    billDate:"10-Nov-2017"
  });

  $scope.bills = [] ;

  $scope.save = function(){
    if($scope.bills.indexOf($scope.bill) == -1){
      $scope.bills.push($scope.bill);
      $scope.bill = new BillingResource({
        notes:"",
        frequency:"Monthly",
        billType:"",
        billDate:"10-Nov-2017"
      });
    }
    // $scope.bill.$save({},function(data){
    //   $scope.bill = new BillingResource();
    //   $scope.message = "Details saved successfully !";
    // },function(response){
    //   $scope.message = "Something went wrong !";
    // });
  }

  $scope.edit = function(bill){
    $scope.bill = bill;
  }

  $scope.delete = function(bill){
    console.log("Deleting : "+bill);
  }

  $scope.reset = function(){
    $scope.bill = new BillingResource();
  }

}]);
