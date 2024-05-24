function LoadData() {
    $.ajax({
        url: `${API_USUARIO}`,
        type: 'GET',
        dataType: 'json',
        success: function (result) {
            let html = "";
            $.each(result, function (index, item) {
                html += `<tr>
                    <td>${item.correo}</td>
                    <td>${item.contrasenia}</td>                    
                    <td>${item.personaId.nombre}</td>
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
        url: `${API_USUARIO}/${id}`,
        type: 'GET',
        dataType: 'json',
        success: function (result) {
            $('#id').val(result.id);
            $('#correo').val(result.correo);
            $('#contrasenia').val(result.contrasenia);            
            $('#personaId').val(result.personaId.id);
            $('.save-btn').attr('onclick', 'Update()');
        },
        error: function (xhr, status, error) {
            console.error('Error en la solicitud:', status, error);
            showError();
            Clear();
        }
    });
}

function DataForm() {
    const carro = {
        correo: $('#correo').val(),
        contrasenia: $('#contrasenia').val(),
        personaId: {
            "id": $('#personaId').val()
        }
    };
    return carro;
}

function Save() {
    const carro = DataForm();    
    $.ajax({
        url: API_USUARIO,
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(carro),
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

function Update() {
    const carro = DataForm();
    carro.id = $('#id').val();

    $.ajax({
        url: `${API_USUARIO}/${carro.id}`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(carro),
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

function Delete(id) {
    showDeleteConfirmation(function(confirm) {
        if (confirm) {
            $.ajax({
                url: `${API_USUARIO}/${id}`,
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

function Clear() {
    $('#id').val('');
    $('#marca').val('');
    $('#modelo').val('');
    $('#placa').val('');
    $('#color').val('');
    $('#categoriaId').val('');
}
