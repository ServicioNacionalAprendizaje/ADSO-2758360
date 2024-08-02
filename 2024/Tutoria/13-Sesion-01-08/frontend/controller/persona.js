function LoadData(){
    $.ajax({
        url: 'http://localhost:9090/v1/api/persona',
        type: 'GET',
        success: function(response) {
            var html = '';
            response.forEach(function(persona) {
                html += '<tr>' +
                        '<td>' + persona.nombre + '</td>' +
                        '<td>' + persona.celular + '</td>' +
                        '<td>' + persona.correo + '</td>' +
                        '<td>' + persona.direccion + '</td>' +
                        '<td>' + (persona.estado == true ? 'Activo':'Inactivo') + '</td>' +
                        '<td>' + persona.edad + '</td>' +
                        '<td><button id="guardar" class="btn btn-primary">Editar</button></td>' +
                        '<td><button id="guardar" class="btn btn-danger">Eliminar</button></td>' +
                        '</tr>';
            });
            $('#loadData').html(html);
        },
        error: function(error) {
            console.log('Error:', error);
        }
    });
}