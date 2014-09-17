package org.durcframework.rms.service;

import java.util.List;

import org.durcframework.expression.ExpressionQuery;
import org.durcframework.expression.subexpression.ValueExpression;
import org.durcframework.rms.dao.RRolePermissionDao;
import org.durcframework.rms.entity.FunctionRoleParam;
import org.durcframework.rms.entity.RRolePermission;
import org.durcframework.rms.entity.RSysFunction;
import org.durcframework.service.CrudService;
import org.springframework.stereotype.Service;

@Service
public class RRolePermissionService extends CrudService<RRolePermission, RRolePermissionDao> {

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
		this.delBySfId(sfId); // 先删除之前的
		
		FunctionRoleParam param = new FunctionRoleParam();
		param.setRoleIds(roleIds);
		param.setSfId(sfId);
		
		this.getDao().setFunctionRole(param);
		
	}
	
	public void delBySfId(int sfId){
		this.getDao().delBySfId(sfId);
	}
	
	public void delByRoleId(int roleId){
		this.getDao().delByRoleId(roleId);
	}
	
}
