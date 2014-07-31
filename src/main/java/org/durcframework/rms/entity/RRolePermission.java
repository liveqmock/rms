package org.durcframework.rms.entity;

public class RRolePermission {
	private int roleId;
	private int sfId;

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setSfId(int sfId) {
		this.sfId = sfId;
	}

	public int getSfId() {
		return this.sfId;
	}

}