function LoadData() {
    $.ajax({
        url: `${API_CATEGORIA}`,
        type: 'GET',
        dataType: 'json',
        success: function (result) {
            let html = "";
            $.each(result, function (index, item) {
                html += `<tr>
                    <td>${item.nombre}</td>
                    <td>${item.descripcion}</td>
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
        url: `${API_CATEGORIA}/${id}`,
        type: 'GET',
        dataType: 'json',
        success: function (result) {
            $('#id').val(result.id);
            $('#nombre').val(result.nombre);
            $('#descripcion').val(result.descripcion);
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
    const categoria = {
        nombre: $('#nombre').val(),
        descripcion: $('#descripcion').val()
    };
    return categoria;
}

// Guardar los datos de la categoría
function Save() {
    const categoria = DataForm();    
    $.ajax({
        url: API_CATEGORIA,
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(categoria),
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
    const categoria = DataForm();
    categoria.id = $('#id').val();

    $.ajax({
        url: `${API_CATEGORIA}/${categoria.id}`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(categoria),
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
                url: `${API_CATEGORIA}/${id}`,
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
    $('#nombre').val('');
    $('#descripcion').val('');
    $('#categoriaForm').removeData('id');
}