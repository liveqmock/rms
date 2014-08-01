package org.durcframework.rms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.durcframework.rms.entity.RSysFunction;
import org.durcframework.dao.BaseDao;

public interface RSysFunctionDao extends BaseDao<RSysFunction> {
	RSysFunction findBySrIdOperateCode(RSysFunction sysFunction);
	/**
	 * 获取用户系统功能
	 * @param username
	 * @return
	 */
	List<RSysFunction> findUserSysFunction(@Param("username")String username);
}