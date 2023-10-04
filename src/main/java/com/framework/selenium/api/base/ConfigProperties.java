package com.framework.selenium.api.base;
import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config.properties"})
public interface ConfigProperties extends Config  {
	String webdriverurl();
	
}
