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
