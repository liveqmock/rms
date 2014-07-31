package org.durcframework.rms.entity;

import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.durcframework.entity.IUser;
import org.durcframework.entity.ValidateAware;

public class RUser implements IUser, ValidateAware {
	@Pattern(regexp = "\\w+", message = "用户名只能由数字,字母,下划线组成")
	@Size(min = 4, max = 20, message = "用户名长度范围在4-20之间")
	private String username;
	@Size(min = 6, max = 200, message = "密码长度范围在6-200之间")
	private String password;
	private Date addTime = new Date();
	private Date lastLoginDate;

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return this.username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getAddTime() {
		return this.addTime;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Date getLastLoginDate() {
		return this.lastLoginDate;
	}

}