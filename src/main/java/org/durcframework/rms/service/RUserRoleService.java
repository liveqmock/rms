package org.durcframework.rms.service;

import java.util.List;

import org.durcframework.expression.ExpressionQuery;
import org.durcframework.expression.subexpression.ValueExpression;
import org.durcframework.rms.dao.RUserRoleDao;
import org.durcframework.rms.entity.RUserRole;
import org.durcframework.rms.entity.UserRoleParam;
import org.durcframework.service.CrudService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Service
public class RUserRoleService extends CrudService<RUserRole, RUserRoleDao> {

	/**
	 * 设置用户角色
	 */
	public void setUserRole(UserRoleParam userRoleParam) {

		if (StringUtils.isEmpty(userRoleParam.getUsername())
				|| CollectionUtils.isEmpty(userRoleParam.getRoleIds())) {
			return;
		}

		this.getDao().delAllUserRole(userRoleParam.getUsername());

		this.getDao().setUserRole(userRoleParam);
	}
	
	public List<RUserRole> getUserRoleByRoleId(int roleId){
		ExpressionQuery query = ExpressionQuery.buildQueryAll();
		query.add(new ValueExpression("role_id", roleId));
		return this.find(query);
	}
	
	public void delByRoleId(int roleId){
		this.getDao().delByRoleId(roleId);
	}

}
