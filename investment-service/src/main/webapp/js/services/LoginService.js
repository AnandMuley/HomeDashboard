services.service('LoginService',
    ['$location', '$rootScope', '$cookies', 'BaseUrl', '$resource', 'UsersResource',
        function ($location, $rootScope, $cookies, BaseUrl, $resource, UsersResource) {
            const COOKIE_AUTH = "auth";
            var self = this;

            this.addAuthCookie = function (user) {
                var expiryDate = new Date();
                expiryDate.setMinutes(expiryDate.getMinutes() + 15);
                $cookies.putObject(COOKIE_AUTH, user, {expires: expiryDate});
            }

            this.removeAuthCookie = function () {
                $cookies.remove(COOKIE_AUTH);
            }

            this.isUserLoggedIn = function () {
                var auth = $cookies.getObject(COOKIE_AUTH);
                if (auth != undefined) {
                    $rootScope.authenticated = true;
                    $rootScope.auth = {
                        id: auth.id
                    };
                } else {
                    $rootScope.authenticated = false;
                    $location.path('/');
                }
            }

            this.isRegistered = function (username, password, callback) {
                UsersResource.authenticate({
                    username: username,
                    password: password
                }, function (response, responseHeader) {
                    if (response.registered) {
                        $rootScope.authenticated = true;
                        $rootScope.auth = {
                            id: response.id
                        }
                        self.addAuthCookie(response);
                        callback(true);
                    } else {
                        callback(false);
                    }
                });
            }

        }]);