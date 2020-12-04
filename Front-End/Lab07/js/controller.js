/// <reference path="angular.min.js"/>

var app = angular.module("myApp", []);

app.controller("myCtrl1", function ($scope, $http) {
  $scope.products = list;
  $scope.prop = "name";
  $scope.sortBy = function (prop) {
    $scope.prop = prop;
  };

  $scope.begin = 0;
  $scope.pageCount = Math.ceil($scope.products.length / 8);

  $scope.first = function () {
    $scope.begin = 0;
  };

  $scope.prev = function () {
    if ($scope.begin > 0) {
      $scope.begin -= 8;
    }
  };

  $scope.next = function () {
    if ($scope.begin < ($scope.pageCount - 1) * 8) {
      $scope.begin += 8;
    }
  };

  $scope.last = function () {
    $scope.begin = ($scope.pageCount - 1) * 8;
  };
});

app.filter("percentage", function ($filter) {
  return function (input, decimals) {
    return $filter("number")(input * 100, decimals) + "%";
  };
});

app.controller("myCtrl2", function ($scope, $http) {
  $scope.products = [];
  $http.get("js/Prods2.json").then(function (response) {
    $scope.products = response.data;
    $scope.pageCount = Math.ceil($scope.products.length / 8);
  });
  $scope.prop = "name";
  $scope.sortBy = function (prop) {
    $scope.prop = prop;
  };

  $scope.begin = 0;
  $scope.pageCount = Math.ceil($scope.products.length / 8);

  $scope.first = function () {
    $scope.begin = 0;
  };

  $scope.prev = function () {
    if ($scope.begin > 0) {
      $scope.begin -= 8;
    }
  };

  $scope.next = function () {
    if ($scope.begin < ($scope.pageCount - 1) * 8) {
      $scope.begin += 8;
    }
  };

  $scope.last = function () {
    $scope.begin = ($scope.pageCount - 1) * 8;
  };
});
