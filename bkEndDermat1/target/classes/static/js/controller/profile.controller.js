/**
 * Created by fernando on 24/02/16.
 */
angular.module('luxysaleApp').controller('CustomerProfileController', function ($rootScope, $scope, $uibModal, toaster, $timeout, Principal, DataUtils, Customer) {
    $scope.isAuthenticated = Principal.isAuthenticated;

    $scope.myCroppedImage = '';

    $scope.handleImageCustomerFileSelect = function (evt) {
        var file = evt.currentTarget.files[0];
        var fakeFilePath = evt.currentTarget.value; //DOM return fake path instead of original path to the attribute value (security reason)

        if (file) {
            var fileExtension = fakeFilePath.slice((fakeFilePath.lastIndexOf('.') - 1 >>> 0) + 2);
            if (fileExtension.toUpperCase() != 'JPEG' && fileExtension.toUpperCase() != 'JPG' && fileExtension.toUpperCase() != 'PNG') return;
            DataUtils.resizeImage(file, fileExtension, 1000, function (resizedImage) {
                var modalInstance = $uibModal.open({
                    templateUrl: 'scripts/app/main/customer/profile/profile-image-crop-dialog.html',
                    controller: 'CustomerProfileImageCropDialogController',
                    backdrop: 'static', //make close function to the modal be called just on click of cancel button
                    keyboard: false, //make close function to the modal be called just on click of cancel button
                    windowClass: 'modal-crop-profile-image', //on file: css/dialog.crop.profile.image.less
                    resolve: {
                        image: function () {
                            return resizedImage;
                        }
                    }
                });

                modalInstance.result.then(function (image) {
                    $scope.customer.imagePath = image;
                    updateCustomerPercentage();
                });
            });
        }

        evt.currentTarget.value = null; //make onchange works when choosing same image as last image selected for the input file
    };
});
