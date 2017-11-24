services.factory('PaymentResource',['$resource','RestApiBasePath',
      function($resource,RestApiBasePath){
        return $resource(RestApiBasePath+'payments/:id',{},{
          query: {method:'GET',isArray:true},
          update : {method:'PUT',transformRequest:function(data,headersGetter){
                    delete data.billName;
                    return JSON.stringify(data);
            }
          }
        });
      }
]);
