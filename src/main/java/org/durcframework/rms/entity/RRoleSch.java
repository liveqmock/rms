package org.durcframework.rms.entity;

import org.durcframework.expression.annotation.LikeDoubleField;
import org.durcframework.expression.annotation.ValueField;
import org.durcframework.rms.common.SearchEasyUI;

public class RRoleSch extends SearchEasyUI{

    private Integer roleIdSch;
    private String roleNameSch;

    public void setRoleIdSch(Integer roleIdSch){
        this.roleIdSch = roleIdSch;
    }
    
    @ValueField(column = "role_id")
    public Integer getRoleIdSch(){
        return this.roleIdSch;
    }

    public void setRoleNameSch(String roleNameSch){
        this.roleNameSch = roleNameSch;
    }
    
    @LikeDoubleField(column = "role_name")
    public String getRoleNameSch(){
        return this.roleNameSch;
    }


}