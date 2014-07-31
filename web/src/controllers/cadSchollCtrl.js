
$app.controller("cadSchollCtrl", function($scope, searchFactory, cadSchollFactory) {
    $scope.escola = {
        nome: '', bairro: '', professores: []
    };
    $scope.salvar = function() {
        console.log($scope.escola);
        cadSchollFactory.saveScholl($scope.escola).then( function(result){
            console.log(result);
        })
    };

    $scope.selectProfessores = function(professor) {
        $scope.escola.professores.push(professor);
        element.clicked();
    };

    searchFactory.getProfessores().then(function(result) {
        $scope.listaProfessores = result;
        console.log(result);
    });
});