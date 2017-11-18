app.controller('AddPaymentController',['$scope','PaymentResource',
          function($scope,PaymentResource){

      $scope.payment = new PaymentResource();
      $scope.summary = PaymentResource.query();

      $scope.edit = function(payment) {
        $scope.payment = new PaymentResource(payment);
      }

      $scope.delete = function(payment){
          PaymentResource.delete({id:payment.id},function(response){
            $scope.summary = PaymentResource.query();
          },function(response){
            $scope.message = "Something went wrong !";
          });
      }

      $scope.reset = function(){
        $scope.payment = new PaymentResource();
        $scope.message = "";
      }

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
