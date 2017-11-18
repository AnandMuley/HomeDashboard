app.controller('AddPaymentController',['$scope','PaymentResource',
          function($scope,PaymentResource){

      $scope.payment = new PaymentResource();
      $scope.summary = PaymentResource.query();

      $scope.save = function(){
          $scope.payment.$save({},function(data){
            $scope.payment = new PaymentResource();
            $scope.message = "Payment saved successfully !";
            $scope.summary = PaymentResource.query();
          },function(response){
              if(response.status == 400){
                  $scope.message = "Bad Request";
              }else{
                  $scope.message = "Something went wrong !";
              }
          });
      }

}]);
