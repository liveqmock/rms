package org.durcframework.rms.controller;

import org.durcframework.rms.entity.RSysRes;
import org.durcframework.rms.entity.RSysResSch;
import org.durcframework.rms.service.RSysResService;
import org.durcframework.controller.CrudController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RSysResController extends
        CrudController<RSysRes, RSysResService> {

    @RequestMapping("/addRSysRes.do")
    public ModelAndView addRSysRes(RSysRes entity) {
        return this.save(entity);
    }

    @RequestMapping("/listRSysRes.do")
    public ModelAndView listRSysRes(RSysResSch searchEntity) {
        return this.queryAll(searchEntity.buildExpressionQuery());
    }

    @RequestMapping("/updateRSysRes.do")
    public ModelAndView updateRSysRes(RSysRes enity) {
        return this.update(enity);
    }

    @RequestMapping("/delRSysRes.do")
    public ModelAndView delRSysRes(RSysRes enity) {
    	if(this.getService().hasChild(enity)){
    		return error(enity.getResName() + "下含有子节点,不能删除.");
    	}
        return this.delete(enity);
    }
    
}