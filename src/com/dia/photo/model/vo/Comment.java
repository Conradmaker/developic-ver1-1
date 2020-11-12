package com.dia.photo.model.vo;

import java.sql.Date;

public class Comment {
	private int commentId;
	private String commentContent;
    private Date commentCreatedAt;
    private Date commentUpdatedAt;
    private int userNo;
    private String userName;
    private String userNickname;
    private int PhotoId;
    
    public Comment() {
    	
    }
    
	public Comment(int commentId, String commentContent, Date commentCreatedAt, Date commentUpdatedAt, int userNo,
			String userName, String userNickname, int photoId) {
		super();
		this.commentId = commentId;
		this.commentContent = commentContent;
		this.commentCreatedAt = commentCreatedAt;
		this.commentUpdatedAt = commentUpdatedAt;
		this.userNo = userNo;
		this.userName = userName;
		this.userNickname = userNickname;
		PhotoId = photoId;
	}

	
	public Comment(String commentContent) {
		super();
		this.commentContent = commentContent;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentCreatedAt() {
		return commentCreatedAt;
	}

	public void setCommentCreatedAt(Date commentCreatedAt) {
		this.commentCreatedAt = commentCreatedAt;
	}

	public Date getCommentUpdatedAt() {
		return commentUpdatedAt;
	}

	public void setCommentUpdatedAt(Date commentUpdatedAt) {
		this.commentUpdatedAt = commentUpdatedAt;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public int getPhotoId() {
		return PhotoId;
	}

	public void setPhotoId(int photoId) {
		PhotoId = photoId;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentContent=" + commentContent + ", commentCreatedAt="
				+ commentCreatedAt + ", commentUpdatedAt=" + commentUpdatedAt + ", userNo=" + userNo + ", userName="
				+ userName + ", userNickname=" + userNickname + ", PhotoId=" + PhotoId + "]";
	}
	
}
