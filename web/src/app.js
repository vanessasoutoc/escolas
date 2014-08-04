$app = angular.module("app", ['ngRoute', 'app.service', 'app.cadService']);
var urlService = "http://localhost:8080/Escolas/webresources";


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

$app.service('selectManyFunction', function() {
    this.add = function(obj, listSelect, e) {
        this.returnValue = {
            isNotExist: true,
            list: [],
            indexRemove: ""
        };
        console.log(obj);
        console.log(listSelect);
        for (var i = 0; i < listSelect.length; i++) {
            if (obj === listSelect[i]) {
                this.returnValue.isNotExist = false;
                this.returnValue.indexRemove = i;
            }
        }
        if (this.returnValue.isNotExist) {
            listSelect.push(obj);
            this.returnValue.list = listSelect;
            $(e).addClass("active");
        } else {
            listSelect.splice(this.returnValue.indexRemove, 1);
            this.returnValue.list = listSelect;
            $(e).removeClass("active");
        }

        return this.returnValue;

    };
});









