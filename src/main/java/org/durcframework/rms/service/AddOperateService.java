package org.durcframework.rms.service;

import java.util.List;

import org.durcframework.exception.DurcException;
import org.durcframework.rms.dao.RRolePermissionDao;
import org.durcframework.rms.dao.RSysFunctionDao;
import org.durcframework.rms.entity.RRolePermission;
import org.durcframework.rms.entity.RSysFunction;
import org.durcframework.rms.entity.RSysOperate;
import org.durcframework.rms.entity.RSysRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 添加操作点
 * @author hc.tang
 *
 */
@Service
public class AddOperateService {
	@Autowired
	private RSysFunctionDao functionDao;
	@Autowired
	private RRolePermissionDao permissionDao;
	
	/**
	 * 添加操作权限
	 * 1. 添加功能
	 * 2. 添加权限
	 * @param res 资源
	 * @param operate 操作类型
	 * @param roleIds 角色
	 */
	public void add(RSysRes res,RSysOperate operate,List<Integer> roleIds){
		int sfId = this.addFunction(res,operate);
		
		addRolePermission(sfId,roleIds);
	}
	
	
	// 添加系统功能,返回保存后的主键值
	private int addFunction(RSysRes res,RSysOperate operate){
		RSysFunction function = new RSysFunction();
		
		function.setOperateCode(operate.getOperateCode());
		function.setSrId(res.getSrId());
		
		function.setFuncName(
				res.getResName() + "." 
				+ operate.getOperateName() 
				+ "("+operate.getOperateCode()+")");
		
		
		RSysFunction storeFun = functionDao.get(function);
		
		if(storeFun != null){
			throw new DurcException("添加失败 - [" + function.getFuncName() + "]记录已存在.");
		}
		
		functionDao.save(function);
		
		return function.getSfId();
	}
	
	// 添加角色权限
	private void addRolePermission(int sfId,List<Integer> roleIds){
		RRolePermission rolePermission = null;
		for (Integer roleId : roleIds) {
			rolePermission = new RRolePermission();
			rolePermission.setRoleId(roleId);
			rolePermission.setSfId(sfId);
			permissionDao.save(rolePermission);
		}
	}
	
}
