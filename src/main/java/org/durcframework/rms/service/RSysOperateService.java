package org.durcframework.rms.service;

import java.util.List;

import org.durcframework.expression.ExpressionQuery;
import org.durcframework.rms.dao.RSysOperateDao;
import org.durcframework.rms.entity.RSysOperate;
import org.durcframework.service.CrudService;
import org.springframework.stereotype.Service;

@Service
public class RSysOperateService extends CrudService<RSysOperate, RSysOperateDao> {
	
	public List<RSysOperate> listAllSysOperate(){
		ExpressionQuery query = new ExpressionQuery();
		query.setIsQueryAll(true);
		return this.find(query);
	}
	
}
