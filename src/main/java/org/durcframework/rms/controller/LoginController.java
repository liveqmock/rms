package org.durcframework.rms.controller;

import java.util.Date;

import org.durcframework.common.UserContext;
import org.durcframework.rms.common.RMSContext;
import org.durcframework.rms.entity.RUser;
import org.durcframework.rms.service.RUserService;
import org.durcframework.rms.util.PasswordUtil;
import org.durcframework.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@Autowired
	private RUserService rUserService;

	/**
	 * 用户登陆
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("login.do")
	public ModelAndView login(RUser backUser) {

		if (StringUtils.hasText(backUser.getUsername())) {
			RUser user = rUserService.get(backUser.getUsername());
			if (user == null) {
				return ResultUtil.error("用户名密码不正确");
			}

			String password = backUser.getPassword();
			String correctHash = user.getPassword();

			boolean isPswdCorrect = PasswordUtil.validatePassword(password,
					correctHash);

			if (isPswdCorrect) {
				doLogin(user);
				return ResultUtil.success();
			}
		}

		return ResultUtil.error("用户名密码不正确");
	}

	private void doLogin(RUser user) {
		// 缓存当前用户角色权限
		RMSContext.getInstance().refreshUserRightData(user.getUsername());
		
		user.setLastLoginDate(new Date());
		UserContext.getInstance().setUser(user);
		rUserService.update(user);
	}

	/**
	 * 注销
	 * 
	 * @return
	 */
	@RequestMapping("logout.do")
	public ModelAndView logout() {
		RMSContext.getInstance().clearCurrentUserRightData();
		UserContext.getInstance().setUser(null);
		return ResultUtil.success();
	}

}
