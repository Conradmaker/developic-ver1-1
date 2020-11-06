package com.dia.user.model.vo;

import java.sql.Date;
public class Users {
		private int userNo;
		private String userId;
	    private String userEmail;
	    private String userPwd;
	    private String userName;
	    private String userNickname;
	    private String userPhone;
	    private String userAddress;
	    private String userSns;
	    private String userInfo;
	    private String userAvatarSrc;
	    private Date userLastLogin;
	    private Date userCreateAt;
	    private int userRole;
	   
	    public Users() {
	    	
	    }

		public Users(int userNo, String userId, String userEmail, String userPwd, String userName, String userNickname,
					 String userPhone, String userAddress, String userSns, String userInfo, String userAvatarSrc,
					 Date userLastLogin, Date userCreateAt, int userRole) {
			super();
			this.userNo = userNo;
			this.userId = userId;
			this.userEmail = userEmail;
			this.userPwd = userPwd;
			this.userName = userName;
			this.userNickname = userNickname;
			this.userPhone = userPhone;
			this.userAddress = userAddress;
			this.userSns = userSns;
			this.userInfo = userInfo;
			this.userAvatarSrc = userAvatarSrc;
			this.userLastLogin = userLastLogin;
			this.userCreateAt = userCreateAt;
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

		public String getUserEmail() {
			return userEmail;
		}

		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
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

		public String getUserPhone() {
			return userPhone;
		}

		public void setUserPhone(String userPhone) {
			this.userPhone = userPhone;
		}

		public String getUserAddress() {
			return userAddress;
		}

		public void setUserAddress(String userAddress) {
			this.userAddress = userAddress;
		}

		public String getUserSns() {
			return userSns;
		}

		public void setUserSns(String userSns) {
			this.userSns = userSns;
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

		public Date getUserCreateAt() {
			return userCreateAt;
		}

		public void setUserCreateAt(Date userCreateAt) {
			this.userCreateAt = userCreateAt;
		}

		public int getUserRole() {
			return userRole;
		}

		public void setUserRole(int userRole) {
			this.userRole = userRole;
		}

		@Override
		public String toString() {
			return "Users [userNo=" + userNo + ", userId=" + userId + ", userEmail=" + userEmail + ", userPwd="
					+ userPwd + ", userName=" + userName + ", userNickname=" + userNickname + ", userPhone=" + userPhone
					+ ", userAddress=" + userAddress + ", userSns=" + userSns + ", userInfo=" + userInfo
					+ ", userAvatarSrc=" + userAvatarSrc + ", userLastLogin=" + userLastLogin + ", userCreateAt="
					+ userCreateAt + ", userRole=" + userRole + "]";
		}
		
}