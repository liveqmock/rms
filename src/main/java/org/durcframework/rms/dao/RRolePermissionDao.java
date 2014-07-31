package org.durcframework.rms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.durcframework.dao.BaseDao;
import org.durcframework.rms.entity.FunctionRoleParam;
import org.durcframework.rms.entity.RRolePermission;

public interface RRolePermissionDao extends BaseDao<RRolePermission> {
	void delBySfId(@Param("sfId") int sfId);
	void setFunctionRole(FunctionRoleParam functionRoleParam);
	List<RRolePermission> findRolePermissionByFunction(@Param("username")String username);
}