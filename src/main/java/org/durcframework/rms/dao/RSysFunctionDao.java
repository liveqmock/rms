package org.durcframework.rms.dao;

import org.durcframework.rms.entity.RSysFunction;
import org.durcframework.dao.BaseDao;

public interface RSysFunctionDao extends BaseDao<RSysFunction> {
	RSysFunction findBySrIdOperateCode(RSysFunction sysFunction);
}