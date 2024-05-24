const Categoria = {
    loadData: function() {
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
                            <button class="btn btn-primary" onclick="Categoria.findById(${item.id})">Editar</button>
                            <button class="btn btn-danger" onclick="Categoria.delete(${item.id})">Eliminar</button>
                        </td>
                    </tr>`;
                });
                $('#dataListCategoria').html(html);
                $('#actualizar-btn-categoria').hide();
            },
            error: function (xhr, status, error) {
                console.error('Error en la solicitud:', status, error);
                showError();
                Categoria.clear();
            }
        });
    },

    findById: function(id) {
        $.ajax({
            url: `${API_CATEGORIA}/${id}`,
            type: 'GET',
            dataType: 'json',
            success: function (result) {
                $('#id').val(result.id);
                $('#nombre').val(result.nombre);
                $('#descripcion').val(result.descripcion);
                $('#actualizar-btn-categoria').show();
                $('#guardar-btn-categoria').hide();
            },
            error: function (xhr, status, error) {
                console.error('Error en la solicitud:', status, error);
                showError();
                Categoria.clear();
            }
        });
    },

    save: function() {
        const categoria = Categoria.dataForm();    
        $.ajax({
            url: API_CATEGORIA,
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(categoria),
            success: function (result) {
                showSaveSuccess();
                Categoria.loadData();
                Categoria.clear();
            },
            error: function (xhr, status, error) {
                console.error('Error en la solicitud:', status, error);            
                showSaveError();
                Categoria.clear();
            }
        });
    },

    update: function() {
        const categoria = Categoria.dataForm();
        categoria.id = $('#id').val();

        $.ajax({
            url: `${API_CATEGORIA}/${categoria.id}`,
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(categoria),
            success: function (result) {
                showUpdateSuccess();
                Categoria.loadData();
                Categoria.clear();
            },
            error: function (xhr, status, error) {
                console.error('Error en la solicitud:', status, error);
                showUpdateError();
                Categoria.clear();
                $('#guardar-btn-categoria').show();
            }
        });
    },

    delete: function(id) {
        showDeleteConfirmation(function(confirm) {
            if (confirm) {
                $.ajax({
                    url: `${API_CATEGORIA}/${id}`,
                    type: 'DELETE',
                    success: function (result) {
                        showDeleteSuccess();
                        Categoria.loadData();
                        Categoria.clear();
                    },
                    error: function (xhr, status, error) {
                        console.error('Error en la solicitud:', status, error);
                        Categoria.clear();
                        showDeleteError();
                        
                    }
                });
            }
        });
    },

    dataForm: function() {
        const categoria = {
            nombre: $('#nombre').val(),
            descripcion: $('#descripcion').val()
        };
        return categoria;
    },

    clear: function() {
        $('#id').val('');
        $('#nombre').val('');
        $('#descripcion').val('');
        $('#categoriaForm').removeData('id');
    }
};
