const campoSeleccionado = document.querySelector("#campoSeleccionado");
const tablaServicios = document.querySelector("#tablaServicios");
const tablaPaquetes = document.querySelector("#tablaPaquetes");
const servicios = document.querySelectorAll(".inputRadioServicio");
const paquetes = document.querySelectorAll(".inputRadioPaquete");

 if (noCheckedInput(servicios)) {
     servicios[0].checked = true;
 }

if (document.querySelector("#paquete").checked) {
    tablaServicios.classList.add("tablaOculta");
    tablaPaquetes.classList.remove("tablaOculta");
}
else {
    tablaPaquetes.classList.add("tablaOculta");
    tablaServicios.classList.remove("tablaOculta");
}

campoSeleccionado.addEventListener("click", e => {
    const targetId = e.target.id;

    if (targetId === "servicio") {
        tablaServicios.classList.remove("tablaOculta");
        tablaPaquetes.classList.add("tablaOculta");
        if (noCheckedInput(servicios)) {
            servicios[0].checked = true;
        }
    } else if (targetId === "paquete") {
        tablaPaquetes.classList.remove("tablaOculta");
        tablaServicios.classList.add("tablaOculta");
        if (noCheckedInput(paquetes)) {
            paquetes[0].checked = true;
        }
    }

});

function noCheckedInput(inputs) {
    for (let i = 0; i < inputs.length; i++) {
        if (inputs[i].checked) {
            return false;
        }
    }
    return true;
}