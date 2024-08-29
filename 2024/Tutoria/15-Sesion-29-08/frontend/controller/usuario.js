function LoadData(){
    $.ajax({
        url: 'http://localhost:9090/v1/api/usuario',
        type: 'GET',
        success: function(response) {
            var html = '';
            response.forEach(function(usuario) {
                html += `
                    <tr>
                        <td> `+usuario.usuario+` </td> 
                        <td> `+ usuario.contrasenia +` </td>
                        <td> `+ usuario.personaId.nombre +` </td>                        
                        <td><button id="guardar" class="btn btn-primary" onclick="FindById(`+usuario.id+`)">Editar</button></td>
                        <td><button id="guardar" class="btn btn-danger" onclick="DeleteById(`+usuario.id+`)">Eliminar</button></td>
                    </tr>`;
            });
            $('#loadData').html(html);
        },
        error: function(error) {
            console.log('Error:', error);
        }
    });
}


function FindById(id){
    $.ajax({
        url: 'http://localhost:9090/v1/api/usuario/'+id,
        type: 'GET',
        success: function(response) {
            $('#id').val(response.id);
            $('#usuario').val(response.usuario);
            $('#contrasenia').val(response.contrasenia);
            $('#personaId').val(response.personaId.id);
                    
            $('#guardar').attr('onclick', 'Update()');
            $('#guardar').text('Actualizar');
        },
        error: function(error) {
            console.log('Error:', error);
        }
    });
}
function Save(){
    $.ajax({
        url: 'http://localhost:9090/v1/api/usuario',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            usuario: $("#usuario").val(),
            contrasenia: $("#contrasenia").val(),
            personaId: {
                id: parseInt($("#personaId").val())
            }
        }),
        success: function(response) {
                  
            ClearData();
            LoadData();
        },
        error: function(error) {
            console.log('Error:', error);
        }
    });    
}

function Update(){
    $.ajax({
        url: 'http://localhost:9090/v1/api/usuario/' + $("#id").val(),
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify({
            id: parseInt($("#id").val()),
            usuario: $("#usuario").val(),
            contrasenia: $("#contrasenia").val(),
            personaId: {
                id: parseInt($("#personaId").val())
            }
        }),
        success: function(response) {
                  
            ClearData();
            LoadData();
        },
        error: function(error) {
            console.log('Error:', error);
        }
    });    
}

function DeleteById(id){
    $.ajax({
        url: 'http://localhost:9090/v1/api/usuario/' + id,
        type: 'DELETE',
        contentType: 'application/json',
        data: JSON.stringify({
            id: parseInt($("#id").val())
        }),
        success: function(response) {
            LoadData();
        },
        error: function(error) {
            console.log('Error:', error);
        }
    });    
}


function ClearData(){
    $('#id').val('');
    $('#usuario').val('');
    $('#contrasenia').val('');
    $('#personaId').val('');
    
    // Cambiar el botón para que use el método Update y mostrar 'Actualizar'
    $('#guardar').attr('onclick', 'Save()');
    $('#guardar').text('Guardar');
}