package org.durcframework.rms.service;

import java.util.List;

import org.durcframework.expression.ExpressionQuery;
import org.durcframework.expression.subexpression.ValueExpression;
import org.durcframework.rms.dao.RSysResDao;
import org.durcframework.rms.entity.RSysRes;
import org.durcframework.rms.util.TreeUtil;
import org.durcframework.service.CrudService;
import org.springframework.stereotype.Service;

@Service
public class RSysResService extends CrudService<RSysRes, RSysResDao> {
	
	/**
	 * 判断是否有子节点
	 * @param sysRes
	 * @return
	 */
	public boolean hasChild(RSysRes sysRes){
		ExpressionQuery query = new ExpressionQuery();
		query.add(new ValueExpression("parent_id", sysRes.getSrId()));
		int count = this.findTotalCount(query);
		
		return count > 0;
	}
	
	/**
	 * 根据用户名获取菜单
	 * @param rolePermissions
	 * @return
	 */
	public List<RSysRes> getUserMenu(String username){
		
		List<RSysRes> list = this.getDao().findUserMenu(username);
		
		list = TreeUtil.buildTreeData(list);
		
		return list;
	}
	
}
