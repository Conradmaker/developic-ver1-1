package com.dia.cs.model.vo;

import java.sql.Date;

public class Faqs {

	private int faqId;
	private String faqTitle;
	private String faqContent;
	private Date faqCreateDat;
	private int userNo;
	
	public Faqs() {}

	public Faqs(int faqId, String faqTitle, String faqContent, Date faqCreateDat, int userNo) {
		super();
		this.faqId = faqId;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.faqCreateDat = faqCreateDat;
		this.userNo = userNo;
	}

	

	

	public Faqs(String faqTitle, String faqContent) {
		super();
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
	}

	public int getFaqId() {
		return faqId;
	}

	public void setFaqId(int faqId) {
		this.faqId = faqId;
	}

	public String getFaqTitle() {
		return faqTitle;
	}

	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}

	public String getFaqContent() {
		return faqContent;
	}

	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}

	public Date getFaqCreateDat() {
		return faqCreateDat;
	}

	public void setFaqCreateDat(Date faqCreateDat) {
		this.faqCreateDat = faqCreateDat;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	@Override
	public String toString() {
		return "Faqs [faqId=" + faqId + ", faqTitle=" + faqTitle + ", faqContent=" + faqContent + ", faqCreateDat="
				+ faqCreateDat + ", userNo=" + userNo + "]";
	}
	
	
}
