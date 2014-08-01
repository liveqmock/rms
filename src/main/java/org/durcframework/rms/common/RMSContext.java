package org.durcframework.rms.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.durcframework.common.SpringContext;
import org.durcframework.common.UserContext;
import org.durcframework.rms.entity.RSysFunction;
import org.durcframework.rms.entity.RUser;
import org.durcframework.rms.service.RSysFunctionService;
import org.springframework.util.StringUtils;

public enum RMSContext {
	INS;

	private static Map<String,List<RSysFunction>> userSysFunctionMap = new HashMap<String,List<RSysFunction>>();

	public static RMSContext getInstance() {
		return INS;
	}

	
	/**
	 * 获取当前用户系统功能
	 * @return
	 */
	public List<RSysFunction> getCurrentUserSysFunction() {
		RUser user = UserContext.getInstance().getUser();
		return userSysFunctionMap.get(user.getUsername());
	}
	
	
	/**
	 * 刷新保存用权限数据.(系统功能=菜单+操作点)
	 */
	public void refreshUserRightData(String username){
		RSysFunctionService sysFunctionService = SpringContext.getBean(RSysFunctionService.class);
		
		List<RSysFunction> userSysFuns = sysFunctionService.getUserSysFunction(username);
		
		userSysFunctionMap.put(username, userSysFuns);
	}
	
	/**
	 * 刷新所有用户的系统功能
	 */
	public void refreshAllUserRightData(){
		Set<String> usernameSet = userSysFunctionMap.keySet();
		for (String username : usernameSet) {
			this.refreshUserRightData(username);
		}
	}
	
	/**
	 * 移除用户权限数据,在用户注销或session失效可以用到
	 * @param username
	 */
	public void clearUserRightData(String username){
		if(StringUtils.isEmpty(username)){
			return;
		}
		userSysFunctionMap.remove(username);
	}
	
	/**
	 * 移除当前用户权限数据
	 */
	public void clearCurrentUserRightData(){
		RUser user = UserContext.getInstance().getUser();
		if(user != null){
			this.clearUserRightData(user.getUsername());
		}
	}
}
