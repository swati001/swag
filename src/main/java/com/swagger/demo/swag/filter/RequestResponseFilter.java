package com.swagger.demo.swag.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

@Component
@Order(2)
public class RequestResponseFilter implements Filter {
	
	public void init(FilterConfig filterConfig)
	         throws ServletException {
		System.out.println("Initialized RequestResponsefilter");
	}
	
    public void destroy() {
        
    }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		
		chain.doFilter(httpRequest, httpResponse);
		
		System.out.println("simple request content logging "+httpRequest.getContentType());
		
		if (httpRequest.getContentType() !=null && httpRequest.getContentType().contains("json")) {
		
			if (httpRequest instanceof ContentCachingRequestWrapper) {
				ContentCachingRequestWrapper wrappedRequest = (ContentCachingRequestWrapper)httpRequest;
				System.out.println("wrapped request content logging "+wrappedRequest.getContentType());
			}
			if (httpResponse instanceof ContentCachingRequestWrapper) {
				ContentCachingResponseWrapper wrappedResponse = (ContentCachingResponseWrapper)httpResponse;
				System.out.println("wrapped response logging "+wrappedResponse);
			}
		}
		
	}

}
