package org.durcframework.rms.entity;

import java.util.Date;

import org.durcframework.expression.annotation.LikeDoubleField;
import org.durcframework.expression.annotation.ValueField;
import org.durcframework.rms.common.SearchEasyUI;

public class RUserSch extends SearchEasyUI{

    private Integer userIdSch;
    private String usernameSch;
    private String passwordSch;
    private Date addTimeSch;
    private Date lastLoginDateSch;

    public void setUserIdSch(Integer userIdSch){
        this.userIdSch = userIdSch;
    }
    
    @ValueField(column = "user_id")
    public Integer getUserIdSch(){
        return this.userIdSch;
    }

    public void setUsernameSch(String usernameSch){
        this.usernameSch = usernameSch;
    }
    
    @LikeDoubleField(column = "username")
    public String getUsernameSch(){
        return this.usernameSch;
    }

    public void setPasswordSch(String passwordSch){
        this.passwordSch = passwordSch;
    }
    
    @ValueField(column = "password")
    public String getPasswordSch(){
        return this.passwordSch;
    }

    public void setAddTimeSch(Date addTimeSch){
        this.addTimeSch = addTimeSch;
    }
    
    @ValueField(column = "add_time")
    public Date getAddTimeSch(){
        return this.addTimeSch;
    }

    public void setLastLoginDateSch(Date lastLoginDateSch){
        this.lastLoginDateSch = lastLoginDateSch;
    }
    
    @ValueField(column = "last_login_date")
    public Date getLastLoginDateSch(){
        return this.lastLoginDateSch;
    }


}