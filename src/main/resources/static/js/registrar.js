// Call the dataTables jQuery plugin
$(document).ready(function() {
    // on ready
});


async function registrarUsuarios() {

    let datos = {};
    datos.nombre = document.getElementById('txtNombre').value;
    datos.apellido = document.getElementById('txtApellido').value;
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;

    let repetirPassword = document.getElementById('txtRepeatPassword').value;

    if(repetirPassword != datos.password){
        alert("La contraseña es Diferente")
        return;
    }

    const request = await fetch('api/usuarios', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    alert("la cuenta fue creada con exito")
    window.location.href = 'login.html'
}
