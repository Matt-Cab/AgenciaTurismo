const tableBody = document.querySelector("tbody");

tableBody.addEventListener("click", e => {
    if (e.target.classList.contains("btn-delete")) {
        if (!confirm("Confirmo que deso eliminar el elemento")) {
            e.preventDefault();
        }
    }
})