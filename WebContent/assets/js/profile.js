// user이미지를 동그라미에 꽉차게 하자!
const userImg = document.querySelector("#pro--userImg");

if (userImg.clientWidth > userImg.clientHeight) {
    userImg.classList.remove("pro--userImgY");
    userImg.classList.add("pro--userImgX");
}


// ALLPOST PICSTORY --> tab클릭
const allBtn = document.querySelector("#pro--allBtn");
const picBtn = document.querySelector("#pro--picBtn");

allBtn.addEventListener("click", () => {
    allBtn.classList.add("pro--tab-select");
    picBtn.classList.remove("pro--tab-select");
    console.log("all 클릭됨");
});
picBtn.addEventListener("click", () => {
    allBtn.classList.remove("pro--tab-select");
    picBtn.classList.add("pro--tab-select");    
    console.log("pic 클릭됨");
});


// PICSTORY 회전버튼 클릭
const changeBtn = document.querySelector("#pro-changeBtn");
const picstory = document.querySelector("#pro--picstory");

changeBtn.addEventListener("click", () => {
    // console.log("클릭됨");
    picstory.classList.toggle("pro--fourC"); // .pro--twoC : 가로가 길게(한줄에 두개)(기본)
                                              // .pro--fourC : 세로가 길게(한줄에 네개)

});



