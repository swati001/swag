package com.swagger.demo.swag.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.jboss.logging.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MDCFilter implements Filter {
	
	public void init(FilterConfig filterConfig)
	         throws ServletException {
		System.out.println("Initialized MDC");
	    }
	    public void destroy() {
	       
	    }
		@Override
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				throws IOException, ServletException {
			
			MDC.put("content-type", request.getContentType());
			chain.doFilter(request, response);
		}

}
