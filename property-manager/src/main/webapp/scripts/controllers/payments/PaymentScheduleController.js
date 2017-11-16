app.controller('PaymentScheduleController',['$scope','PaymentScheduleResource',
          function($scope,PaymentScheduleResource){

  $scope.listItem = {};
  $scope.schedule = new PaymentScheduleResource({propertyName:"Life Republic",items:[]});

  $scope.enlist = function(){
    if($scope.schedule.items.indexOf($scope.listItem)==-1){
      $scope.schedule.items.push($scope.listItem);
      $scope.listItem = {};
    }
  }

  $scope.saveSchedule = function(){
    $scope.schedule.$save({},function(){
      $scope.schedule = new PaymentScheduleResource({propertyName:"Life Republic",items:[]});
      $scope.message = "List saved !!!";
    },function(){
      $scope.message = "Something went wrong !";
    });
  }

}]);
