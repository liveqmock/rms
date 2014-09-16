package org.durcframework.rms.controller;

import org.durcframework.controller.CrudController;
import org.durcframework.rms.entity.RSysOperate;
import org.durcframework.rms.entity.RSysOperateSch;
import org.durcframework.rms.service.RSysOperateService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RSysOperateController extends
        CrudController<RSysOperate, RSysOperateService> {
	
    @RequestMapping("/addRSysOperate.do")
    public ModelAndView addRSysOperate(RSysOperate entity) {
        return this.save(entity);
    }

    @RequestMapping("/listRSysOperate.do")
    public ModelAndView listRSysOperate(RSysOperateSch searchEntity) {
        return this.queryByEntity(searchEntity);
    }

    @RequestMapping("/updateRSysOperate.do")
    public ModelAndView updateRSysOperate(RSysOperate enity) {
        return this.update(enity);
    }

    @RequestMapping("/delRSysOperate.do")
    public ModelAndView delRSysOperate(RSysOperate enity) {
        return this.delete(enity);
    }
}