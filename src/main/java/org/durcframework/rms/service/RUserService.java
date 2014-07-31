package org.durcframework.rms.service;

import org.durcframework.rms.dao.RUserDao;
import org.durcframework.rms.entity.RUser;
import org.durcframework.rms.util.PasswordUtil;
import org.durcframework.service.CrudService;
import org.springframework.stereotype.Service;

@Service
public class RUserService extends CrudService<RUser, RUserDao> {

	/**
	 * 重置用户密码
	 * @param user
	 * @return 返回明文密码
	 */
	public String resetUserPassword(RUser user){
		
		String password = createNewPswd();
		
		String hash = PasswordUtil.createStorePswd(password);
		
		user.setPassword(hash);
		
		this.update(user);
		
		return password;
	}
	
	public void updateUserPassword(RUser user,String md5Pswd){    	
		user.setPassword(PasswordUtil.createHash(md5Pswd));    	
    	update(user);
	}
	
	/**
	 * 生成随机密码,由三个小写字母+三个数字组成
	 * @return
	 */
	public static String createNewPswd(){
		StringBuilder pswd = new StringBuilder();
		
		// 随机三个小写英文字母
		for (int i = 0; i < 3; i++) {
			// ascii码 97~122
			char ascii = (char) ((int)(Math.random() * 26) + 97);
			pswd.append(ascii);
		}
		// 随机三个1~9的数
		for (int i = 0; i < 3; i++) {
			int num = (int)(Math.random() * 9) + 1;
			pswd.append(num);
		}
		
		return pswd.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(createNewPswd());
	}
	
}
