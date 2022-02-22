angular.module('market-front').controller('ordersController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/market/';

    $scope.loadOrders = function () {
        $http({
            url: contextPath + 'api/v1/orders',
            method: 'GET'
        }).then(function (response) {
            $scope.orders = response.data;
            console.log($scope.orders);
        });
    };

    $scope.loadOrders();
});