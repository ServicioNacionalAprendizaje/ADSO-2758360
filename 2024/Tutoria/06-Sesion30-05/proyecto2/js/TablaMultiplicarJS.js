function Ejecutar() {

    //Capturar el dato a multiplicar
    var n = parseInt(document.getElementById('numero').value);

    var resultado = "";

    for(var i = 1; i<=20; i++){
        resultado+=`<tr>
                    <td colspan="2">`+n+` x `+i+` = `+(n*i)+`</td>                
                </tr>`;
    }
    document.getElementById('data').innerHTML = resultado;
}