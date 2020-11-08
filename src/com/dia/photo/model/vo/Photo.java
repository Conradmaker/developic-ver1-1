package com.dia.photo.model.vo;

import oracle.sql.CLOB;
import oracle.sql.DATE;

public class Photo {
	
	private int photoId;
	private String photoName;
	private int photoSale;
	private int photoPrice;
	private DATE photoCreatedAt;
	private int photoState;
	private String photoSrc;
	private String photoInfo;
	private DATE photoUpdateAt;
	private int userNo;
	private int categoryId;
	
	public Photo() {
		
	}

	public Photo(int photoId, String photoName, int photoSale, int photoPrice, DATE photoCreatedAt, int photoState,
			String photoSrc, String photoInfo, DATE photoUpdateAt, int userNo, int categoryId) {
		super();
		this.photoId = photoId;
		this.photoName = photoName;
		this.photoSale = photoSale;
		this.photoPrice = photoPrice;
		this.photoCreatedAt = photoCreatedAt;
		this.photoState = photoState;
		this.photoSrc = photoSrc;
		this.photoInfo = photoInfo;
		this.photoUpdateAt = photoUpdateAt;
		this.userNo = userNo;
		this.categoryId = categoryId;
	}

	public int getPhotoId() {
		return photoId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public int getPhotoSale() {
		return photoSale;
	}

	public void setPhotoSale(int photoSale) {
		this.photoSale = photoSale;
	}

	public int getPhotoPrice() {
		return photoPrice;
	}

	public void setPhotoPrice(int photoPrice) {
		this.photoPrice = photoPrice;
	}

	public DATE getPhotoCreatedAt() {
		return photoCreatedAt;
	}

	public void setPhotoCreatedAt(DATE photoCreatedAt) {
		this.photoCreatedAt = photoCreatedAt;
	}

	public int getPhotoState() {
		return photoState;
	}

	public void setPhotoState(int photoState) {
		this.photoState = photoState;
	}

	public String getPhotoSrc() {
		return photoSrc;
	}

	public void setPhotoSrc(String photoSrc) {
		this.photoSrc = photoSrc;
	}

	public String getPhotoInfo() {
		return photoInfo;
	}

	public void setPhotoInfo(String photoInfo) {
		this.photoInfo = photoInfo;
	}

	public DATE getPhotoUpdateAt() {
		return photoUpdateAt;
	}

	public void setPhotoUpdateAt(DATE photoUpdateAt) {
		this.photoUpdateAt = photoUpdateAt;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Photos [photoId=" + photoId + ", photoName=" + photoName + ", photoSale=" + photoSale + ", photoPrice="
				+ photoPrice + ", photoCreatedAt=" + photoCreatedAt + ", photoState=" + photoState + ", photoSrc="
				+ photoSrc + ", photoInfo=" + photoInfo + ", photoUpdateAt=" + photoUpdateAt + ", userNo=" + userNo
				+ ", categoryId=" + categoryId + "]";
	}

}
