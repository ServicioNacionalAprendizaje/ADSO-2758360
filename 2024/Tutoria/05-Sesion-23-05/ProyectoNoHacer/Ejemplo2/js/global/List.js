// Cargar los datos de las categorías
function ListCategoria() {
    $.ajax({
        url: `${API_CATEGORIA}`,
        type: 'GET',
        dataType: 'json',
        success: function(result) {
            let html = "";
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

// Cargar los datos de las personas
function ListPersona() {
    $.ajax({
        url: `${API_PERSONA}`,
        type: 'GET',
        dataType: 'json',
        success: function(result) {
            let html = "<option value='' selected disabled>Seleccione una persona</option>";
            $.each(result, function(index, item) {
                html += `<option value="${item.id}">${item.nombre}</option>`;
            });
            $('#personaId').html(html);
        },
        error: function(xhr, status, error) {
            console.error('Error en la solicitud:', status, error);
        }
    });
}