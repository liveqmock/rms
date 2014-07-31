package org.durcframework.rms.controller;

import org.durcframework.controller.SearchController;
import org.durcframework.rms.entity.RUserRole;
import org.durcframework.rms.entity.RUserSch;
import org.durcframework.rms.entity.UserRoleParam;
import org.durcframework.rms.service.RUserRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RUserRoleController extends
		SearchController<RUserRole, RUserRoleService> {

	/**
	 * 获取用户所有角色
	 * @param searchEntity
	 * @return
	 */
	@RequestMapping("/listUserRRole.do")
	public ModelAndView listUserRRole(RUserSch searchEntity) {
		return this.queryAll(searchEntity.buildExpressionQuery());
	}
	
	@RequestMapping("/setUserRole.do")
	public ModelAndView setUserRole(UserRoleParam userRoleParam) {
		this.getService().setUserRole(userRoleParam);
		return success();
	}
}
