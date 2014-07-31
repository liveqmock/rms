package project.test;

import java.util.Arrays;
import java.util.List;

import org.durcframework.expression.ExpressionQuery;
import org.durcframework.expression.subexpression.ListExpression;
import org.durcframework.rms.dao.RRoleDao;
import org.durcframework.rms.entity.RRole;
import org.durcframework.rms.entity.RRolePermission;
import org.durcframework.rms.service.RRolePermissionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class RolePermissionTest extends TestBase {

	@Autowired
	RRoleDao rRoleDao;
	@Autowired
	RRolePermissionService rRolePermissionService;
	
	// 查询用户权限
	@Test
	public void testListUserPermission(){
		List<RRole> roleList = rRoleDao.findRoleByUsername("jim");
		
		ExpressionQuery query = new ExpressionQuery();
		
//		query.add(new ListExpression("role_id", roleList, "roleId"));
		query.add(new ListExpression("role_id", Arrays.asList(1)));
		
		List<RRolePermission> rolePermiList = rRolePermissionService.find(query);
		
		Assert.notEmpty(rolePermiList);
	}
	
}
