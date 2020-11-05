package com.dia.user.model.vo;

import java.sql.Date;
public class Users {
		private String user_id;
	    private String user_email;
	    private String user_password;
	    private String user_name;
	    private String user_nickname;
	    private String user_phone;
	    private String user_address;
	    private String user_sns;
	    private String user_info;
	    private String user_avatar_src;
	    private Date user_lastLogin;
	    private Date user_createAt;
	    private int user_role;
	   
	    public Users() {
	    	
	    }
	    
	    public Users(String user_id,String user_password, String user_name, String user_nickname, String user_phone, String user_address,String user_sns, String user_info,String user_avatar_src, Date user_lastLogin, Date user_createAt,int user_role) {
	    	this.user_id = user_id;
	    	this.user_password = user_password;
	    	this.user_name = user_name;
	    	this.user_nickname = user_nickname;
	    	this.user_phone = user_phone;
	    	this.user_address = user_address;
	    	this.user_sns = user_sns;
	    	this.user_info = user_info;
	    	this.user_avatar_src = user_avatar_src;
	    	this.user_lastLogin = user_lastLogin;
	    	this.user_createAt = user_createAt;
	    	this.user_role = user_role;
	    	
	    }
	    public Users(String user_id,String user_password, String user_name,String user_email) {
	    	this.user_id =user_id;
	    	this.user_password = user_password;
	    	this.user_name = user_name;
	    	this.user_email = user_email;
	    	
	    }
		public Users(String user_id, String user_name, String user_phone, String user_email, String user_address) {
			this.user_id =user_id;
	    	this.user_name = user_name;
	    	this.user_phone = user_phone;
	    	this.user_email = user_email;
	    	this.user_address = user_address;
		}

		public String getUser_id() {
			return user_id;
		}
		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}
		public String getUser_email() {
			return user_email;
		}
		public void setUser_email(String user_email) {
			this.user_email = user_email;
		}
		public String getUser_password() {
			return user_password;
		}
		public void setUser_password(String user_password) {
			this.user_password = user_password;
		}
		public String getUser_name() {
			return user_name;
		}
		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}
		public String getUser_nickname() {
			return user_nickname;
		}
		public void setUser_nickname(String user_nickname) {
			this.user_nickname = user_nickname;
		}
		public String getUser_phone() {
			return user_phone;
		}
		public void setUser_phone(String user_phone) {
			this.user_phone = user_phone;
		}
		public String getUser_address() {
			return user_address;
		}
		public void setUser_address(String user_address) {
			this.user_address = user_address;
		}
		public String getUser_sns() {
			return user_sns;
		}
		public void setUser_sns(String user_sns) {
			this.user_sns = user_sns;
		}
		public String getUser_info() {
			return user_info;
		}
		public void setUser_info(String user_info) {
			this.user_info = user_info;
		}
		public String getUser_avatar_src() {
			return user_avatar_src;
		}
		public void setUser_avatar_src(String user_avatar_src) {
			this.user_avatar_src = user_avatar_src;
		}
		public Date getUser_lastLogin() {
			return user_lastLogin;
		}
		public void setUser_lastLogin(Date user_lastLogin) {
			this.user_lastLogin = user_lastLogin;
		}
		public Date getUser_createAt() {
			return user_createAt;
		}
		public void setUser_createAt(Date user_createAt) {
			this.user_createAt = user_createAt;
		}
		public int getUser_role() {
			return user_role;
		}
		public void setUser_role(int user_role) {
			this.user_role = user_role;
		}
		@Override
		public String toString() {
			return "Users [user_id=" + user_id + ", user_email=" + user_email + ", user_password=" + user_password
					+ ", user_name=" + user_name + ", user_nickname=" + user_nickname + ", user_phone=" + user_phone
					+ ", user_address=" + user_address + ", user_sns=" + user_sns + ", user_info=" + user_info
					+ ", user_avatar_src=" + user_avatar_src + ", user_lastLogin=" + user_lastLogin + ", user_createAt="
					+ user_createAt + ", user_role=" + user_role + "]";
		}
	    
}
