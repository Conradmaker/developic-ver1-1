const vm = new Vue({
  el: "#app",
  data() {
    return {
      deleteCommentModal: false,
      deleteCartModal: false,
      leaveModal: false,
      deleteLikeModal: false,
    };
  },
  methods: {
    setDeleteCommentModal() {
      this.deleteCommentModal = !this.deleteCommentModal;
    },
    setDeleteCartModal() {
      this.deleteCartModal = !this.deleteCartModal;
    },
    setLeaveModal() {
      this.leaveModal = !this.leaveModal;
    },
    setDeleteLikeModal() {
      this.deleteLikeModal = !this.deleteLikeModal;
    },
  },
});

//개인정보관리
document.querySelector("#img-select").addEventListener("click", () => {
  document.querySelector("#image-input").click();
});
document.querySelector("#image-input").addEventListener("change", (e) => {
  document.querySelector("#image-input-value").innerText = e.target.value;
});
function loadImg(inputFile) {
  if (inputFile.files.length == 1) {
    var reader = new FileReader();
    reader.readAsDataURL(inputFile.files[0]);
    reader.onload = function (e) {
      console.log(e);
      document.querySelector("#title-img").src = e.target.result;
    };
  } else {
    document.querySelector("#title-img").src = null;
  }
}
