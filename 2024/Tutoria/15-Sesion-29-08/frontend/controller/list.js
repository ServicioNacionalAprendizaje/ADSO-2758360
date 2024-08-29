function LoadList(){
    $.ajax({
        url: 'http://localhost:9090/v1/api/persona',
        type: 'GET',
        success: function(response) {
            var html = '<option selected>Seleccione</option>';
            response.forEach(function(persona) {
                html += `
                        <option value="`+persona.id+`">`+persona.nombre+`</option>`;
            });
            $('#personaId').html(html);
        },
        error: function(error) {
            console.log('Error:', error);
        }
    });
}

function ReporteUsuario(){
    $.ajax({
        url: 'http://localhost:9090/v1/api/usuario',
        type: 'GET',
        success: function(response) {
            var html = '';
            response.forEach(function(usuario) {
                html += `
                        <tr>
                            <td>`+usuario.personaId.nombre+`</td>
                            <td>`+usuario.personaId.correo+`</td>
                            <td>`+usuario.personaId.celular+`</td>                            
                            <td>`+usuario.usuario+`</td>
                            <td>******</td>
                        </tr>`;
            });
            $('#ListadoPersona').html(html);
        },
        error: function(error) {
            console.log('Error:', error);
        }
    });
}