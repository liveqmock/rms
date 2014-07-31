package org.durcframework.rms.controller;

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
    	String password = entity.getPassword();
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
    
}