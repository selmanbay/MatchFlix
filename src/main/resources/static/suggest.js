const input = document.getElementById('movieTitle');
const suggestionsBox = document.getElementById('suggestions');

input.addEventListener('input', async () => {
    const query = input.value.trim();
    if (query.length < 2) {
        suggestionsBox.style.display = 'none';
        return;
    }

    const response = await fetch(`/suggest?query=${query}`);
    const suggestions = await response.json();

    if (suggestions.length === 0) {
        suggestionsBox.style.display = 'none';
        return;
    }

    suggestionsBox.innerHTML = suggestions.map(item => `<div>${item}</div>`).join('');
    suggestionsBox.style.display = 'block';

    document.querySelectorAll('.suggestions div').forEach(div => {
        div.addEventListener('click', () => {
            input.value = div.textContent;
            suggestionsBox.style.display = 'none';
        });
    });
});
