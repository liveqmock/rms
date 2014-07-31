package org.durcframework.rms.service;

import org.durcframework.rms.dao.RDataPermissionDao;
import org.durcframework.rms.entity.RDataPermission;
import org.durcframework.service.CrudService;
import org.springframework.stereotype.Service;

@Service
public class RDataPermissionService extends CrudService<RDataPermission, RDataPermissionDao> {

	
	public void delBySfId(int sfId){
		this.getDao().delBySfId(sfId);
	}
	
}
