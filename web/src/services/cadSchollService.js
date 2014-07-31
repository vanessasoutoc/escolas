
$app = angular.module("app.cadService", []);

$app.factory("cadSchollFactory", ['$http', function($http) {
        return{
            saveScholl: function(escola) {
                return $http
                        ({method: 'POST',
                            url: urlService + 'escolas/salvar', data: escola}).
                        then(function(result) {
                            console.log(result);
                            return result.data;
                        },
                                function(data) {
                                    console.log("error");
                                    console.log(data);
                                });

            }
        }
    }]);

