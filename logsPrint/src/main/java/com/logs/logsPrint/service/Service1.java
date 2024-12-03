package com.logs.logsPrint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class Service1 {

	@Autowired
    private Service2 service2;
	
    public String method1() {
    	log.warn("Service 1 - Method 1 executed");
        String result = service2.method2(); 
        return result;
    }
}
