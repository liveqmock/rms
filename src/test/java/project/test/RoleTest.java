package project.test;

import java.util.List;

import org.durcframework.rms.dao.RRoleDao;
import org.durcframework.rms.entity.RRole;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class RoleTest extends TestBase {

	@Autowired
	RRoleDao rRoleDao;
	String username = "jim";

	// 获取用户角色列表
	@Test
	public void testListUserRole() {

		List<RRole> roleList = rRoleDao.findRoleByUsername(username);
		Assert.notEmpty(roleList);

		System.out.println(username + "拥有的角色有:");
		for (RRole role : roleList) {
			System.out.println(role.getRoleName());
		}
	}

}
