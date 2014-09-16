package org.durcframework.rms.service;

import java.util.List;

import org.durcframework.expression.ExpressionQuery;
import org.durcframework.expression.subexpression.ValueExpression;
import org.durcframework.rms.dao.RRolePermissionDao;
import org.durcframework.rms.entity.FunctionRoleParam;
import org.durcframework.rms.entity.RRolePermission;
import org.durcframework.rms.entity.RSysFunction;
import org.durcframework.rms.entity.RoleFunction;
import org.durcframework.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RRolePermissionService extends CrudService<RRolePermission, RRolePermissionDao> {

	@Autowired
	private RDataPermissionService dataPermissionService;
	
	/**
	 * 查询用户的角色权限
	 * @param username
	 * @return
	 */
	public List<RRolePermission> getRolePermissionByUsername(String username){
		return this.getDao().findRolePermissionByFunction(username);
	}
	
	/**
	 * 根据功能查询角色权限
	 * @param function
	 * @return
	 */
	public List<RRolePermission> getRolePermissionByFunction(RSysFunction function){
		ExpressionQuery query = new ExpressionQuery();
		query.add(new ValueExpression("sf_id", function.getSfId()));
		query.setIsQueryAll(true);
		
		return this.find(query);
	}
	
	/**
	 * 设置系统功能权限
	 * @param sfId
	 * @param roleIds
	 */
	public void setSysFunctionRole(int sfId,List<Integer> roleIds){
		this.delBySysFunction(sfId); // 先删除之前的
		
		FunctionRoleParam param = new FunctionRoleParam();
		param.setRoleIds(roleIds);
		param.setSfId(sfId);
		
		this.getDao().setFunctionRole(param);
		
	}
	
	public void delBySysFunction(int sfId){
		this.getDao().delBySfId(sfId);
	}
	
	@Override
	public void del(RRolePermission entity) {
		dataPermissionService.delBySfId(entity.getSfId());
		
		this.getDao().delBySfId(entity.getSfId());
	}
	
	public List<RoleFunction> getRoleFunctionInfo(int roleId){
		return this.getDao().findRoleFunc(roleId);
	}
	
	public void delByRoleId(int roleId){
		this.getDao().delByRoleId(roleId);
	}
}
