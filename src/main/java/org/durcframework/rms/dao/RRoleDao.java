package org.durcframework.rms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.durcframework.dao.BaseDao;
import org.durcframework.rms.entity.RRole;

public interface RRoleDao extends BaseDao<RRole> {
	
	List<RRole> findRoleByFunction(@Param("sfId") int sfId);
}