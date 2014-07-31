package project.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

public class UtilsTest extends TestCase {

	@Test
	public void testCollections(){
		List<Object> list = null;
		List<Object> list2 = new ArrayList<Object>();
		
		Assert.isTrue(CollectionUtils.isEmpty(list));
		Assert.isTrue(CollectionUtils.isEmpty(list2));
		Assert.isTrue(CollectionUtils.isEmpty(Arrays.asList()));
	}
	
}
