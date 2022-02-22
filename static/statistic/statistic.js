angular.module('market-front').controller('statisticController', function ($scope, $http, $location, $localStorage) {
    const contextPath = 'http://localhost:8189/market/';

    $scope.loadStatistic = function () {
        $http({
            url: contextPath + 'api/v1/statistic',
            method: 'GET'
        }).then(function (response) {

            $scope.statistic = response.data;
            console.log($scope.statistic);

        });
    };
    $scope.loadStatistic();
});


