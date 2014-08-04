package org.durcframework.rms.service;

import java.util.List;

import org.durcframework.rms.dao.RSysFunctionDao;
import org.durcframework.rms.entity.RRolePermission;
import org.durcframework.rms.entity.RSysFunction;
import org.durcframework.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RSysFunctionService extends CrudService<RSysFunction, RSysFunctionDao> {
	
	@Autowired
	private RRolePermissionService rolePermissionService;
	
	@Override
	public void del(RSysFunction sysFunction) {
		RRolePermission rolePermission = new RRolePermission();
		rolePermission.setSfId(sysFunction.getSfId());
		// 先删除角色
		rolePermissionService.del(rolePermission);
		
		this.getDao().del(sysFunction);
	}
	
	/**
	 * 通过资源ID和操作代码查询
	 * @param srId
	 * @param operateCode
	 * @return
	 */
	public RSysFunction getBySrIdOperateCode(int srId,String operateCode) {
		RSysFunction function = new RSysFunction();
		function.setSrId(srId);
		function.setOperateCode(operateCode);
		
		return this.getDao().findBySrIdOperateCode(function);
	}
	
			
	/**
	 * 获取用户系统功能
	 * @param username
	 * @return
	 */
	public List<RSysFunction> getUserSysFunction(String username){
		return this.getDao().findUserSysFunction(username);
	}
}
