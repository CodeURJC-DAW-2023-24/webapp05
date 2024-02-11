function previewImages(input) {
    var previewContainer = $("#photo-container");

    if (input.files) {
      var filesAmount = input.files.length;

      for (i = 0; i < filesAmount; i++) {
        var reader = new FileReader();
        var file = input.files[i];

        if (file.type.match('image.*')) {

          reader.onload = function (e) {
            var image = $('<img src="' + e.target.result + '" alt="Image Preview" class="preview-image">');
            image.click(function () {
              $(this).remove();
              $('#add-photo-container').show();
            });
            previewContainer.append(image);
          };

          reader.readAsDataURL(file);
          $('#add-photo-container').hide();
        } else {
          alert('Por favor, selecciona solo archivos de imagen.');
        }
      }
    }
  }