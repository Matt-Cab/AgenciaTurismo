const modal = document.querySelector(".custom-modal-container");
const btnCloseModal = document.querySelector(".custom-modal__btn-close");

const error = document.querySelector("input[type='hidden']");

if (error) {
    modal.classList.add("active");
}

// === Modal logic ===
btnCloseModal.addEventListener("click", () => {
    modal.classList.remove("active");
});