services.factory('BillingResource',['$resource','RestApiBasePath',
      function($resource,RestApiBasePath){
            return $resource(RestApiBasePath+'bills/:id',{},{
              query : {method:'GET',isArray:true},
              update : {method : 'PUT',isArray:false},
              delete : {method:'DELETE'},
              status : {params:{id:'status'},method:'GET',isArray:true}
            });
}]);
