const listaServicios = document.querySelectorAll("[name='servicioSeleccionado']");
const btnSubmit = document.querySelector(".submitBtn");
const modal = document.querySelector(".custom-modal-container");
const btnCloseModal = document.querySelector(".custom-modal__btn-close");

const paqueteEsValido = inputs => {
    let contadorAux = 0;
    
    inputs.forEach(input => {
        if (input.checked) {
            contadorAux++;
        }
    });

    return contadorAux >= 2;
}

btnSubmit.addEventListener("click", e => {
    if (!paqueteEsValido(listaServicios)) {
        e.preventDefault();
        modal.classList.add("active");
    }
});

// === Modal logic ===
btnCloseModal.addEventListener("click", () => {
    modal.classList.remove("active");
});
