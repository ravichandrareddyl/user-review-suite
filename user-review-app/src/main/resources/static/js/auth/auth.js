(function () {
  angular.module('auth', []).factory('auth', function($http, $location, $rootScope) {
    var auth = {
      authenticated : false,
      loginPath : '/login',
      logoutPath : '/logout',
      homePath : '/',
      authenticate : function(credentials, callback) {
        var headers = credentials && credentials.username ? {
          authorization : "Basic "+ btoa(credentials.username + ":" + credentials.password)
        } : {};

        $http.get('user', {
            headers : headers
          }).then(function(response) {
            if (response.data.name) {
              auth.authenticated = true;
            } else {
              auth.authenticated = false;
            }
          // $location.path(auth.homePath);
            $location.path(auth.path==auth.loginPath ? auth.homePath : auth.path);
            callback && callback(auth.authenticated);
          }).catch(function() {
            auth.authenticated = false;
            callback && callback(false);
          });
      },
      
      clear : function() {
          auth.authenticated = false;
          $location.path(auth.loginPath);
          $http.post(auth.logoutPath, {});
      
      },
      
      init : function(homePath, loginPath, logoutPath) {
          auth.homePath = homePath;
          auth.loginPath = loginPath;
          auth.logoutPath = logoutPath;
          auth.authenticate({}, function(authenticated) {
              if (authenticated) {
                $location.path(auth.path);
              }
            });
          $rootScope.$on('$routeChangeStart', function() {enter();});
      }
    };
    
    var enter = function() {
      if ($location.path() != auth.loginPath) {
        auth.path = $location.path();
        if (!auth.authenticated) {
          $location.path(auth.loginPath);
        }
      }          
    };

    return auth;

  });
})()
