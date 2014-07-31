$app.controller("searchSchollCtrl", function($scope, searchFactory) {
    $scope.teste = "teste";
    searchFactory.getSchools().then(function(result) {
        $scope.listaEscolas = result;
    });
});