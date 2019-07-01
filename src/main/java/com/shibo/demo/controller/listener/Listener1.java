package com.shibo.demo.controller.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//使用各种监听器 xxxListener来进行监听，继承的是接口
//还能自定义很多监听器！ application...等
@WebListener
public class Listener1 implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().getServletContext().setAttribute("hello","world!");
        System.out.println("session Hello");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        se.getSession().getServletContext().setAttribute("hello","sucker!");
        System.out.println("session dead");
    }
}
