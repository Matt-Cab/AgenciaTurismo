const listaServicios = document.querySelectorAll("[type='checkbox']");
const btnSubmit = document.querySelector(".submitBtn");
const modal = document.querySelector(".custom-modal-container");
const btnCloseModal = document.querySelector(".custom-modal__btn-close");

const allServicesUnchecked = servicesList => {
    for (let i = 0; i < servicesList.length; i++) {
        if (servicesList[i].checked) {
            return false;
        }
    }
    return true;
};

const amountOfServicesChecked = servicesList => {
    let counter = 0;
    for (let i = 0; i < servicesList.length; i++) {
        if (servicesList[i].checked) {
            counter++;
        }
    }
    
    return counter;
};

btnSubmit.addEventListener("click", e => {
    if (allServicesUnchecked(listaServicios) || amountOfServicesChecked(listaServicios) < 2) {
        e.preventDefault();
        modal.classList.add("active");
    }
});

// === Modal logic ===
btnCloseModal.addEventListener("click", () => {
    modal.classList.remove("active");
});
