package org.durcframework.rms.entity;

public class RSysFunction {
	private int sfId;
	private int srId;
	private String operateCode;
	private String funcName;

	public void setSfId(int sfId) {
		this.sfId = sfId;
	}

	public int getSfId() {
		return this.sfId;
	}

	public String getOperateCode() {
		return operateCode;
	}

	public void setOperateCode(String operateCode) {
		this.operateCode = operateCode;
	}

	public void setSrId(int srId) {
		this.srId = srId;
	}

	public int getSrId() {
		return this.srId;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	public String getFuncName() {
		return this.funcName;
	}

}