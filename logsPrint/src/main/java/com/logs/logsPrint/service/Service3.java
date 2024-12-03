package com.logs.logsPrint.service;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class Service3 {
	
    public String method3() { 
    	log.info("Service 3 - Method 3 executed");
        return "Service3 - Method3 executed";
    }
}
