package com.dia.photo.model.vo;

import java.sql.Date;

public class Picstory {
	private int PicstoryId;
	private String PicstoryName;
    private Date PicstoryCreatedAt;
    private int UserNo;
    
    public void Picstroy() {
    	
    }

	public Picstory(int picstoryId, String picstoryName, Date picstoryCreatedAt, int userNo) {
		super();
		PicstoryId = picstoryId;
		PicstoryName = picstoryName;
		PicstoryCreatedAt = picstoryCreatedAt;
		UserNo = userNo;
	}

	public int getPicstoryId() {
		return PicstoryId;
	}

	public void setPicstoryId(int picstoryId) {
		PicstoryId = picstoryId;
	}

	public String getPicstoryName() {
		return PicstoryName;
	}

	public void setPicstoryName(String picstoryName) {
		PicstoryName = picstoryName;
	}

	public Date getPicstoryCreatedAt() {
		return PicstoryCreatedAt;
	}

	public void setPicstoryCreatedAt(Date picstoryCreatedAt) {
		PicstoryCreatedAt = picstoryCreatedAt;
	}

	public int getUserNo() {
		return UserNo;
	}

	public void setUserNo(int userNo) {
		UserNo = userNo;
	}

	@Override
	public String toString() {
		return "Picstory [PicstoryId=" + PicstoryId + ", PicstoryName=" + PicstoryName + ", PicstoryCreatedAt="
				+ PicstoryCreatedAt + ", UserNo=" + UserNo + "]";
	}
    
    
}
