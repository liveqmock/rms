package org.durcframework.rms.entity;

import java.util.ArrayList;
import java.util.List;

import org.durcframework.rms.common.TreeAware;

import com.alibaba.fastjson.annotation.JSONField;

public class RSysRes implements TreeAware{
	private int srId;
	private int parentId;
	private String resName;
	private String url;

	private List<RSysRes> children = new ArrayList<RSysRes>();

	public void setSrId(int srId) {
		this.srId = srId;
	}

	public int getSrId() {
		return this.srId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getParentId() {
		return this.parentId;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getResName() {
		return this.resName;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
	}

	@JSONField(name = "_parentId")
	public int getEesyUIParentId() {
		return parentId;
	}

	public List<RSysRes> getChildren() {
		return children;
	}

	public void setChildren(List<RSysRes> children) {
		this.children = children;
	}

	@Override
	public int getId() {
		return this.srId;
	}

	@Override
	public String getText() {
		return resName;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		return this.srId == ((RSysRes)obj).srId;
	}

}