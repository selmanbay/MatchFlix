document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("filmForm");
    const titleInput = document.getElementById("filmTitle");
    const genreInput = document.getElementById("filmGenre");
    const filmCards = document.querySelectorAll(".category-section:first-of-type .film-card");

    form.addEventListener("submit", (e) => {
        e.preventDefault();

        const filmTitle = titleInput.value.trim();
        const filmGenre = genreInput.value.trim();

        if (filmTitle && filmGenre) {
            // İlk boş kartı bul
            for (let card of filmCards) {
                if (!card.classList.contains("filled")) {
                    card.textContent = `${filmTitle} (${filmGenre})`;
                    card.classList.add("filled");
                    break;
                }
            }

            // inputları temizle
            titleInput.value = "";
            genreInput.value = "";
        }
    });
});
