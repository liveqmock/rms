package org.durcframework.rms.service;

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

}
