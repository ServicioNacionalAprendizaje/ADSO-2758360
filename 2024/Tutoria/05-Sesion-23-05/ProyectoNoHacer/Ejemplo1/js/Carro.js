const Carro = {
    loadData: function() {
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
                        <td>${item.categoriaId.nombre}</td>
                        <td>
                            <button class="btn btn-primary" onclick="Carro.findById(${item.id})">Editar</button>
                            <button class="btn btn-danger" onclick="Carro.delete(${item.id})">Eliminar</button>
                        </td>
                    </tr>`;
                });
                $('#dataListCarro').html(html);
                $('#actualizar-btn-carro').hide();
            },
            error: function (xhr, status, error) {
                console.error('Error en la solicitud:', status, error);
                showError();
                Carro.clear();
            }
        });
    },

    findById: function(id) {
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
                $('#actualizar-btn-carro').show();
                $('#guardar-btn-carro').hide();
            },
            error: function (xhr, status, error) {
                console.error('Error en la solicitud:', status, error);
                showError();
                Carro.clear();
            }
        });
    },

    save: function() {
        const carro = Carro.dataForm();    
        $.ajax({
            url: API_CARRO,
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(carro),
            success: function (result) {
                showSaveSuccess();
                Carro.loadData();
                Carro.clear();
            },
            error: function (xhr, status, error) {
                console.error('Error en la solicitud:', status, error);            
                showSaveError();
                Carro.clear();
            }
        });
    },

    update: function() {
        const carro = Carro.dataForm();
        carro.id = $('#id').val();

        $.ajax({
            url: `${API_CARRO}/${carro.id}`,
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(carro),
            success: function (result) {
                showUpdateSuccess();
                Carro.loadData();
                Carro.clear();
                $('#guardar-btn-carro').show();
            },
            error: function (xhr, status, error) {
                console.error('Error en la solicitud:', status, error);
                showUpdateError();
                Carro.clear();
            }
        });
    },

    delete: function(id) {
        showDeleteConfirmation(function(confirm) {
            if (confirm) {
                $.ajax({
                    url: `${API_CARRO}/${id}`,
                    type: 'DELETE',
                    success: function (result) {
                        showDeleteSuccess();
                        Carro.loadData();
                        Carro.clear();
                    },
                    error: function (xhr, status, error) {
                        console.error('Error en la solicitud:', status, error);
                        Carro.clear();
                        showDeleteError();
                    }
                });
            }
        });
    },

    dataForm: function() {
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
    },

    clear: function() {
        $('#id').val('');
        $('#marca').val('');
        $('#modelo').val('');
        $('#placa').val('');
        $('#color').val('');
        $('#categoriaId').val('');
    }
};
