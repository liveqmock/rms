package org.durcframework.rms.controller;

import java.util.List;

import org.durcframework.controller.CrudController;
import org.durcframework.processor.JsonObjProcessor;
import org.durcframework.rms.entity.AddOperateParam;
import org.durcframework.rms.entity.RRole;
import org.durcframework.rms.entity.RSysFunction;
import org.durcframework.rms.entity.RSysFunctionSch;
import org.durcframework.rms.entity.RSysOperate;
import org.durcframework.rms.entity.RSysRes;
import org.durcframework.rms.service.AddOperateService;
import org.durcframework.rms.service.RRolePermissionService;
import org.durcframework.rms.service.RRoleService;
import org.durcframework.rms.service.RSysFunctionService;
import org.durcframework.rms.service.RSysOperateService;
import org.durcframework.rms.service.RSysResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

@Controller
public class RSysFunctionController extends
        CrudController<RSysFunction, RSysFunctionService> {
	@Autowired
	private RSysOperateService sysOperateService;
	@Autowired
	private RRoleService roleService;
	@Autowired
	private AddOperateService addOperateService;
	@Autowired
	private RSysResService resService;
	@Autowired
	private RRolePermissionService permissionService;
	
	
    @RequestMapping("/addRSysFunction.do")
    public ModelAndView addRSysFunction(AddOperateParam addOperateParam) {
    	RSysOperate operate = sysOperateService.get(addOperateParam.getOperateCode());
    	if(operate == null){
    		return error("操作类型不存在");
    	}
    	RSysRes res = resService.get(addOperateParam.getSrId());
    	if(res == null){
    		return error("资源不存在");
    	}
    	if(CollectionUtils.isEmpty(addOperateParam.getRoleId())){
    		return error("请选择角色");
    	}
    	
		addOperateService.add(res,operate,addOperateParam.getRoleId());
		
		return success();
    }
    
    @RequestMapping("/listRSysFunction.do")
    public ModelAndView listRSysFunction(RSysFunctionSch searchEntity) {
    	
        return this.queryByEntityWithProcessor(searchEntity, new JsonObjProcessor<RSysFunction>() {
			@Override
			public void process(RSysFunction entity, JSONObject jsonObject) {
				RSysOperate operate = sysOperateService.get(entity.getOperateCode());
				jsonObject.put("operateName", operate.getOperateName());
				jsonObject.put("operateCode", operate.getOperateCode());
				
				List<RRole> roles = roleService.getRolesBySysFunction(entity);
				jsonObject.put("roles", roles);
			}
		});
    }

    @RequestMapping("/setSysFunctionRole.do")
    public ModelAndView setSysFunctionRole(AddOperateParam addOperateParam,int sfId) {
    	this.permissionService.setSysFunctionRole(sfId, addOperateParam.getRoleId());
        return success();
    }

    @RequestMapping("/delRSysFunction.do")
    public ModelAndView delRSysFunction(RSysFunction sysFunction) {
        return this.delete(sysFunction);
    }
    
}