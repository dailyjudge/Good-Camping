const menuBtn = document.querySelector("#top-menu-something2-ul");

const menu = document.querySelector("#second-menu-nav");

menuBtn.addEventListener("click", () => {
  menu.classList.toggle("active");
});