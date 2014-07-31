package org.durcframework.rms.entity;


public class RDataPermission {
    private int doId;
    private int roleId;
    private int sfId;

    public void setDoId(int doId){
        this.doId = doId;
    }

    public int getDoId(){
        return this.doId;
    }

    public void setRoleId(int roleId){
        this.roleId = roleId;
    }

    public int getRoleId(){
        return this.roleId;
    }

    public void setSfId(int sfId){
        this.sfId = sfId;
    }

    public int getSfId(){
        return this.sfId;
    }

}