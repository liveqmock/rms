package org.durcframework.rms.service;

import java.util.List;

import org.durcframework.expression.ExpressionQuery;
import org.durcframework.expression.subexpression.ValueExpression;
import org.durcframework.rms.dao.RSysFunctionDao;
import org.durcframework.rms.entity.RSysFunction;
import org.durcframework.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RSysFunctionService extends CrudService<RSysFunction, RSysFunctionDao> {
	
	@Autowired
	private RRolePermissionService rolePermissionService;
	
	/**
	 * 删除系统功能
	 */
	@Override
	public void del(RSysFunction sysFunction) {
		// 先删除角色
		rolePermissionService.delBySfId(sysFunction.getSfId());
		
		this.getDao().del(sysFunction);
	}
	
	/**
	 * 获取用户系统功能
	 * @param username
	 * @return
	 */
	public List<RSysFunction> getUserSysFunction(String username){
		return this.getDao().findUserSysFunction(username);
	}
	
	public List<RSysFunction> getByOperateCode(String operateCode){
		ExpressionQuery query = ExpressionQuery.buildQueryAll();
    	query.add(new ValueExpression("operate_code", operateCode));
    	
    	return find(query);
	}
	
	/**
	 * 根据资源ID删除系统功能
	 * @param srId
	 */
	public void delBySrId(int srId){
		List<RSysFunction> sysFuncs = getBySrId(srId);
		for (RSysFunction rSysFunction : sysFuncs) {
			del(rSysFunction);
		}
	}
	
	private List<RSysFunction> getBySrId(int srId){
		ExpressionQuery query = ExpressionQuery.buildQueryAll();
    	query.add(new ValueExpression("sr_id", srId));
    	
    	return find(query);
	}
}
