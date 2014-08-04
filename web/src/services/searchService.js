
$app = angular.module("app.service", []);

$app.factory("searchFactory", ['$http', function($http) {
        return{
            getSchools: function() {
                return $http({method: 'GET', url: urlService + '/escolas'}).
                        then(function(result) {


                            function Escola(objeto) {
                                this.id = objeto.id;
                                this.nome = objeto.nome;
                                this.bairro = objeto.bairro;
                                this.professores = [];
                                for (var i = 0; i < objeto.professores.length; i++) {
                                    this.professores.push(new Professor(objeto.professores[i]));
                                }

                                var valid = function() {
                                    if (this.nome !== 'undefined') {
                                        return true;
                                    }
                                    return false;
                                }
                            }

                            function Professor(objeto) {
                                this.id = objeto.id;
                                this.nome = objeto.nome;
                                this.especialidade = objeto.especialidade;
                            }

                            console.log(result);
                            var lista = result.data;
                            var escolas = [];
                            console.log(escolas);
                            for (var i = 0; i < lista.length; i++) {
                                escolas.push(new Escola(lista[i]));
                            }
                            console.log(escolas);
                            return escolas;

                        },
                                function(data) {
                                    console.log("error");
                                    console.log(data);
                                });



            },
            getProfessores: function() {
                return $http({method: 'GET', url: 'http://localhost:8080/Professor/webresources/professores'}).
                        then(function(result) {
                            console.log(result);
                            return result.data;
                        },
                                function(data) {
                                    console.log("error");
                                    console.log(data);
                                });

            }
        };
    }]);

