package org.durcframework.rms.common;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * 属性文件管理器,可以获取Properties文件属性
 */
public enum PropertiesManager {
	instance;

	private Properties props;

	public static PropertiesManager getInstance() {
		return instance;
	}

	PropertiesManager() {
		// 默认读取config.properties
		Resource resource = new ClassPathResource("/config.properties");
		try {
			props = PropertiesLoaderUtils.loadProperties(resource);
		} catch (IOException e) {
			props = new Properties();
			e.printStackTrace();
		}
	}

	/**
	 * 根据key获取属性值
	 * 
	 * @param key
	 * @return
	 */
	public String get(String key) {
		return props.getProperty(key);
	}

	public static void main(String[] args) {
		System.out.println(PropertiesManager.getInstance().get("debugModel"));
	}

}
