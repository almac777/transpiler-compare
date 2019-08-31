function loadData() {
    $.ajax({
        url: 'http://localhost:8080/api/hello-world',
        success: function(result) {
            $('#data-area').text(JSON.stringify(result));
        },
        error: function(error) {
            console.error(error);
        }
    });
}
