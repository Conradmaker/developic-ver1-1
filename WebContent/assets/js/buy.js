document.addEventListener(
    "DOMContentLoaded",
    () => {
        console.log("시작");
        const editor = new TouchList.Editor({
            el: document.querySelector("#editorSection"),
            initialEditType: "markdown",
            previewStyle: "vertical",
            height: "600px"
        });
    },
    false
);

window.addEventListener("click", () => {
    console.log("안녕");
});