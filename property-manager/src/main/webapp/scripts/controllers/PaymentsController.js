app.controller('PaymentsController',['$scope','PaymentResource',function($scope,PaymentResource){

  $scope.pageName = "Payments Page";

  $scope.summary = PaymentResource.query();

}]);
