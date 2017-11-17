app.controller('PaymentScheduleController',['$scope','PaymentScheduleResource',
          function($scope,PaymentScheduleResource){

  $scope.listItem = {};
  $scope.recordExists = false;

  PaymentScheduleResource.findByPropertyName({id:"New Property Purchase"},function(response){
    $scope.schedule = new PaymentScheduleResource(response);
    $scope.recordExists = true;
  },function(response){
      if(response.status == 400){
        $scope.message = response.data.message;
      }else if(response.status == 404){
        $scope.message = response.data.message;
      }else{
        $scope.message = "Something went wrong !";
      }
  });

  $scope.update = function(){
    $scope.schedule.$update();
  }

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
