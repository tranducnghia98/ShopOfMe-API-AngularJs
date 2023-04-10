app.controller("authority-ctrl", function ($scope, $http, $location) {
    $scope.roles = [];
    $scope.admins = [];
    $scope.authorities = [];

    $scope.intilialize = function () {
        //load all roles
        $http.get("/rest/roles").then(resp => {
            $scope.roles = resp.data;
        })

        //load staff and dir(admin)
        $http.get("/rest/accounts?admin=true").then(resp => {
            $scope.admins = resp.data;
        })
        //load authorites of staff and dir(admin)
        $http.get("/rest/authorities?admin=true").then(resp => {
            $scope.authorities = resp.data;
        }).catch(err => {
            $location.path("unauthorized");
        });
    }

    $scope.authority_of = function (acc, role) {
        if ($scope.authorities) {
            return $scope.authorities.find(ur => ur.account.username == acc.username && ur.role.id == role.id);
        }
    }
    $scope.authority_changed = function (acc, role) {
        var authority = $scope.authority_of(acc, role);
        if (authority) {
            $scope.revoke_authority(authority);
        } else {
            authority = { account: acc, role: role };
            $scope.grant_authority(authority);
        }
    }

    //add authority
    $scope.grant_authority = function (authority) {
        $http.post(`/rest/authorities`, authority).then(resp => {
            $scope.authorities.push(resp, data)
            alert("Success")
        }).catch(err => {
            alert("Fail")
            console.log(err);
        })
    }

    //delete

    $scope.revoke_authority = function (authority) {
        $http.delete(`/rest/authorities/${authority.id}`).then(resp => {
            var index = $scope.authorities.findIndex(a => a.id == authority.id);
            $scope.authorities.splice(index, 1);
            alert("Success");
        }).catch(err => {
            alert("Fail");
            console.log(err);
        })
    }
    $scope.intilialize();
});