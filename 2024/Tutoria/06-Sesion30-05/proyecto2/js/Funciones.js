function VerMensaje() {
    alert("Hola Mundo");
    alert("Hola Mundo 2");
}

Sumar = function () {
    var numero1 = document.getElementById("numero1").value;
    var numero2 = document.getElementById("numero2").value;
    let resultado = 0;

    //Realizar suma
    resultado = parseFloat(numero1) + parseFloat(numero2);
    document.getElementById("resultado").value = resultado;
}

function Restar() {
    var numero1 = document.getElementById("numero1").value;
    var numero2 = document.getElementById("numero2").value;
    let resultado = 0;

    //Realizar resta
    resultado = parseFloat(numero1) - parseFloat(numero2);
    document.getElementById("resultadoResta").value = resultado;

}