package com.shibo.demo.controller.filters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;


//initParams实际上就是为了见名知意而已
@WebFilter(filterName = "Filter1",urlPatterns = {"/exception/*"},initParams = {@WebInitParam(name = "hello",value = "world",description = "#{}")})
@Order(1)
public class Filter1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter1 test");
        System.out.println(filterConfig.getInitParameter("hello"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException{

    }

    @Override
    public void destroy() {

    }
}
