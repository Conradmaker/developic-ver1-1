package com.dia.user.model.vo;

import java.sql.Date;
public class User {
		private int userNo;
		private String userId;
	    private String userPwd;
	    private String userName;
	    private String userNickname;
	    private String phone;
	    private String email;
	    private String address;
	    private String sns;
	    private String userInfo;
	    private String userAvatarSrc;
	    private Date userLastLogin;
	    private Date userCreatedAt;
	    private int userRole;
	   
	    
	    public User() {
	    	
	    }

	    
		public User(String userId, String userPwd, String userName, String email) {
			super();
			this.userId = userId;
			this.userPwd = userPwd;
			this.userName = userName;
			this.email = email;
		}

	
		public User(String userId, String userPwd, String userName, String userNickname, String phone, String email,
				String address, String sns, String userInfo, String userAvatarSrc) {
			super();
			this.userId = userId;
			this.userPwd = userPwd;
			this.userName = userName;
			this.userNickname = userNickname;
			this.phone = phone;
			this.email = email;
			this.address = address;
			this.sns = sns;
			this.userInfo = userInfo;
			this.userAvatarSrc = userAvatarSrc;
		}


		public User(int userNo, String userId, String userPwd, String userName, String userNickname, String phone,
				String email, String address, String sns, String userInfo, String userAvatarSrc, Date userLastLogin,
				Date userCreatedAt, int userRole) {
			super();
			this.userNo = userNo;
			this.userId = userId;
			this.userPwd = userPwd;
			this.userName = userName;
			this.userNickname = userNickname;
			this.phone = phone;
			this.email = email;
			this.address = address;
			this.sns = sns;
			this.userInfo = userInfo;
			this.userAvatarSrc = userAvatarSrc;
			this.userLastLogin = userLastLogin;
			this.userCreatedAt = userCreatedAt;
			this.userRole = userRole;
		}


		public int getUserNo() {
			return userNo;
		}


		public void setUserNo(int userNo) {
			this.userNo = userNo;
		}


		public String getUserId() {
			return userId;
		}


		public void setUserId(String userId) {
			this.userId = userId;
		}


		public String getUserPwd() {
			return userPwd;
		}


		public void setUserPwd(String userPwd) {
			this.userPwd = userPwd;
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


		public String getPhone() {
			return phone;
		}


		public void setPhone(String phone) {
			this.phone = phone;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		public String getSns() {
			return sns;
		}


		public void setSns(String sns) {
			this.sns = sns;
		}


		public String getUserInfo() {
			return userInfo;
		}


		public void setUserInfo(String userInfo) {
			this.userInfo = userInfo;
		}


		public String getUserAvatarSrc() {
			return userAvatarSrc;
		}


		public void setUserAvatarSrc(String userAvatarSrc) {
			this.userAvatarSrc = userAvatarSrc;
		}


		public Date getUserLastLogin() {
			return userLastLogin;
		}


		public void setUserLastLogin(Date userLastLogin) {
			this.userLastLogin = userLastLogin;
		}


		public Date getUserCreatedAt() {
			return userCreatedAt;
		}


		public void setUserCreatedAt(Date userCreatedAt) {
			this.userCreatedAt = userCreatedAt;
		}


		public int getUserRole() {
			return userRole;
		}


		public void setUserRole(int userRole) {
			this.userRole = userRole;
		}


		@Override
		public String toString() {
			return "User [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
					+ ", userNickname=" + userNickname + ", phone=" + phone + ", email=" + email + ", address="
					+ address + ", sns=" + sns + ", userInfo=" + userInfo + ", userAvatarSrc=" + userAvatarSrc
					+ ", userLastLogin=" + userLastLogin + ", userCreatedAt=" + userCreatedAt + ", userRole=" + userRole
					+ "]";
		}

	    
		
	    
	    
}