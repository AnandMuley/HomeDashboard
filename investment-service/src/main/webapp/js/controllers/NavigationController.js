controllers.controller('NavigationController',
		['$scope','$location',
		 function($scope,$location){
	
	$scope.tabs = [
		{
			name : 'home',
			path : 'home'
		},
		{
			name : 'manage',
			path : 'manage'
		}
	];
	
	$scope.getSelectedTab = function(path){
		var len=$scope.tabs.length;
		for(var i=0;i<len;i++){
			if($scope.tabs[i].path==path){
				return i;
			}
		}
		return 0;
	}
	
	$scope.selectedTab = $scope.getSelectedTab($location.path().substring(1,$location.path().length));
	
	$scope.loadView = function(tab){
		$location.path(tab.path);
	}

	$scope.loadViewUrl = function (suffix) {
		$location.path(suffix);
	}
	
}]);