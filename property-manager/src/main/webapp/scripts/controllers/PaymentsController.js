app.controller('PaymentsController',['$scope','PaymentResource','$location',
      function($scope,PaymentResource,$location){

  $scope.pageName = "Payments Page";

  $scope.summary = PaymentResource.query();

  $scope.imagePath = 'images/Summary.jpg';

  $scope.navigateTo = function(path){
    $location.path(path);
  }

  $scope.childPages = [
    {
      'title':'Summary',
      'description':'Consolidated view of all the payments done so far',
      'link':'payments/summary',
      'imagePath':'images/Summary.jpg'
    },
    {
      'title':'Payment Schedule',
      'description':'Expected installments to be paid as per the work done',
      'link':'payments/schedule',
      'imagePath':'images/PaymentSchedule.jpg'
    },
    {
      'title':'Add Payments',
      'description':'Add an entry to payments list',
      'link':'payments/add',
      'imagePath':'images/Payment.jpg'
    }
  ];

}]);
