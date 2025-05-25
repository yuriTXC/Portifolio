//Código provisório para o menu (que não deu certo)
const burger = document.querySelector(".burger");
const navLinks = document.querySelector(".nav_links");

burger.addEventListener("click", () => {
    navLinks.classList.toggle("active");
});

