package org.durcframework.rms.service;

import org.durcframework.rms.dao.RUserDao;
import org.durcframework.rms.entity.RUser;
import org.durcframework.service.CrudService;
import org.springframework.stereotype.Service;

@Service
public class RUserService extends CrudService<RUser, RUserDao> {

}
