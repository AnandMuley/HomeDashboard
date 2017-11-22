services.factory('PaidBillsResource',['$resource','RestApiBasePath',
      function($resource,RestApiBasePath){
        return $resource(RestApiBasePath+'bills/:id',{},{
          query: {method:'GET',isArray:true}
        });
      }
]);
