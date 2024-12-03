package com.logs.logsPrint.logging;

import java.util.UUID;

import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
public class LoggingConfiguration implements WebMvcConfigurer {

    public class LoggingInterceptor implements HandlerInterceptor {

    	@Override
    	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    	    String requestId = UUID.randomUUID().toString();
    	    MDC.put("requestId", requestId);
    	    MDC.put("method", request.getMethod());
    	    MDC.put("url", request.getRequestURL().toString());
    	    MDC.put("user", "Anonymous");
    	    MDC.put("clientIp", request.getRemoteAddr());       
    	    request.setAttribute("startTime", System.currentTimeMillis());
    	    return true;
    	}

        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {}

        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
            String responseCode = String.valueOf(response.getStatus());
            long startTime = (Long) request.getAttribute("startTime");
            long duration = System.currentTimeMillis() - startTime;

            MDC.put("responseCode", responseCode);
            MDC.put("responseTime", String.valueOf(duration));
            log.info(responseCode, duration);
            MDC.clear();
        }
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggingInterceptor());
    }
}
