// Cargar los datos de las categorías
function ListCategoria() {
    $.ajax({
        url: `${API_CATEGORIA}`,
        type: 'GET',
        dataType: 'json',
        success: function(result) {
            let html = `<option value="" disabled selected>Seleccione una categoría</option>`;
            $.each(result, function(index, item) {
                html += `<option value="${item.id}">${item.nombre}</option>`;
            });
            $('#categoriaId').html(html);
        },
        error: function(xhr, status, error) {
            console.error('Error en la solicitud:', status, error);
        }
    });
}