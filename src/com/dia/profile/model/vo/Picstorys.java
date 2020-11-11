package com.dia.profile.model.vo;

import java.sql.Date;

public class Picstorys {
	
	private int picstoryId;
	private String picstoryName;
	private Date picstoryCreatedAt;
	private int userNo;
	
	public Picstorys() {
		
	}

	public Picstorys(int picstoryId, String picstoryName, Date picstoryCreatedAt, int userNo) {
		super();
		this.picstoryId = picstoryId;
		this.picstoryName = picstoryName;
		this.picstoryCreatedAt = picstoryCreatedAt;
		this.userNo = userNo;
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

	@Override
	public String toString() {
		return "Picstorys [picstoryId=" + picstoryId + ", picstoryName=" + picstoryName + ", picstoryCreatedAt="
				+ picstoryCreatedAt + ", userNo=" + userNo + "]";
	}

}
