
$app.controller("cadSchollCtrl", function($scope, searchFactory, cadSchollFactory, selectManyFunction) {
    $scope.escola = {
        nome: '', bairro: '', professores: []
    };
    $scope.salvar = function() {
        console.log($scope.escola);
        cadSchollFactory.saveScholl($scope.escola).then(function(result) {
            console.log(result);
        })
    };

    $scope.selectProfessores = function(professor, e) {

        var isexit = false;
        var element = angular.element(e.target);
        var returnvalue = selectManyFunction.add(professor, $scope.escola.professores, element);
        $scope.escola.professores = returnvalue.list;
        console.log(returnvalue);
    };

    searchFactory.getProfessores().then(function(result) {
        $scope.listaProfessores = result;
        console.log(result);
    });
});