package org.durcframework.rms.entity;

import org.durcframework.expression.annotation.LikeDoubleField;
import org.durcframework.expression.annotation.ValueField;
import org.durcframework.rms.common.SearchEasyUI;

public class RSysOperateSch extends SearchEasyUI{

    private String operateNameSch;
    private String operateCodeSch;

    public void setOperateNameSch(String operateNameSch){
        this.operateNameSch = operateNameSch;
    }
    
    @LikeDoubleField(column = "operate_name")
    public String getOperateNameSch(){
        return this.operateNameSch;
    }

    @LikeDoubleField(column = "operate_code")
	public String getOperateCodeSch() {
		return operateCodeSch;
	}

	public void setOperateCodeSch(String operateCodeSch) {
		this.operateCodeSch = operateCodeSch;
	}

}