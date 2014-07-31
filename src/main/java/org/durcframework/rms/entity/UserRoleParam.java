package org.durcframework.rms.entity;

import java.util.List;

public class UserRoleParam {
	private String username;
	private List<Integer> roleIds;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Integer> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Integer> roleIds) {
		this.roleIds = roleIds;
	}

}
