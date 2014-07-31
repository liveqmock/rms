package project.test;

import java.util.List;

import org.durcframework.expression.ExpressionQuery;
import org.durcframework.rms.entity.RUser;
import org.durcframework.rms.service.RUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class RUserServiceTest extends TestBase {
	
	@Autowired
	RUserService rUserService;
	
	@Test
	public void testList(){
		List<RUser> list = rUserService.find(new ExpressionQuery());
		Assert.notEmpty(list);
	}

}
