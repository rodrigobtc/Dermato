var appDermato = angular.module("appDermato", ['webcam']);
appDermato.controller("indexController", function($scope, $http) {
	$scope.usuario = {};
	$scope.carregarUsuarios = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:8081/usuarios'
		}).then(function(response) {
			$scope.usuarios = response.data;
			console.log(response.data);
			console.log(response.data);
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		})
	}
	
	$scope.carregarUsuarios();

	$scope.salvarUsuario = function() {
		$http({
			method : 'POST',
			url : 'http://localhost:8081/usuarios',
			data : $scope.usuario
		}).then(function(response) {
			$scope.usuarios = response.data;
			console.log(response.data);
			console.log(response.data);
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		})

	}
});