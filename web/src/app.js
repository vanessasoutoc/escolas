$app = angular.module("app", ['ngRoute', 'app.service', 'app.cadService'] );
var urlService = "http://localhost:8080/Escolas/webresources/";

$app.config(function($routeProvider) {

    $routeProvider

            .when('/', {
                controller: 'escolaCtrl',
                templateUrl: 'home.html'
            })
            .when('/cadScholl', {
                controller: 'cadSchollCtrl',
                templateUrl: 'cadScholl.html'
            })
            .when('/searchScholl', {
                controller: 'searchSchollCtrl',
                templateUrl: 'searchScholl.html'
            })
            .otherwise({
                redirectTo: '/'
            });

});








