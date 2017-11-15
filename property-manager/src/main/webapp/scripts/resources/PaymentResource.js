services.factory('PaymentResource',['$resource','RestApiBasePath',
      function($resource,RestApiBasePath){
        return $resource(RestApiBasePath+'payments/:id',{},{
          query: {method:'GET',isArray:false}
        });
      }
]);
