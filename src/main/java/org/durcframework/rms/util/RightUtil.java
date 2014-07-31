package org.durcframework.rms.util;

import java.util.List;

import org.durcframework.rms.common.RMSContext;
import org.durcframework.rms.entity.RSysFunction;
import org.springframework.util.StringUtils;

/**
 * 权限检查工具类
 *
 */
public class RightUtil {

	/**
	 * 根据资源ID和操作代码检查是否具有权限
	 * 
	 * @param srId SysRec表主键
	 * @param operateCode SysOperate表主键
	 * @return 返回true权限存在
	 */
	public static boolean check(String srId, String operateCode) {
		
		if(StringUtils.isEmpty(srId) || StringUtils.isEmpty(operateCode)){
			return false;
		}

		int srid = Integer.valueOf(srId);
		
		List<RSysFunction> userSysFunctions = RMSContext.getInstance().getCurrentUserSysFunction();
		
		for (RSysFunction sysFun : userSysFunctions) {
			if(sysFun.getSrId() == srid && operateCode.equals(sysFun.getOperateCode())){
				return true;
			}
		}

		return false;
	}
}
