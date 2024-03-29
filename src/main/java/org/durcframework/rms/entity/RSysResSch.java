package org.durcframework.rms.entity;

import org.durcframework.expression.annotation.ValueField;
import org.durcframework.rms.common.SearchEasyUI;

public class RSysResSch extends SearchEasyUI{

    private Integer srIdSch;
    private Integer parentIdSch;
    private String resNameSch;
    private String urlSch;

    public void setSrIdSch(Integer srIdSch){
        this.srIdSch = srIdSch;
    }
    
    @ValueField(column = "sr_id")
    public Integer getSrIdSch(){
        return this.srIdSch;
    }

    public void setParentIdSch(Integer parentIdSch){
        this.parentIdSch = parentIdSch;
    }
    
    @ValueField(column = "parent_id")
    public Integer getParentIdSch(){
        return this.parentIdSch;
    }

    public void setResNameSch(String resNameSch){
        this.resNameSch = resNameSch;
    }
    
    @ValueField(column = "res_name")
    public String getResNameSch(){
        return this.resNameSch;
    }

    public void setUrlSch(String urlSch){
        this.urlSch = urlSch;
    }
    
    @ValueField(column = "url")
    public String getUrlSch(){
        return this.urlSch;
    }


}