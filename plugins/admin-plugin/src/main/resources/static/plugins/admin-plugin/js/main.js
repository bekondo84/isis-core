// Script de test pour le plugin Admin
document.addEventListener("DOMContentLoaded", function() {
    console.log("[Admin-Plugin] Le fichier JavaScript a été chargé avec succès !");

    const bouton = document.getElementById("btn-test");
    if (bouton) {
        bouton.addEventListener("click", function() {
            alert("Yo ! Le JavaScript du plugin fonctionne et interagit avec le DOM ! 🚀");
        });
    }
});