package org.durcframework.rms.controller;

import java.util.List;

import org.durcframework.common.UserContext;
import org.durcframework.controller.SearchController;
import org.durcframework.rms.entity.RSysRes;
import org.durcframework.rms.entity.RUser;
import org.durcframework.rms.service.RSysResService;
import org.durcframework.util.JsonUtil;
import org.durcframework.util.ResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController extends SearchController<RSysRes, RSysResService>{
	
	/**
	 * 加载用户菜单
	 * @return
	 */
	@RequestMapping("listUserMenu.do")
	public ModelAndView listUserMenu(){
		RUser user = UserContext.getInstance().getUser();
		
		if(user == null){
			return error("当前用户不存在");
		}
		
		List<RSysRes> list = this.getService().getUserMenu(user.getUsername());
		
		String json = JsonUtil.toJsonString(list);
		
		return ResultUtil.buildModelAndView(json);
	}
	

	
}
