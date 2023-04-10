app= angular.module("admin-app", ["ngRoute"]);

app.config(function($routeProvider){
    $routeProvider
    .when("/product", {
        templateUrl: "/assets/admin/product/index.html",
        controller: "product-ctrl"
    })
    .when("/authorize", {
        templateUrl: "/assets/admin/authority/index.html",
        controller: "authority-ctrl"
    })
    .when("/unathorized", {
        templateUrl: "/assets/admin/authorize/unathorized.html",
        controller: "authority-ctrl"
    })
    .otherwise({
        templateUrl: "/assets/admin/product/index.html",
        controller: "product-ctrl"
    })
})
