package org.durcframework.rms.controller;

import org.durcframework.controller.CrudController;
import org.durcframework.rms.entity.RRole;
import org.durcframework.rms.entity.RRoleSch;
import org.durcframework.rms.service.RRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RRoleController extends
        CrudController<RRole, RRoleService> {

    @RequestMapping("/addRRole.do")
    public ModelAndView addRRole(RRole entity) {
        return this.save(entity);
    }

    @RequestMapping("/listRRole.do")
    public ModelAndView listRRole(RRoleSch searchEntity) {
        return this.queryByEntity(searchEntity);
    }

    @RequestMapping("/updateRRole.do")
    public ModelAndView updateRRole(RRole enity) {
        return this.update(enity);
    }

    @RequestMapping("/delRRole.do")
    public ModelAndView delRRole(RRole enity) {
        return this.delete(enity);
    }
    
    // ------------
    @RequestMapping("/listAllRRole.do")
    public ModelAndView listAllRRole(RRoleSch searchEntity) {
    	return this.queryAll(searchEntity.buildExpressionQuery());
    }
  
}