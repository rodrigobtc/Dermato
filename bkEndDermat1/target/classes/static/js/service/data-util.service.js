angular.module('luxysaleApp').service('DataUtils', function () {
    this.byteSize = function (base64String) {
        if (!angular.isString(base64String)) {
            return '';
        }
        function endsWith(suffix, str) {
            return str.indexOf(suffix, str.length - suffix.length) !== -1;
        }

        function paddingSize(base64String) {
            if (endsWith('==', base64String)) {
                return 2;
            }
            if (endsWith('=', base64String)) {
                return 1;
            }
            return 0;
        }

        function size(base64String) {
            return base64String.length / 4 * 3 - paddingSize(base64String);
        }

        function formatAsBytes(size) {
            return size.toString().replace(/\B(?=(\d{3})+(?!\d))/g, " ") + " bytes";
        }

        return formatAsBytes(size(base64String));
    };

    this.abbreviate = function (text) {
        if (!angular.isString(text)) {
            return '';
        }
        if (text.length < 30) {
            return text;
        }
        return text ? (text.substring(0, 15) + '...' + text.slice(-10)) : '';
    };

    this.resizeImage = function (file, fileExtension, maxSize, callback) {
        var self = this;
        if(file.type.match(/image.*/)) {
            // Load the image
            var reader = new FileReader();
            reader.onload = function (readerEvent) {
                var image = new Image();
                image.onload = function () {
                    // Resize the image
                    loadImage.parseMetaData(file, function (data) {
                        if (data.exif) {
                            var orientation = data.exif.get('Orientation');
                            if ([3, 6, 8].indexOf(orientation) > -1) {
                                var canvas = document.createElement("canvas"),
                                    ctx = canvas.getContext("2d"),
                                    cw = image.width, ch = image.height, cx = 0, cy = 0, deg = 0;
                                var rw = cw, rh = ch;
                                var dataUrl;
                                var resizedImage;
                                switch (orientation) {
                                    case 3:
                                        cx = -image.width;
                                        cy = -image.height;
                                        deg = 180;
                                        break;
                                    case 6:
                                        cw = image.height;
                                        ch = image.width;
                                        cy = -image.height;
                                        rw = ch;
                                        rh = cw;
                                        deg = 90;
                                        break;
                                    case 8:
                                        cw = image.height;
                                        ch = image.width;
                                        cx = -image.width;
                                        rw = ch;
                                        rh = cw;
                                        deg = 270;
                                        break;
                                }

                                if (cw > maxSize || ch > maxSize) {
                                    var p = 0;
                                    if (cw > maxSize) {
                                        p = (maxSize) / cw;
                                        cw = maxSize;
                                        ch = p * ch;
                                    } else if (ch > maxSize) {
                                        p = (maxSize) / ch;
                                        ch = maxSize;
                                        cw = p * cw;
                                    }

                                    cy = p * cy;
                                    cx = p * cx;
                                    rw = p * rw;
                                    rh = p * rh;
                                }
                                canvas.width = cw;
                                canvas.height = ch;
                                ctx.rotate(deg * Math.PI / 180);
                                ctx.drawImage(image, cx, cy, rw, rh);
                                dataUrl = canvas.toDataURL('image/' + fileExtension);
                                resizedImage = self.dataURLToBlob(dataUrl);
                                resizedImage.name = file.name;
                                callback(resizedImage);
                            } else {
                                callback(file);
                            }
                        } else {
                            callback(file);
                        }
                    });
                };
                image.src = readerEvent.target.result;
            };
            reader.readAsDataURL(file);
        }
    };

    /**
     * Creates and returns a blob from a data URL (either base64 encoded or not).
     *
     * @param {string} dataUrl The data URL to convert.
     * @return {Blob} A blob representing the array buffer data.
     */
    this.dataURLToBlob = function (dataUrl) {
        var BASE64_MARKER = ";base64,";
        var parts;
        var contentType;
        var raw;
        var rawLength;
        var uInt8Array;
        var blob;

        if (dataUrl.indexOf(BASE64_MARKER) == -1) {
            parts = dataUrl.split(",");
            contentType = parts[0].split(":")[1];
            raw = decodeURIComponent(parts[1]);

            return new Blob([raw], {type: contentType});
        }

        parts = dataUrl.split(BASE64_MARKER);
        contentType = parts[0].split(":")[1];
        raw = window.atob(parts[1]);
        rawLength = raw.length;

        uInt8Array = new Uint8Array(rawLength);

        for (var i = 0; i < rawLength; ++i) {
            uInt8Array[i] = raw.charCodeAt(i);
        }

        blob = new Blob([uInt8Array], {type: contentType});
        return blob;
    }
});