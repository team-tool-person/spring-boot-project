package com.teamsea.cache;

import org.springframework.stereotype.Component;

/**
 * 	默认加载的CaChe类
 * 
 * */

@Component("defaultCaChe")
public class DefaultCaChe implements CaChe {
	@Override
	public String caChe() {
		return "DefaultCaChe";
	}
}
