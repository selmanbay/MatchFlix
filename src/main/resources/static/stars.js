const canvas = document.getElementById("stars");
const ctx = canvas.getContext("2d");

function resizeCanvas() {
    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;
}
resizeCanvas();

window.addEventListener("resize", resizeCanvas);

// Yıldız sayısını azalt (150 → 80 daha akıcı olur)
let stars = [];
const numStars = 30;

for (let i = 0; i < numStars; i++) {
    stars.push({
        x: Math.random() * canvas.width,
        y: Math.random() * canvas.height,
        size: Math.random() * 1.8 + 0.5, // daha küçük
        speed: Math.random() * 0.4 + 0.2
    });
}

function drawStars() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);

    // Tek seferlik stil ayarı (her frame yapma → performans)
    ctx.fillStyle = "white";
    ctx.shadowBlur = 4; // 10 yerine 4
    ctx.shadowColor = "rgba(255,255,255,0.6)";

    for (let star of stars) {
        ctx.beginPath();
        ctx.arc(star.x, star.y, star.size, 0, Math.PI * 2);
        ctx.fill();

        star.y += star.speed;
        if (star.y > canvas.height) {
            star.y = 0;
            star.x = Math.random() * canvas.width;
        }
    }

    requestAnimationFrame(drawStars);
}

drawStars();