package org.durcframework.rms.controller;

import org.durcframework.common.UserContext;
import org.durcframework.controller.CrudController;
import org.durcframework.rms.entity.RUser;
import org.durcframework.rms.entity.RUserSch;
import org.durcframework.rms.service.RUserService;
import org.durcframework.rms.util.PasswordUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RUserController extends
        CrudController<RUser, RUserService> {

    @RequestMapping("/addRUser.do")
    public ModelAndView addRUser(RUser entity) {
    	String password = entity.getPassword(); // md5加密后的
		password = PasswordUtil.createHash(password);
		entity.setPassword(password);
        return this.save(entity);
    }

    @RequestMapping("/listRUser.do")
    public ModelAndView listRUser(RUserSch searchEntity) {
        return this.queryByEntity(searchEntity);
    }

    @RequestMapping("/updateRUser.do")
    public ModelAndView updateRUser(RUser enity) {
        return this.update(enity);
    }

    @RequestMapping("/delRUser.do")
    public ModelAndView delRUser(RUser enity) {
        return this.delete(enity);
    }
    
    @RequestMapping("/resetUserPassword.do")
    public ModelAndView resetUserPassword(RUser user){
    	String newPwsd = this.getService().resetUserPassword(user);
    	return success(newPwsd);
    }
    
    @RequestMapping("/updateUserPassword.do")
    public ModelAndView updateUserPassword(
    		String oldPswd
    		,String newPswd
    		,String newPswd2
    		){
    	
    	if(!newPswd.equals(newPswd2)){
    		return error("两次输入的新密码不一样");
    	}
    	RUser user = UserContext.getInstance().getUser();
    	RUser storeUser = this.getService().get(user.getUsername());
    	
    	boolean isPswdCorrect = PasswordUtil.validatePassword(oldPswd,
    			storeUser.getPassword());
    	
    	if(!isPswdCorrect){
    		return error("原密码输入有误");
    	}
    	
    	this.getService().updateUserPassword(storeUser,newPswd);
    	
    	return success();
    }
    
}