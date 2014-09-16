package org.durcframework.rms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.durcframework.dao.BaseDao;
import org.durcframework.rms.entity.RSysFunction;

public interface RSysFunctionDao extends BaseDao<RSysFunction> {
	/**
	 * 获取用户系统功能
	 * @param username
	 * @return
	 */
	List<RSysFunction> findUserSysFunction(@Param("username")String username);
}