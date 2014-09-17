package org.durcframework.rms.dao;

import org.apache.ibatis.annotations.Param;
import org.durcframework.dao.BaseDao;
import org.durcframework.rms.entity.FunctionRoleParam;
import org.durcframework.rms.entity.RRolePermission;

public interface RRolePermissionDao extends BaseDao<RRolePermission> {
	void delBySfId(@Param("sfId") int sfId);
	void delByRoleId(@Param("roleId") int roleId);
	void setFunctionRole(FunctionRoleParam functionRoleParam);
}