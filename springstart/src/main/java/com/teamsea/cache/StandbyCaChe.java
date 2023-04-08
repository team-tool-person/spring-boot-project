package com.teamsea.cache;

import org.springframework.stereotype.Component;

/**
 * 	备用CaCahe类
 * 
 * */
@Component("standbyCaChe")
public class StandbyCaChe implements CaChe {
	
	@Override
	public String caChe() {
		return "StandbyCaChe";
	}

}
