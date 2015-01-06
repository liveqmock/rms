package org.durcframework.rms.entity;

import org.durcframework.expression.annotation.ValueField;
import org.durcframework.rms.common.SearchEasyUI;

public class RSysOperateSch extends SearchEasyUI{

    private String operateNameSch;
    private String operateCodeSch;

    public void setOperateNameSch(String operateNameSch){
        this.operateNameSch = operateNameSch;
    }
    
    @ValueField(column = "operate_name",equal="like")
    public String getOperateNameSch(){
        return this.operateNameSch;
    }

    @ValueField(column = "operate_code",equal="like")
	public String getOperateCodeSch() {
		return operateCodeSch;
	}

	public void setOperateCodeSch(String operateCodeSch) {
		this.operateCodeSch = operateCodeSch;
	}

}