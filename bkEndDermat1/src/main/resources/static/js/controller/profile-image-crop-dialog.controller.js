/**
 * Created by fernando on 23/03/16.
 */
angular.module('luxysaleApp').controller("CustomerProfileImageCropDialogController", function ($rootScope, $scope, $uibModalInstance, DataUtils, toaster, Customer, image) {
    $scope.showProgressBar = false;
    $scope.myCroppedImage = "";
    $scope.cropType = "square";

    var reader = new FileReader();
    reader.onload = function (evt) {
        $scope.$apply(function ($scope) {
            $scope.myImage = evt.target.result;
        });
    };
    reader.readAsDataURL(image);

    $scope.saveCroppedImage = function () {
        var formData = new FormData();
        var blob = DataUtils.dataURLToBlob($scope.myCroppedImage);
        blob.name = image.name;
        formData.append("file", blob, image.name);
        $scope.promise = Customer.profileImage.save(formData, function () {
            $uibModalInstance.close($scope.myCroppedImage);
            $rootScope.userImagePath = $scope.myCroppedImage;
        }, function () {
            //toaster.pop("error", "Error", "Something went wrong!");
        }).$promise;
    };

    $scope.cancel = function () {
        $uibModalInstance.dismiss("cancel");
    };
});
