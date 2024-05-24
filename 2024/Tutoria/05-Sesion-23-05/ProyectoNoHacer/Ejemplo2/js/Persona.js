function LoadData() {
    $.ajax({
        url: `${API_PERSONA}`,
        type: 'GET',
        dataType: 'json',
        success: function (result) {
            let html = "";
            $.each(result, function (index, item) {
                html += `<tr>
                    <td>${item.tipoDocumento}</td>
                    <td>${item.documento}</td>
                    <td>${item.nombre}</td>
                    <td>${item.telefono}</td>
                    <td>${item.direccion}</td>
                    <td>
                        <button class="btn btn-primary" onclick="FindById(${item.id})">Editar</button>
                        <button class="btn btn-danger" onclick="Delete(${item.id})">Eliminar</button>
                    </td>
                </tr>`;
            });
            $('#dataList').html(html);
        },
        error: function (xhr, status, error) {
            console.error('Error en la solicitud:', status, error);
            showError();
            Clear();
        }
    });
}

function FindById(id) {
    $.ajax({
        url: `${API_PERSONA}/${id}`,
        type: 'GET',
        dataType: 'json',
        success: function (result) {
            $('#id').val(result.id);
            $('#tipoDocumento').val(result.tipoDocumento);
            $('#documento').val(result.documento);
            $('#nombre').val(result.nombre);
            $('#telefono').val(result.telefono);
            $('#direccion').val(result.direccion);
            $('.save-btn').attr('onclick', 'Update()');
        },
        error: function (xhr, status, error) {
            console.error('Error en la solicitud:', status, error);
            showError();
            Clear();
        }
    });
}

// Actualizar los datos de la entidad
function DataForm() {
    const persona = {
        tipoDocumento: $('#tipoDocumento').val(),
        documento: $('#documento').val(),
        nombre: $('#nombre').val(),
        telefono: $('#telefono').val(),
        direccion: $('#direccion').val()
    };
    return persona;
}

// Guardar los datos de la categoría
function Save() {
    const persona = DataForm();    
    $.ajax({
        url: API_PERSONA,
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(persona),
        success: function (result) {
            showSaveSuccess();
            LoadData();
            Clear();
        },
        error: function (xhr, status, error) {
            console.error('Error en la solicitud:', status, error);            
            showSaveError();
            Clear();
        }
    });
}

// Actualizar los datos de la categoría
function Update() {
    const persona = DataForm();
    persona.id = $('#id').val();

    $.ajax({
        url: `${API_PERSONA}/${persona.id}`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(persona),
        success: function (result) {
            showUpdateSuccess();
            LoadData();
            Clear();
        },
        error: function (xhr, status, error) {
            console.error('Error en la solicitud:', status, error);
            showUpdateError();
            Clear();
        }
    });
}

// Eliminar los datos de la categoría
function Delete(id) {
    showDeleteConfirmation(function(confirm) {
        if (confirm) {
            $.ajax({
                url: `${API_PERSONA}/${id}`,
                type: 'DELETE',
                success: function (result) {
                    showDeleteSuccess();
                    LoadData();
                    Clear();
                },
                error: function (xhr, status, error) {
                    console.error('Error en la solicitud:', status, error);
                    Clear();
                    showDeleteError();
                    
                }
            });
        }
    });
}

// Limpiar los campos de la categoría
function Clear() {
    $('#id').val('');
    $('#tipoDocumento').val('');
    $('#documento').val('');
    $('#nombre').val('');
    $('#telefono').val('');
    $('#direccion').val('');    
}