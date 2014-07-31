package org.durcframework.rms.dao;

import org.apache.ibatis.annotations.Param;
import org.durcframework.rms.entity.RUserRole;
import org.durcframework.rms.entity.UserRoleParam;
import org.durcframework.dao.BaseDao;

public interface RUserRoleDao extends BaseDao<RUserRole> {
	void delAllUserRole(@Param("username")String username);
	void setUserRole(UserRoleParam userRoleParam);
}