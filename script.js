//Aqui temos Gemini e ChatGPT purinho, eu não sou de ferro 😔

document.addEventListener('DOMContentLoaded', function() {
    // Efeito de digitação (TypeWriter)
    const digitandoElement = document.getElementById('digitando');
    const textos = ["Olá, eu sou o Yuri Braz", "Desenvolvedor Front-end", "E Designer de Jogos"];
    let textoIndex = 0;
    let charIndex = 0;
    let isDeleting = false;
    let typingSpeed = 150;
    let deletingSpeed = 100;
    let delayBetweenTexts = 1500;

    function typeWriter() {
        if (!digitandoElement) return; // Garante que o elemento existe antes de tentar manipulá-lo

        const currentText = textos[textoIndex];
        if (isDeleting) {
            digitandoElement.textContent = currentText.substring(0, charIndex - 1);
            charIndex--;
        } else {
            digitandoElement.textContent = currentText.substring(0, charIndex + 1);
            charIndex++;
        }

        let currentTypingSpeed = isDeleting ? deletingSpeed : typingSpeed;

        if (!isDeleting && charIndex === currentText.length) {
            currentTypingSpeed = delayBetweenTexts;
            isDeleting = true;
        } else if (isDeleting && charIndex === 0) {
            isDeleting = false;
            textoIndex = (textoIndex + 1) % textos.length;
            currentTypingSpeed = 500; // Pequeno delay antes de começar a digitar o próximo texto
        }

        setTimeout(typeWriter, currentTypingSpeed);
    }

    // Inicia o efeito de digitação se o elemento existir
    if (digitandoElement) {
        typeWriter();
    }


    // Código para o menu hambúrguer
    const burger = document.querySelector('.burger');
    const navLinks = document.querySelector('.nav_links');

    if (burger && navLinks) {
        burger.addEventListener('click', () => {
            navLinks.classList.toggle('active');
            burger.classList.toggle('active');
        });
    }

    // Opcional: Fechar o menu ao clicar em um link
    // Verifica se navLinks existe antes de tentar chamar querySelectorAll
    if (navLinks) {
        navLinks.querySelectorAll('a').forEach(link => {
            link.addEventListener('click', () => {
                if (navLinks.classList.contains('active')) {
                    navLinks.classList.remove('active');
                    // Verifica se burger existe antes de tentar remover a classe
                    if (burger) {
                        burger.classList.remove('active');
                    }
                }
            });
        });
    }

    // Lógica do Carrossel
    const slides = document.querySelectorAll('.slide');
    const btnAnterior = document.querySelector('.anterior');
    const btnProximo = document.querySelector('.proximo');
    let slideAtual = 0;
    let intervaloCarrossel; // Variável para armazenar o ID do intervalo

    function mostrarSlide(index) {
        slides.forEach((slide, i) => {
            slide.classList.remove('slide_active');
            if (i === index) {
                slide.classList.add('slide_active');
            }
        });
    }

    // Função para avançar o slide automaticamente
    function proximoSlideAutomatico() {
        slideAtual = (slideAtual + 1) % slides.length;
        mostrarSlide(slideAtual);
    }

    // Adiciona evento de click aos botões do carrossel
    if (btnProximo) {
        btnProximo.addEventListener('click', () => {
            clearInterval(intervaloCarrossel); // Limpa o intervalo ao clicar no botão
            proximoSlideAutomatico(); // Avança um slide manualmente
            // Reinicia o intervalo após um pequeno atraso para que a animação tenha tempo
            intervaloCarrossel = setInterval(proximoSlideAutomatico, 5000);
        });
    }

    if (btnAnterior) {
        btnAnterior.addEventListener('click', () => {
            clearInterval(intervaloCarrossel); // Limpa o intervalo ao clicar no botão
            slideAtual = (slideAtual - 1 + slides.length) % slides.length;
            mostrarSlide(slideAtual); // Volta um slide manualmente
            // Reinicia o intervalo
            intervaloCarrossel = setInterval(proximoSlideAutomatico, 5000);
        });
    }

    // Inicializa o carrossel mostrando o primeiro slide se houver slides
    if (slides.length > 0) {
        mostrarSlide(slideAtual);
    }

    // Inicia a transição automática a cada 5 segundos (5000 milissegundos)
    // Só inicia se houver mais de um slide para transição e os botões existirem
    if (slides.length > 1 && btnAnterior && btnProximo) {
        intervaloCarrossel = setInterval(proximoSlideAutomatico, 5000);
    }


    // Lógica para copiar o Discord
    const btnDiscordCopy = document.getElementById('btn-discord-copy');
    if (btnDiscordCopy) {
        btnDiscordCopy.addEventListener('click', (event) => {
            event.preventDefault(); // Impede o comportamento padrão do link
            const discordID = 'yuraodopastel'; // ID do seu Discord
            navigator.clipboard.writeText(discordID).then(() => {
                alert(`ID do Discord "${discordID}" copiado para a área de transferência!`);
            }).catch(err => {
                console.error('Falha ao copiar o ID do Discord: ', err);
                alert('Não foi possível copiar o ID do Discord. Tente novamente ou me chame no Instagram!');
            });
        });
    }
});