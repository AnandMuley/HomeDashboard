app.controller('PaymentScheduleController',['$scope','PaymentScheduleResource',
          function($scope,PaymentScheduleResource){

  $scope.listItem = {};
  PaymentScheduleResource.query({id:"New Property Purchases"},function(response){
    console.log('DATA : '+JSON.stringify(response.data));
  });

  $scope.enlist = function(){
    if($scope.schedule.items.indexOf($scope.listItem)==-1){
      $scope.schedule.items.push($scope.listItem);
      $scope.listItem = {};
    }
  }

  $scope.saveSchedule = function(){
    $scope.schedule.$save({},function(){
      $scope.message = "Details saved successfully !";
      $scope.schedule = new PaymentScheduleResource({items:[]});
    },function(response){
      if(response.status == 400){
         $scope.message = response.data.message;
      }else{
        $scope.message = "Something went wrong !";
      }
    });
  }

}]);
