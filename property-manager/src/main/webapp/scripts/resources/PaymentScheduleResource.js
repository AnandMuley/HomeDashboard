services.factory('PaymentScheduleResource',['$resource','RestApiBasePath',
      function($resource,RestApiBasePath){
        return $resource(RestApiBasePath+'paymentschedules/:id',{},{
          query:{method:'GET',isArray:false}
        });
}]);
