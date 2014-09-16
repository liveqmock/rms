package org.durcframework.rms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.durcframework.controller.CrudController;
import org.durcframework.rms.entity.RRole;
import org.durcframework.rms.entity.RRoleSch;
import org.durcframework.rms.entity.RUserRole;
import org.durcframework.rms.service.RRoleService;
import org.durcframework.rms.service.RUserRoleService;
import org.durcframework.util.JsonUtil;
import org.durcframework.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RRoleController extends
        CrudController<RRole, RRoleService> {
	
	@Autowired
	private RUserRoleService userRoleService;

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
    
    @RequestMapping("/listRoleRelationInfo.do")
    public ModelAndView listRoleRelationInfo(int roleId){
    	
    	List<RUserRole> userRoles = userRoleService.getUserRoleByRoleId(roleId);
    	Map<String,Object> retMap = new HashMap<String, Object>();
    	
    	retMap.put("userRoles", userRoles);
    	retMap.put("success", true);
    	
    	String json = JsonUtil.toJsonString(retMap);
    	
		return ResultUtil.buildModelAndView(json);
	}
    
    // ------------
    @RequestMapping("/listAllRRole.do")
    public ModelAndView listAllRRole(RRoleSch searchEntity) {
    	return this.queryAll(searchEntity.buildExpressionQuery());
    }
  
}