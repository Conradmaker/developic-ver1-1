package com.dia.cs.model.vo;

import java.sql.Date;

public class Qna {

	private int queId;
	private String queTitle;
	private String queContent;
	private Date queCreatedAt;
	private String ausContent;
	private Date ausCreatedAt;
	private int quserNo;
	private int auserNo;
	
	
	public Qna() {}
	
	public Qna(int queId, String queTitle, String queContent, Date queCreatedAt, String ausContent, Date ausCreatedAt,
			int quserNo, int auserNo) {
		super();
		this.queId = queId;
		this.queTitle = queTitle;
		this.queContent = queContent;
		this.queCreatedAt = queCreatedAt;
		this.ausContent = ausContent;
		this.ausCreatedAt = ausCreatedAt;
		this.quserNo = quserNo;
		this.auserNo = auserNo;
	}

	 
	
	public Qna(int queId, String queTitle, Date queCreatedAt, Date ausCreatedAt, int quserNo, int auserNo) {
		super();
		this.queId = queId;
		this.queTitle = queTitle;
		this.queCreatedAt = queCreatedAt;
		this.ausCreatedAt = ausCreatedAt;
		this.quserNo = quserNo;
		this.auserNo = auserNo;
	}



	public Qna(String queTitle, String queContent, int quserNo) {
		super();
		this.queTitle = queTitle;
		this.queContent = queContent;
		this.quserNo = quserNo;
	}



	public int getQueId() {
		return queId;
	}


	public void setQueId(int queId) {
		this.queId = queId;
	}


	public String getQueTitle() {
		return queTitle;
	}


	public void setQueTitle(String queTitle) {
		this.queTitle = queTitle;
	}


	public String getQueContent() {
		return queContent;
	}


	public void setQueContent(String queContent) {
		this.queContent = queContent;
	}


	public Date getQueCreatedAt() {
		return queCreatedAt;
	}


	public void setQueCreatedAt(Date queCreatedAt) {
		this.queCreatedAt = queCreatedAt;
	}


	public String getAusContent() {
		return ausContent;
	}


	public void setAusContent(String ausContent) {
		this.ausContent = ausContent;
	}


	public Date getAusCreatedAt() {
		return ausCreatedAt;
	}


	public void setAusCreatedAt(Date ausCreatedAt) {
		this.ausCreatedAt = ausCreatedAt;
	}


	public int getQuserNo() {
		return quserNo;
	}


	public void setQuserNo(int quserNo) {
		this.quserNo = quserNo;
	}


	public int getAuserNo() {
		return auserNo;
	}


	public void setAuserNo(int auserNo) {
		this.auserNo = auserNo;
	}


	@Override
	public String toString() {
		return "Qna [queId=" + queId + ", queTitle=" + queTitle + ", queContent=" + queContent + ", queCreatedAt="
				+ queCreatedAt + ", ausContent=" + ausContent + ", ausCreatedAt=" + ausCreatedAt + ", quserNo="
				+ quserNo + ", auserNo=" + auserNo + "]";
	}
	
	
	
}
