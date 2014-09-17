package org.durcframework.rms.service;

import java.util.List;

import org.durcframework.rms.dao.RRoleDao;
import org.durcframework.rms.entity.RRole;
import org.durcframework.rms.entity.RSysFunction;
import org.durcframework.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RRoleService extends CrudService<RRole, RRoleDao> {
	
	@Autowired
	private RUserRoleService userRoleService;
	@Autowired
	private RRolePermissionService permissionService;

	/**
	 * 返回系统功能分配的角色
	 * @param sysFunction
	 * @return
	 */
	public List<RRole> getRolesBySysFunction(RSysFunction sysFunction){
		return this.getDao().findRoleByFunction(sysFunction.getSfId());
	}
	
	/**
	 * 删除角色
	 * 先删除管理表信息,再删除自身
	 */
	@Override
	public void del(RRole entity) {
		userRoleService.delByRoleId(entity.getRoleId());
		permissionService.delByRoleId(entity.getRoleId());
		this.getDao().del(entity);
	}
	
}
