package com.dia.cs.model.vo;

import java.sql.Date;

public class Notices {

	private int noticeId;
	private String noticeTitle;
	private String noticeContent;
	private Date noticeCreatedAt;
	private Date noticeUpdateAt;
	private int userNo;
	
	public Notices() {}

	public Notices(int noticeId, String noticeTitle, String noticeContent, Date noticeCreatedAt, Date noticeUpdateAt,
			int userNo) {
		super();
		this.noticeId = noticeId;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeCreatedAt = noticeCreatedAt;
		this.noticeUpdateAt = noticeUpdateAt;
		this.userNo = userNo;
	}
	
	
	
	public Notices(String noticeTitle, String noticeContent) {
		super();
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
	}



	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public Date getNoticeCreateDat() {
		return noticeCreatedAt;
	}

	public void setNoticeCreateDat(Date noticeCreatedAt) {
		this.noticeCreatedAt = noticeCreatedAt;
	}

	public Date getNoticeUpdateAt() {
		return noticeUpdateAt;
	}

	public void setNoticeUpdateAt(Date noticeUpdateAt) {
		this.noticeUpdateAt = noticeUpdateAt;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	@Override
	public String toString() {
		return "Notices [noticeId=" + noticeId + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", noticeCreateDat=" + noticeCreatedAt + ", noticeUpdateAt=" + noticeUpdateAt + ", userNo=" + userNo
				+ "]";
	}
	
	
}
