// const thumbnail = document.querySelector("#detailThumbnail");
const imageWrapper = document.querySelector(".detail--imageWrapper");
console.log(imageWrapper);
// const image = new Image();
const image = document.createElement("img");

const naviBar = document.querySelector("#detail--naviBar");
function naviScroll() {
  console.log("스크롤바뀜!");
}

function paintImg() {
  console.log(image.width);
  console.log(image.height);

  // toggle : 클래스가 있는지 체크하고 --> 있으면 remove / 없으면 add
  if (image.width >= image.height) {
    // 가로가 세로보다 긴 사진일때
    image.classList.remove("detail--imageYx");
    image.classList.add("detail--imageXy");
  } else {
    // 세로가 가로보다 긴 사진일때
    image.classList.remove("detail--imageXy");
    image.classList.add("detail--imageYx");
  }
  console.log(image);
  imageWrapper.appendChild(image);
}

function bringImg() {
  image.src = "../../assets/images/logo.png";
  // image.onload = function
}

function init() {
  bringImg();
  paintImg();
}
init();
