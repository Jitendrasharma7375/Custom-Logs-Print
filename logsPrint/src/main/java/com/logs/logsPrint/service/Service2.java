package com.logs.logsPrint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class Service2 {

	@Autowired
    private Service3 service3;

    public String method2() {
    	log.info("Service 2 - Method 2 executed");
		String result = service3.method3();
		return result;
	}
}