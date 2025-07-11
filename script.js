const burger = document.querySelector(".burger");
const navLinks = document.querySelector(".nav_links");

burger.addEventListener("click", () => {
    navLinks.classList.toggle("active");
    burger.classList.toggle("active");
});

// Tag Discord
const btnDiscord = document.getElementById('btn-discord-copy');
const discordTag = 'yuraodopastel';

if (btnDiscord) {
    btnDiscord.addEventListener('click', () => {
        navigator.clipboard.writeText(discordTag).then(() => {
            alert('Discord copiado para a área de transferência!');
        }).catch(() => {
            alert('Erro ao copiar o Discord. Tente novamente.');
        });
    });
}

// Efeito de digitação
const texto = "Opa, e aí?";
const elemento = document.getElementById("digitando");

let i = 0;

function escrever() {
    if (elemento && i < texto.length) {
        elemento.innerHTML += texto.charAt(i);
        i++;
        setTimeout(escrever, 100);
    }
}

escrever();

// Carrossel de imagens automático
document.addEventListener("DOMContentLoaded", function () {
    const slides = document.querySelectorAll(".slide");
    const btnAnterior = document.querySelector(".anterior");
    const btnProximo = document.querySelector(".proximo");
    let index = 0;

    function showSlide(i) {
        slides.forEach((slide) => slide.classList.remove("slide_active")); // Corrigi para slide_active
        slides[i].classList.add("slide_active");
    }

    function nextSlide() {
        index = (index + 1) % slides.length;
        showSlide(index);
    }

    function prevSlide() {
        index = (index - 1 + slides.length) % slides.length;
        showSlide(index);
    }

    if (btnProximo && btnAnterior) {
        btnProximo.addEventListener("click", nextSlide);
        btnAnterior.addEventListener("click", prevSlide);
    }

    setInterval(nextSlide, 4000);

    showSlide(index);
});