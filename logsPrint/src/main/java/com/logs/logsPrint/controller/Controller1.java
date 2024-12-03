package com.logs.logsPrint.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logs.logsPrint.service.Service1;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;


@RestController
@Log4j2
public class Controller1 {
	
	@Autowired
    private Service1 service1;
   
    @GetMapping("/start1")
    public String start(HttpServletRequest request) {
        log.info("Controlled 1 started");
        return service1.method1();
    }
}
