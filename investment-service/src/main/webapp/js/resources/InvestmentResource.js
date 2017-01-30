services.factory('InvestmentResource',['BaseUrl','$resource',function (BaseUrl,$resource) {
    return $resource(BaseUrl+'investments/:id',
        {},
        {
            query : {method:'GET',params:{},isArray:true}
        });
}])