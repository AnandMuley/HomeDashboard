services.factory('PaymentScheduleResource',['$resource','RestApiBasePath',
      function($resource,RestApiBasePath){
        return $resource(RestApiBasePath+'paymentschedules/:id',{},{
          query:{method:'GET',isArray:false},
          findByPropertyName : {method:'GET',isArray:false},
          update : {method:'PUT'}
        });
}]);
