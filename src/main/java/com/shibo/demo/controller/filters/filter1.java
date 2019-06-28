//package com.shibo.demo.controller.filters;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import java.io.IOException;
//import java.util.Enumeration;
//
//@WebFilter(urlPatterns = "/*")
//public class filter1 implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println(filterConfig.getFilterName()+"  "+filterConfig.getServletContext());
//        Enumeration<String> initParameterNames = filterConfig.getInitParameterNames();
//        StringBuilder sb=new StringBuilder();
//        while (initParameterNames.hasMoreElements()){
//            sb.append(initParameterNames.nextElement()+" ");
//        }
//        System.out.println(sb);
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println(servletRequest);
//        System.out.println(servletResponse);
//        System.out.println(filterChain);
//    }
//
//    @Override
//    public void destroy() {
//        System.out.println("filter dead!");
//    }
//}
