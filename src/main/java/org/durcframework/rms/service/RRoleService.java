package org.durcframework.rms.service;

import java.util.List;

import org.durcframework.rms.dao.RRoleDao;
import org.durcframework.rms.entity.RRole;
import org.durcframework.rms.entity.RSysFunction;
import org.durcframework.service.CrudService;
import org.springframework.stereotype.Service;

@Service
public class RRoleService extends CrudService<RRole, RRoleDao> {

	public List<RRole> getRolesBySysFunction(RSysFunction sysFunction){
		return this.getDao().findRoleByFunction(sysFunction.getSfId());
	}
	
	/**
	 * 根据用户查询其拥有的角色
	 * @param username
	 * @return
	 */
	public List<RRole> getRolesByUsername(String username){
		return this.getDao().findRoleByUsername(username);
	}
}
