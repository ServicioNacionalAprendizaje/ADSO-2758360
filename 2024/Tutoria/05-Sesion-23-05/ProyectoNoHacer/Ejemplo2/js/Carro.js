function LoadData() {
    $.ajax({
        url: `${API_CARRO}`,
        type: 'GET',
        dataType: 'json',
        success: function (result) {
            let html = "";
            $.each(result, function (index, item) {
                html += `<tr>
                    <td>${item.marca}</td>
                    <td>${item.modelo}</td>
                    <td>${item.placa}</td>
                    <td>${item.color}</td>
                    <td>${item.categoriaId.id}</td>
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
        url: `${API_CARRO}/${id}`,
        type: 'GET',
        dataType: 'json',
        success: function (result) {
            $('#id').val(result.id);
            $('#marca').val(result.marca);
            $('#modelo').val(result.modelo);
            $('#placa').val(result.placa);
            $('#color').val(result.color);
            $('#categoriaId').val(result.categoriaId.id);
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
        marca: $('#marca').val(),
        modelo: $('#modelo').val(),
        placa: $('#placa').val(),
        color: $('#color').val(),
        categoriaId: {
            "id": $('#categoriaId').val()
        }
    };
    return carro;
}

function Save() {
    const carro = DataForm();    
    $.ajax({
        url: API_CARRO,
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
        url: `${API_CARRO}/${carro.id}`,
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
                url: `${API_CARRO}/${id}`,
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
