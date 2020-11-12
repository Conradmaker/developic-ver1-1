package com.dia.profile.model.vo;

import java.sql.Date;

public class Picstorys {
	
	private int picstoryId;
	private String picstoryName;
	private Date picstoryCreatedAt;
	private int userNo;
	private int photoId;
	private String photoSrc;
	
	public Picstorys() {
		
	}

	public Picstorys(int photoId, String photoSrc) {
		super();
		this.photoId = photoId;
		this.photoSrc = photoSrc;
	}



	public Picstorys(int picstoryId, String picstoryName, Date picstoryCreatedAt, int userNo) {
		super();
		this.picstoryId = picstoryId;
		this.picstoryName = picstoryName;
		this.picstoryCreatedAt = picstoryCreatedAt;
		this.userNo = userNo;
	}

	public Picstorys(int picstoryId, String picstoryName, Date picstoryCreatedAt, int userNo, int photoId,
			String photoSrc) {
		super();
		this.picstoryId = picstoryId;
		this.picstoryName = picstoryName;
		this.picstoryCreatedAt = picstoryCreatedAt;
		this.userNo = userNo;
		this.photoId = photoId;
		this.photoSrc = photoSrc;
	}

	public int getPicstoryId() {
		return picstoryId;
	}

	public void setPicstoryId(int picstoryId) {
		this.picstoryId = picstoryId;
	}

	public String getPicstoryName() {
		return picstoryName;
	}

	public void setPicstoryName(String picstoryName) {
		this.picstoryName = picstoryName;
	}

	public Date getPicstoryCreatedAt() {
		return picstoryCreatedAt;
	}

	public void setPicstoryCreatedAt(Date picstoryCreatedAt) {
		this.picstoryCreatedAt = picstoryCreatedAt;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getPhotoId() {
		return photoId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	public String getPhotoSrc() {
		return photoSrc;
	}

	public void setPhotoSrc(String photoSrc) {
		this.photoSrc = photoSrc;
	}

	@Override
	public String toString() {
		return "Picstorys [picstoryId=" + picstoryId + ", picstoryName=" + picstoryName + ", picstoryCreatedAt="
				+ picstoryCreatedAt + ", userNo=" + userNo + ", photoId=" + photoId + ", photoSrc=" + photoSrc + "]";
	}	

}
