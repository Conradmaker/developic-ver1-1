// // userNo 가져오기
// window.onload = function() {
//     document.querySelector("#editUserNo").value = 10;
// }

// 파일 선택하는 버튼
const fileBtn = document.querySelector("#fileBtn");
const hiddenBtn = document.querySelector("#hiddenFileBtn"); // 파일 선택하는 input
const fileLabel = document.querySelector("#fileLabel");     // 경로 나타나는 label
const fileImg = document.querySelector("#fileImage");
    
fileBtn.addEventListener("click", () => {
    hiddenBtn.click();
    hiddenBtn.addEventListener("change", (e) => {

        var startIndex = (e.target.value.indexOf('\\') >= 0 ? e.target.value.lastIndexOf('\\') : e.target.value.lastIndexOf('/'));
        var filename = e.target.value.substring(startIndex);
        if (filename.indexOf('\\') === 0 || filename.indexOf('/') === 0) {
            filename = filename.substring(1);
        }

        // console.log("변화!");
        fileLabel.innerHTML = filename;
        document.querySelector("#hiddenFileSrc").value = filename;

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

//   document.querySelector(".tui-editor-contents")

  const watcher = () => {
      setInterval(() => {
            document.querySelector("#editorHidden").value = document.querySelector(".tui-editor-contents").innerHTML;
            console.log(document.querySelector("#editorHidden").value);
      }, 3000);
  }

  //   document.querySelector("#editorHidden").value = e.target.innerHTML;
  //   console.log(e.target.innerHTML);
  
  
  // 판매여부 토글버튼
  const saleBtn = document.querySelector("#buy-saleBtn");
  saleBtn.addEventListener("click", () => {
      // console.log("클릭");
      saleBtn.classList.toggle("saleSelectN");
      // console.log(saleBtn);
      
    if(!saleBtn.classList.contains("saleSeletN")){
        document.querySelector(".buy--photoPrice").toggleAttribute("hidden");       // 판매가능. 가격 설정할수 있게
        document.querySelector("#buy--photoSale").value = 1;
        //document.querySelector(".buy--photoPrice").setAttribute("disabled", false);
    }else{
        document.querySelector(".buy--photoPrice").toggleAttribute("hidden");          // 판매하지 않는 상품.
        document.querySelector("#buy--photoSale").value = 0;
        //document.querySelector(".buy--photoPrice").setAttribute("disabled", true);
    }
});
document.querySelector('#picsBtn').addEventListener('click',async()=>{
    const response = await axios.get('/dia/loadpicstory.ph?uno='+document.querySelector('#editUserNo').value);
    
  })

watcher();