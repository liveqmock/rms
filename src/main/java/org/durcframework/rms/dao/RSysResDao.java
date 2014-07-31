package org.durcframework.rms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.durcframework.rms.entity.RSysRes;
import org.durcframework.dao.BaseDao;

public interface RSysResDao extends BaseDao<RSysRes> {
	List<RSysRes> findUserMenu(@Param("username") String username);
}