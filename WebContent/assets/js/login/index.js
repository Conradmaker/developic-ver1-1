const signInBtn = document.getElementById("signIn");
const signUpBtn = document.getElementById("signUp");
const fistForm = document.getElementById("form1");
const secondForm = document.getElementById("form2");
const container = document.querySelector(".container");


document.querySelector('#signIn').addEventListener("click", () => {
  container.classList.remove("right-panel-active");
});

document.querySelector('#signUp').addEventListener("click", () => {
  container.classList.add("right-panel-active");
});
