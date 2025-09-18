// Navbar scroll effect
window.addEventListener("scroll", function () {
  let navbar = document.querySelector(".navbar");
  navbar.classList.toggle("scrolled", window.scrollY > 50);
});

// Contact form (demo alert)
document.getElementById("contactForm").addEventListener("submit", function(e) {
  e.preventDefault();
  alert("✅ Thank you for contacting Meena's Kitchen! We'll get back to you soon.");
  this.reset();
});
