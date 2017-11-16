app.controller('PaymentScheduleController',['$scope',function($scope){

  $scope.listItem = {};
  $scope.schedule = {propertyName:"Life Republic",items:[]};

  $scope.enlist = function(){
    if($scope.schedule.items.indexOf($scope.listItem)==-1){
      $scope.schedule.items.push($scope.listItem);
      $scope.listItem = {};
    }
  }

  $scope.saveSchedule = function(){
    console.log('Saving changes....');

  }

}]);
