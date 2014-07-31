package org.durcframework.rms.entity;

public class RSysOperate {
	private String operateCode;
	private String operateName;

	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}

	public String getOperateName() {
		return this.operateName;
	}

	public String getOperateCode() {
		return operateCode;
	}

	public void setOperateCode(String operateCode) {
		this.operateCode = operateCode;
	}

}