// 파일 선택하는 버튼
const fileBtn = document.querySelector("#fileBtn");
const hiddenBtn = document.querySelector("#hiddenFileBtn");
const fileLabel = document.querySelector("#fileLabel");
const fileImg = document.querySelector("#fileImage");
    
fileBtn.addEventListener("click", () => {
    hiddenBtn.click();
    hiddenBtn.addEventListener("change", (e) => {
        // console.log("변화!");
        fileLabel.innerHTML = e.target.value;

        if(e.target.files.length == 1){
            const reader = new FileReader();
            
            reader.readAsDataURL(e.target.files[0]);
            reader.onload = (ee) => {
                fileImg.setAttribute("src", ee.target.result);
            };
        }else{
            fileImg.setAttribute("src", null);
        }

        document.querySelector("#fileImage").value = e.target.value;
    });
});

// 에디터 api
document.addEventListener(
    "DOMContentLoaded",
    () => {
     //  console.log("시작");
      var editor = new tui.Editor({
        el: document.querySelector("#editorSection"),
        initialEditType: "markdown",
        previewStyle: "vertical",
        height: "700px"
      });
    }
  );
  
// 판매여부 토글버튼
const saleBtn = document.querySelector("#buy-saleBtn");
saleBtn.addEventListener("click", () => {
    // console.log("클릭");
    saleBtn.classList.toggle("saleSelectN");
    console.log(saleBtn);
});