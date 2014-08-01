package org.durcframework.rms.common;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.durcframework.common.UserContext;
import org.durcframework.rms.entity.RUser;

public class RMSSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		RUser user = UserContext.getInstance().getUser(event.getSession());
		if(user != null){
			RMSContext.getInstance().clearUserRightData(user.getUsername());
		}
	}

}
