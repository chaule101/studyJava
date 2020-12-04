var app = angular.module("myapp", ['ngRoute']);
app.config(function($routeProvider){
    $routeProvider
    .when("home",{
        templateUrl: "Home.html"
    })
    .when("/home1",{
        templateUrl: "test.html"
    })
    .when("/account/dangky",{
        templateUrl: "register.html"
    })
    .when("/about",{
        templateUrl: "About.html"
    })
    .when("/giohang",{
        templateUrl: "giohang.html"
    })
    .when("/feedback",{
        templateUrl: "Feedback.html"
    })
    .when("/fag",{
        templateUrl: "Fag.html"
    })
    .when("/account/login",{
        templateUrl: "account/Login.html"
    })
    .when("/account/register",{
        templateUrl: "account/Register.html"
    })
    .when("/account/forgot",{
        templateUrl: "account/Forgot.html"
    })
    .when("/account/logoff",{
       redirectTo:"/home"
    })
    .when("/account/change",{
        templateUrl: "account/Change.html"
    })
    .when("/account/register",{
        templateUrl: "account/Register.html"
    })
    .when("/account/profile",{
        templateUrl: "account/Profile.html"
    })
    .when("/account/orders",{
        templateUrl: "account/Orders.html"
    })
    .when("/account/products",{
        templateUrl: "ProductList.html"
    })
    .when("/category/:id",{
        templateUrl: "ProductList.html",
        controller: "categoryCtrl"
    })
    .when("/supplier/:id",{
        templateUrl: "ProductList.html",
        controller: "supplierCtrl"
    })
    .when("/special/:id",{
        templateUrl: "ProductList.html",
        controller: "specialCtrl"
    })

    .otherwise({
        redirectTo :"/home"
    })

    app.run(function($rootScope){
        $rootScope.$on('$routeChangeStart',function(){
        $rootScope.loading = true;
    });
        $rootScope.$on('$routeChangeSuccess',function(){
        $rootScope.loading = false;
    });
        $rootScope.$on('$routeChangeError',function(){
        $rootScope.loading = false;
        alert("Lỗi , không tải được template")
        });
    });

});