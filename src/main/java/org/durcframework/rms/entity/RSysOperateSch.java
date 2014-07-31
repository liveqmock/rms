package org.durcframework.rms.entity;

import org.durcframework.expression.annotation.ValueField;
import org.durcframework.rms.common.SearchEasyUI;

public class RSysOperateSch extends SearchEasyUI{

    private String operateNameSch;
    private String operateCodeSch;

    public void setOperateNameSch(String operateNameSch){
        this.operateNameSch = operateNameSch;
    }
    
    @ValueField(column = "operate_name")
    public String getOperateNameSch(){
        return this.operateNameSch;
    }

	public String getOperateCodeSch() {
		return operateCodeSch;
	}

	@ValueField(column = "operate_code")
	public void setOperateCodeSch(String operateCodeSch) {
		this.operateCodeSch = operateCodeSch;
	}

}