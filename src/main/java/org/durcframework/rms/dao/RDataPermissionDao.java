package org.durcframework.rms.dao;

import org.apache.ibatis.annotations.Param;
import org.durcframework.rms.entity.RDataPermission;
import org.durcframework.dao.BaseDao;

public interface RDataPermissionDao extends BaseDao<RDataPermission> {
	void delBySfId(@Param("sfId") int sfId);
}