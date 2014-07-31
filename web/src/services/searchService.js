
$app = angular.module("app.service", []);

$app.factory("searchFactory", ['$http', function($http) {
        return{
            getSchools: function() {
                return $http({method: 'GET', url: urlService + '/escolas'}).
                        then(function(result) {
                            console.log(result);
                            return result.data;
                        },
                                function(data) {
                                    console.log("error");
                                    console.log(data);
                                });

            },
            getProfessores: function() {
                return this.getSchools().then(function(result) {

                    var list = [];
                    for (var i = 0; i < result.length; i++) {
                        for (var j = 0; j < result[i].professores.length; j++) {
                            list.push(result[i].professores[j]);
                        }
                    }
                    console.log(list);
                    return list;
                });

            }
        }
    }]);

