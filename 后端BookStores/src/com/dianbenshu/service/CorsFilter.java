package com.dianbenshu.service;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class outLineFilter
 */
public class CorsFilter implements Filter {
	
	 public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain) throws IOException, ServletException  
	    {  
		System.out.println("已经拦截");
	    HttpServletResponse response = (HttpServletResponse) resp; 
	    
	    HttpServletRequest req = (HttpServletRequest) request;
	    
	    String origin = req.getHeader("Origin");
	    System.out.println(origin);
	    if(origin!= null && origin.length()>0){
	       response.setHeader("Access-Control-Allow-Origin", origin); 
	    }
	    
//	    response.setHeader("Access-Control-Allow-Credentials","true");
	    
//	    response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080"); //解决跨域访问报错   
	    response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");   
	    response.setHeader("Access-Control-Max-Age", "36000000"); //设置过期时间   
	    response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, client_id, uuid, Authorization"); 
	    response.setHeader("Access-Control-Allow-Credentials","true");
	    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 支持HTTP 1.1.   
	    response.setHeader("Pragma", "no-cache"); // 支持HTTP 1.0. response.setHeader("Expires", "0");   
	    chain.doFilter(request, resp);  
	    }   
	    public void init(FilterConfig filterConfig) {}   
	    public void destroy() {}  

}
